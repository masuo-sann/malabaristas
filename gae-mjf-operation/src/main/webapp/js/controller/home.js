MALABARISTAS_APP.controller('HomeCtrl',["$scope", "$route","homeRepo","$window", "$timeout","SharedDataService", function($scope, $route,homeRepo,$window, $timeout, SharedDataService) {

	/* 変数・関数の定義 */

	/* 初期値 */
	$scope.msg = "Welcome！!";
	$scope.analysis_option_sentiment = "false";
	$scope.analysis_option_entity = "false";
	$scope.searching=[{search_word:"検索ワードの取得中…"},{request_number:""},{register_date:""}];


	/* 検索ボタンを押した時の機能 */
	$scope.search = function() {
		var name = $scope.search_word;

		homeRepo.test(name).success(function(resp){
			console.log("searchRequestのresponse：" + resp.result);
		}).error(function(res) {
			console.log("searchRequestのエラー")
			swal({
				title: "WARNING",
				text: "テストに失敗しました。",
				icon: "warning",
				button: "OK",
			});
		})
	};
}]);
