MALABARISTAS_APP.factory('egoSearchRepo', ["$http", "$httpParamSerializerJQLike", function($http, $httpParamSerializerJQLike){
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
		searchRequest: function(searchWord, requestNumber, searchPeriod, analysisOption){
			console.log("ログイン確認 & 検索ワード、検索件数のリクエストを送信");
			return $http({
				method:"POST",
				url: "/api/search-request",
				transformRequest: $httpParamSerializerJQLike,
				headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
				data: {state:"#", searchWord:searchWord, requestNumber:requestNumber, searchPeriod:searchPeriod, analysisOption:analysisOption}
			});
		},
		reportResult:function(datastoreId){
			console.log("検索結果の報告：datastoreId = " + datastoreId);
			return $http({
				method:"POST",
				url: "/api/report-result",
				transformRequest: $httpParamSerializerJQLike,
				headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
				data: {datastoreId:datastoreId}
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
