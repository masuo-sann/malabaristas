MALABARISTAS_APP.controller('MemberCtrl',["$scope", "$route","memberRepo","$window", "$timeout", "SharedDataService", function($scope, $route,memberRepo,$window, $timeout, SharedDataService) {

	/* 変数・関数の定義 */

	var resetParams = function(){
		console.log("パラメータをリセット")
		$scope.modalFlag = false;

		$scope.name = null;
		$scope.nameRubi = null;
		$scope.grade = null;
		$scope.qualificationOfLight = false;
		$scope.qualificationOfLightManagement = false;

		$scope.stage = 0;
		$scope.hungingCurtain = 0;
		$scope.hungingLights = 0;
	}

	/* 初期値 */
	$scope.msg = "Welcome！!";
	resetParams();

	$scope.openModal = function(){
		$scope.modalFlag = true;
	}

	$scope.closeModal = function(){
		resetParams();
	}

	/* 追加ボタンを押した時の機能
	 * 新規メンバーの登録 */
	$scope.addMember = function() {
		var name = $scope.name;
		var nameRubi = $scope.nameRubi;
		var grade = $scope.grade;
		var qualificationOfLight = $scope.qualificationOfLight;
		var qualificationOfLightManagement = $scope.qualificationOfLightManagement;
		var stage = $scope.stage;
		var hungingCurtain = $scope.hungingCurtain;
		var hungingLights = $scope.hungingLights;

		if(!$scope.name || !$scope.nameRubi || !$scope.grade){
			swal({
				title: "WARNING",
				text: "フォームを完了してください！",
				icon: "warning",
				button: "OK",
			});
		} else {
			console.log("登録します");
			memberRepo.addMemberRequest(name, nameRubi, grade, qualificationOfLight, qualificationOfLightManagement, stage,
					hungingCurtain, hungingLights).success(function(resp){
				console.log("addRequestのresponse：" + resp.result);
				swal({
					title: "登録完了しました",
					text: "やったね！",
					icon: "success",
					button: "OK!",
				});
				resetParams();
			}).error(function(resp) {
				console.log("addRequestのエラー")
				swal({
					title: "WARNING",
					text: "メンバーの追加に失敗しました。",
					icon: "warning",
					button: "OK",
				});
				return;
			})
		}

	};
}]);
