MALABARISTAS_APP.controller('MemberCtrl',["$scope", "$route","memberRepo","$window", "$timeout", "SharedDataService", function($scope, $route,memberRepo,$window, $timeout, SharedDataService) {

	/* 変数・関数の定義 */

	var memberList = [];
	var memberVar;

	var lastName;
	var firstName;
	var grade;

	var qualificationOfLight;
	var qualificationOfLightManagement;

	var lightOperator;
	var musicOperator;
	var toolPerson;

	var markingStage;
	var linoCovering;
	var stage;
	var seats;
	var twistingBind;
	var tyingBind;
	var guard;
	var hungingCurtain;
	var hungingLights;
	var shoot;
	var foldingCurtain;

	var where;
	var status;
	var rest;

	// ブラウザからjsへ
	var bindParams = function(){
		lastName = $scope.lastName;
		firstName = $scope.firstName;
		grade = $scope.grade;

		qualificationOfLight = $scope.qualificationOfLight;
		qualificationOfLightManagement = $scope.qualificationOfLightManagement;

		lightOperator = $scope.lightOperator;
		musicOperator = $scope.musicOperator;
		toolPerson = $scope.toolPerson;

		markingStage = $scope.markingStage;
		linoCovering = $scope.linoCovering;
		stage = $scope.stage;
		seats = $scope.seats;
		twistingBind = $scope.twistingBind;
		tyingBind = $scope.tyingBind;
		guard = $scope.guard;
		hungingCurtain = $scope.hungingCurtain;
		hungingLights = $scope.hungingLights;
		shoot = $scope.shoot;
		foldingCurtain = $scope.foldingCurtain;
		where = $scope.where;
		status = $scope.status;
		rest = $scope.rest;
	}

	var resetParams = function(){
		console.log("パラメータをリセット")
		$scope.modalFlag = false;
		$scope.profileModalFlag = false;

		$scope.lastName = null;
		$scope.firstName = null;
		$scope.grade = null;

		$scope.qualificationOfLight = false;
		$scope.qualificationOfLightManagement = false;

		$scope.lightOperator = false;
		$scope.musicOperator = false;
		$scope.toolPerson = false;

		$scope.markingStage = 0;
		$scope.linoCovering = 0;
		$scope.stage = 0;
		$scope.seats = 0;
		$scope.twistingBind = 0;
		$scope.tyingBind = 0;
		$scope.guard = 0;
		$scope.hungingCurtain = 0;
		$scope.hungingLights = 0;
		$scope.shoot = 0;
		$scope.foldingCurtain = 0;

		$scope.where = null;
		$scope.status = null;
		$scope.rest = 0;
	}

	/* 初期値 */
	resetParams();

	$scope.openModal = function(){
		$scope.modalFlag = true;
	}

	$scope.closeModal = function(){
		resetParams();
	}

	$scope.closeProfileModal = function(){
		resetParams();
	}

	// 登録ボタンを押した時の機能
	$scope.addMember = function() {
		bindParams();
		if(!lastName || !firstName || !grade){
			swal({
				title: "WARNING",
				text: "フォームを完了してください！",
				icon: "warning",
				button: "OK",
			});
		} else {
			console.log("登録します");
			memberRepo.addMemberRequest(
					lastName, firstName, grade,
					qualificationOfLight, qualificationOfLightManagement,
					lightOperator, musicOperator, toolPerson,
					markingStage, linoCovering, stage, seats, twistingBind, tyingBind, guard,
					hungingCurtain, hungingLights, shoot, foldingCurtain
					).success(function(resp){
				console.log("addMemberRequestのresponse：" + resp);
				swal({
					title: "登録完了しました",
					text: "やったね！",
					icon: "success",
					button: "OK!",
				});
				resetParams();
			}).error(function(resp) {
				console.log("addMemberRequestのエラー")
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

	// 更新ボタン
	$scope.collectMemberList = function() {
		memberRepo.collectMemberList().success(function(resp){
			console.log("memberリスト取得に成功")
			memberList = [];  // memberListを一度リセット
			for (var i in resp.memberList) {
				console.log("[DEBUG] memberList: " + i + resp.memberList[i]);
				memberList.push(resp.memberList[i]);
			}
			$scope.memberList = memberList;
			swal({
				title: "Memberリストの取得に成功しました。",
				text: "やったで〜！",
				icon: "success",
				button: "OK!",
			});
		}).error(function(resp) {
			console.log("collectMemberListのエラー")
			swal({
				title: "WARNING",
				text: "メンバーの追加に失敗しました。",
				icon: "warning",
				button: "OK",
			});
			return;
		})
	};

	$scope.showMore = function(member) {
		$scope.profileModalFlag = true;
		memberVar = member;

		$scope.lastName = member.lastName;
		$scope.firstName = member.firstName;
		$scope.grade = member.grade;
		$scope.qualificationOfLight = member.qualificationOfLight;
		$scope.qualificationOfLightManagement = member.qualificationOfLightManagement;

		$scope.lightOperator = member.lightOperator;
		$scope.musicOperator = member.musicOperator;
		$scope.toolPerson = member.toolPerson;

		$scope.markingStage = member.markingStage;
		$scope.linoCovering = member.linoCovering;
		$scope.stage = member.stage;
		$scope.seats = member.seats;
		$scope.twistingBind = member.twistingBind;
		$scope.tyingBind = member.tyingBind;
		$scope.guard = member.guard;
		$scope.hungingCurtain = member.hungingCurtain;
		$scope.hungingLights = member.hungingLights;
		$scope.shoot = member.shoot;
		$scope.foldingCurtain = member.foldingCurtain;
		$scope.where = member.where;
		$scope.status = member.status;
		// $scope.rest = member.rest;
	};

	// member情報の更新
	$scope.updateMember = function() {
		bindParams();
		console.log("member = " + memberVar.strKey);
		if(!lastName || !firstName || !grade){
			swal({
				title: "WARNING",
				text: "フォームを完了してください！",
				icon: "warning",
				button: "OK",
			});
		} else {
			console.log("更新します");
			memberRepo.updateMemberRequest(
					memberVar.strKey,
					lastName, firstName, grade,
					qualificationOfLight, qualificationOfLightManagement,
					lightOperator, musicOperator, toolPerson,
					markingStage, linoCovering, stage, seats, twistingBind, tyingBind, guard,
					hungingCurtain, hungingLights, shoot, foldingCurtain
					).success(function(resp){
				console.log("updateMemberRequestのresponse：" + resp.result);
				swal({
					title: "更新完了しました",
					text: "さっすが〜！",
					icon: "success",
					button: "OK!",
				});
				resetParams();
			}).error(function(resp) {
				console.log("updateMemberRequestのエラー")
				swal({
					title: "WARNING",
					text: "メンバー情報の更新に失敗しました。",
					icon: "warning",
					button: "OK",
				});
				return;
			})
		}
	};

}]);
