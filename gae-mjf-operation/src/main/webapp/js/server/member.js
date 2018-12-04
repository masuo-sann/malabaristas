MALABARISTAS_APP.factory('memberRepo', ["$http", "$httpParamSerializerJQLike", function($http, $httpParamSerializerJQLike){
	return {
		collectMemberList:function(){
			console.log("memberリスト取得のリクエスト");
			return $http({
				method:"POST",
				url: "/api/datastore",
				transformRequest: $httpParamSerializerJQLike,
				headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
				data: {method:"collectMemberList"}
			});
		},
		addMemberRequest: function(
				lastName, firstName, grade,
				qualificationOfLight, qualificationOfLightManagement,
				lightOperator, musicOperator, toolPerson,
				markingStage, linoCovering, stage, seats, twistingBind, tyingBind, guard,
				hungingCurtain, hungingLights, shoot, foldingCurtain
				){
			console.log("登録リクエストの送信");
			return $http({
				method:"POST",
				url: "/api/datastore",
				transformRequest: $httpParamSerializerJQLike,
				headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
				data: {method:"addMember",
					lastName:lastName, firstName:firstName, grade:grade,
					qualificationOfLight:qualificationOfLight, qualificationOfLightManagement:qualificationOfLightManagement,
					lightOperator:lightOperator, musicOperator:musicOperator, toolPerson:toolPerson,
					markingStage:markingStage, linoCovering:linoCovering, stage:stage, seats:seats,
					twistingBind:twistingBind, tyingBind:tyingBind, guard:guard,
					hungingCurtain:hungingCurtain, hungingLights:hungingLights, shoot:shoot, foldingCurtain:foldingCurtain
					}
			});
		},
		updateMemberRequest: function(
				strKey,
				lastName, firstName, grade,
				qualificationOfLight, qualificationOfLightManagement,
				lightOperator, musicOperator, toolPerson,
				markingStage, linoCovering, stage, seats, twistingBind, tyingBind, guard,
				hungingCurtain, hungingLights, shoot, foldingCurtain
				){
			console.log("登録リクエストの送信 strKey=" + strKey);
			return $http({
				method:"POST",
				url: "/api/datastore",
				transformRequest: $httpParamSerializerJQLike,
				headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
				data: {method:"updateMember", strKey:strKey,
					lastName:lastName, firstName:firstName, grade:grade,
					qualificationOfLight:qualificationOfLight, qualificationOfLightManagement:qualificationOfLightManagement,
					lightOperator:lightOperator, musicOperator:musicOperator, toolPerson:toolPerson,
					markingStage:markingStage, linoCovering:linoCovering, stage:stage, seats:seats,
					twistingBind:twistingBind, tyingBind:tyingBind, guard:guard,
					hungingCurtain:hungingCurtain, hungingLights:hungingLights, shoot:shoot, foldingCurtain:foldingCurtain
					}
			});
		},
	}
}]);
