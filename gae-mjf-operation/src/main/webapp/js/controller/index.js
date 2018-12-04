MALABARISTAS_APP.controller('IndexCtrl', [ "$scope", "$route", "indexReport","$window","$timeout","$interval","SharedDataService", function($scope, $route, indexReport,$window,$timeout,$interval,SharedDataService) {

	/* 変数・関数定義 */
	SharedDataService.jobState = "  loading...";
	var delay = 1000;  // $timeout()の遅延

	// datastudioUriの取得 & dataflowJobStateの更新
	var updateJobState = function(){
		indexReport.setUp().success(function(res){
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

	/* 処理 */
	// 読み込み時の処理
	$scope.load = function() {
		console.log('Welcome!');
  	}

	// jobStateが変わった時の処理
	$scope.$watch(function(){
		return SharedDataService.jobState;
	}, function(newVal, oldVal){
		console.log("jobState has updated. : " + oldVal + " -> " + newVal);
		$scope.job_state = SharedDataService.jobState;
		$scope.job_state_message = SharedDataService.jobStateMessage;
	});

	// タイトルをクリックした時の処理
	$scope.clickTitle=function(){
		if($window.location = "#/home"){
			$route.reload();
		}
		else{
			$window.location.href  = "#/home"
		}
	};

	// [起動]ボタンを押した時の処理
	$scope.startDataflowJob = function(){
		indexReport.startDataflowJob().success(function(res){
			if(res.result=="REDIRECT"){
				console.log("REDIRECT")
				$window.location.href = res.message;
			} else if(res.jobState == "READY"){
				swal({
					title: "WARNING",
					text: "検索エンジンはすでに起動中です。\n検索を実行できます。",
					icon: "warning",
					button: "OK",
				});
			} else if (res.jobState == "RUNNING"){
				swal({
					title: "WARNING",
					text: "検索エンジンは現在実行中です。\n現在の検索が終了するのを待ってください。",
					icon: "warning",
					button: "OK",
				});
			} else {
				swal({
					title: "検索エンジンを起動します。",
					text: "起動には3分ほど時間がかかる場合があります。",
					icon: "success",
					button: "OK",
				});
				SharedDataService.jobState = "  loading...";
				SharedDataService.jobStateMessage = "";
				$timeout(function(){
					updateJobState();
				}, delay);
			}
		}).error(function(res){
			swal({
				title: "WARNING",
				text: "検索エンジンの起動に失敗しました。",
				icon: "warning",
				button: "OK",
			});
		})
	}

	// [停止]ボタンを押した時の処理
	$scope.stopDataflowJob = function(){
		indexReport.stopDataflowJob().success(function(res){
			if(res.result=="REDIRECT"){
				console.log("REDIRECT")
				$window.location.href = res.message;
			} else if(res.jobState == "READY"){
				swal({
					title: "検索エンジンを停止します。",
					text: "停止には3分ほど時間がかかります。",
					icon: "success",
					button: "OK",
				});
				SharedDataService.jobState = "  loading...";
				SharedDataService.jobStateMessage = "";
				$timeout(function(){
					updateJobState();
				}, delay);
			} else if (res.jobState == "RUNNING"){
				swal({
					title: "WARNING",
					text: "検索エンジンは現在実行中です。\n現在の検索が終了するのを待ってください。",
					icon: "warning",
					button: "OK",
				});
			} else {
				swal({
					title: "WARNING",
					text: "検索エンジンはすでに停止しています。",
					icon: "warning",
					button: "OK",
				});
			}
		}).error(function(res){
			swal({
				title: "WARNING",
				text: "検索エンジンの停止に失敗しました。",
				icon: "warning",
				button: "OK",
			});
		})
	}

	// cssでjob_stateごとに色を割振る
	$scope.assignJobStateColor = function(job_state) {
		return {
			ready_color: job_state == 'READY',
			running_color: job_state == 'RUNNING',
			not_ready_color: job_state == 'NOT READY',
		}
	};
}]);