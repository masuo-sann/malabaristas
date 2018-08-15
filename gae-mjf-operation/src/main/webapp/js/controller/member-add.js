MALABARISTAS_APP.controller('MemberAddCtrl',["$scope", "$route","memberRepo","$window", "$timeout", "$uibModalInstance", "SharedDataService", function($scope, $route,memberRepo,$window, $timeout, $uibModalInstance, SharedDataService) {

	/* 変数・関数の定義 */

	/* 初期値 */
	$scope.msg = "Welcome！!";

	$scope.closeModal = function(){
		console.log("modalを閉じます");
		$uibModalInstance.dismiss();
	}

	/* 追加ボタンを押した時の機能
	 * 新規メンバーの登録 */
	$scope.addMember = function() {
		var name = $scope.name;
		var nameRubi = $scope.nameRubi;
		var grade = $scope.grade;
		var qualificationOfLight = $scope.qualificationOfLight;
		var qualificationOfLightManagement = $scope.qualificationOfLightManagement;
		var experienceOfStage = $scope.experienceOfStage;
		var experienceOfHangingCurtain = $scope.experienceOfHangingCurtain;
		var experienceOfHangingLights = $scope.experienceOfHangingLights;

		if(!$scope.name || !$scope.nameRubi || !$scope.grade){
			swal({
				title: "WARNING",
				text: "フォームを完了してください！",
				icon: "warning",
				button: "OK",
			});
		} else {
			console.log("登録します");
			memberRepo.addMemberRequest(name, nameRubi, grade, qualificationOfLight, qualificationOfLightManagement, experienceOfStage,
					experienceOfHangingCurtain, experienceOfHangingLights).success(function(resp){
				console.log("addRequestのresponse：" + resp.result);
				swal({
					title: "登録完了しました",
					text: "やったね！",
					icon: "success",
					button: "OK!",
				});
			}).error(function(resp) {
				console.log("addRequestのエラー")
				swal({
					title: "WARNING",
					text: "メンバーの追加に失敗しました。",
					icon: "warning",
					button: "OK",
				});
			})
		}
	};
}]);
