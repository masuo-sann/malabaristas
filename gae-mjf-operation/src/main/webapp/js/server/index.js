MALABARISTAS_APP.factory('indexReport', ["$http","$httpParamSerializerJQLike", function ($http,$httpParamSerializerJQLike) {
	return{
		setUp : function(){
			console.log("datastudioのuriをリクエスト");
			return $http({
				method:"GET",
				url: "/api/set-up",
			});
		},
		startDataflowJob : function(){
			console.log("新しくdataflowjobをスタート");
			return $http({
				method:"POST",
				url: "/api/dataflow!start",
				transformRequest: $httpParamSerializerJQLike,
				headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
				data: {state:"#"}
			});
		},
		stopDataflowJob : function(){
			console.log("dataflowjobを停止");
			return $http({
				method:"POST",
				url: "/api/dataflow!cancelAll",
				transformRequest: $httpParamSerializerJQLike,
				headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
				data: {state:"#"}
			});
		},
	}
}]);