MALABARISTAS_APP.controller('HomeCtrl',["$scope", "$route","egoSearchRepo","$window", "$timeout","SharedDataService", function($scope, $route,egoSearchRepo,$window, $timeout, SharedDataService) {

	/* 変数・関数の定義 */
	var updateJobState = function(){
		SharedDataService.jobState = "  loading...";
		SharedDataService.jobStateMessage = "";
		egoSearchRepo.setUp().success(function(res){
			console.log("datastudiouri = " + res.datastudioUri);
			$scope.datastudio_uri = res.datastudioUri;
			console.log("jobState = " + res.jobState)
			if(res.jobState=="READY"){
				SharedDataService.jobState = "READY";
				SharedDataService.jobStateMessage = "検索を実行できます。すぐに検索しない場合は検索エンジンを停止してください。"
			} else if (res.jobState=="RUNNING"){
				SharedDataService.jobState = "RUNNING";
				SharedDataService.jobStateMessage = "検索を実行中です。終了するまで待ってください。"
			} else if (res.jobState=="NO_ACTIVE_JOB"){
				SharedDataService.jobState = "NOT READY";
				SharedDataService.jobStateMessage = "検索を実行するには検索エンジンを起動してください。"
			}
		}).error(function(res){
			alert("データベースへの接続に失敗しました。");
		})
	};

	/* 初期値 */
	$scope.msg = "Welcome！!";
	$scope.analysis_option_sentiment = "false";
	$scope.analysis_option_entity = "false";
	$scope.searching=[{search_word:"検索ワードの取得中…"},{request_number:""},{register_date:""}];

	/* 処理 */
	// ログイン機能 & API"collectSearchingWord"を実行して「現在検索中のキーワード」を取得
	egoSearchRepo.collectSearchingWord().success(function(res){
		res["result"];res["message"];
		if(res.result=="REDIRECT"){
			console.log("REDIRECT")
			$window.location.href = res.message;
		} else { // 検索中データの取得
			var searchwords=[];
			for(var i in res){
				searchwords.push(res[i]);
			}
			$scope.searching=searchwords;
			console.log(searchwords);
			if(searchwords.length==0){
				$scope.searching=[{search_word:"検索中のワードはありません"},{request_number:""},{register_date:""}];
			}
		}
	}).error(function(res) {
		swal({
			title: "WARNING",
			text: "検索データの取得に失敗しました。",
			icon: "warning",
			button: "OK",
		});
	})

	/* 検索ボタンを押した時の機能
	 * ログイン確認 & API"searchdata"を実行して検索リクエストを送信 */
	$scope.search = function() {
		var searchWord = $scope.search_word;
		var requestNumber = $scope.request_number;
		if(!$scope.search_word){
			console.log("検索ワードが指定されていません");
			swal({
				title: "WARNING",
				text: "検索ワードを指定してください！",
				icon: "warning",
				button: "OK",
			});
		} else if (!$scope.request_number){
			console.log("検索件数が指定されていません");
			swal({
				title: "WARNING",
				text: "検索件数を指定してください！",
				icon: "warning",
				button: "OK",
			});
  		} else {
			var analysisOption
			if($scope.analysis_option_sentiment=="true"){
				if($scope.analysis_option_entity=="true"){
					analysisOption = "DEFAULT";
				}
				else{
					analysisOption = "WITHOUT_ENTITY_ANALYSIS";
				}
			} else {
				if($scope.analysis_option_entity=="true"){
					analysisOption = "WITHOUT_SENTIMENT_ANALYSIS";
				}
				else{
					analysisOption = "WITHOUT_ANALYSIS";
				}
			}
			console.log("サーバーへ検索リクエスト:analysisOption = " + analysisOption);
  			egoSearchRepo.searchRequest(searchWord, requestNumber, analysisOption).success(function(resp){
				console.log("searchRequestのresponse：" + resp.result);
				if(resp.result=="REDIRECT"){
					console.log("REDIRECT")
					$window.location.href = resp.message;
				} else if (resp.jobState == "RUNNING"){
					swal({
						title: "WARNING",
						text: "検索中のワードがあります。\n検索が終了してから検索してください。",
						icon: "warning",
						button: "OK",
					});
				} else if(resp.jobState == "NO_ACTIVE_JOB"){
					swal({
						title: "WARNING",
						text: "検索エンジンが停止しています。\n起動してから検索し直してください。",
						icon: "warning",
						button: "OK",
					});
				} else {
					$scope.msg = '検索ワード：「' + $scope.search_word + '」、 検索件数：' + $scope.request_number + "件";
					swal({
						title: "検索を開始しました。",
						text: "検索が終わるまで少々お待ちください。",
						icon: "success",
						button: "OK!",
					});
					var delay = 3000; // NO_RESULTSかを確認しに行くまでの待ち時間
					console.log("3秒待って確認")
					$timeout(function(){
						egoSearchRepo.reportResult(resp.datastoreId).success(function(resp){
							console.log("reportResultのresponse：" + resp.result);
							if (resp.result == "NO_RESULTS"){
								swal({
									title: "WARNING",
									text: "検索結果が存在しませんでした。",
									icon: "warning",
									button: "OK",
								});
							} else {
								console.log("検索結果は1件以上存在します")
							}
						}).error(function(resp){
							console.log("reportResultのエラー")
							swal({
								title: "WARNING",
								text: "検索時にエラーが発生しました。",
								icon: "warning",
								button: "OK",
							});
						})
					}, delay);
					$timeout(function(){
						updateJobState();
					}, 1000);
				}
			}).error(function(res) {
				console.log("searchRequestのエラー")
				swal({
					title: "WARNING",
					text: "検索リクエストに失敗しました。",
					icon: "warning",
					button: "OK",
				});
			})
		}
	};
}]);
