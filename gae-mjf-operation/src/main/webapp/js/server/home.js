MALABARISTAS_APP.factory('homeRepo', ["$http", "$httpParamSerializerJQLike", function($http, $httpParamSerializerJQLike){
	return {
		test: function(name){
			console.log("ログイン確認 & 検索ワード、検索件数のリクエストを送信");
			return $http({
				method:"POST",
				url: "/api/datastore",
				transformRequest: $httpParamSerializerJQLike,
				headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
				data: {name:name}
			});
		},
		setUp : function(){
			console.log("datastudioのuriをリクエスト");
			return $http({
				method:"GET",
				url: "/api/set-up",
			});
		},
	}
}]);
