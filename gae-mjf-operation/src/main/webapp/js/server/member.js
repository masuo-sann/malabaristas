MALABARISTAS_APP.factory('memberRepo', ["$http", "$httpParamSerializerJQLike", function($http, $httpParamSerializerJQLike){
	return {
		collectSearchingWord:function(){
			console.log("ログイン確認 &「現在検索中のキーワード」のリクエスト");
			return $http({
				method:"POST",
				url: "/api/collect-searching-word!request-searching-word",
				transformRequest: $httpParamSerializerJQLike,
				headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
				data: {state:"#"}
			});
		},
		addMemberRequest: function(name, nameRubi, grade, qualificationOfLight, qualificationOfLightManagement, stage,
				hangingCurtain, hangingLights){
			console.log("登録リクエストの送信");
			return $http({
				method:"POST",
				url: "/api/datastore",
				transformRequest: $httpParamSerializerJQLike,
				headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
				data: {method:"addMember", name:name, nameRubi:nameRubi, grade:grade, qualificationOfLight:qualificationOfLight,
					qualificationOfLightManagement:qualificationOfLightManagement, stage:stage,
					hangingCurtain:hangingCurtain, hangingLights:hangingLights}
			});
		},
	}
}]);
