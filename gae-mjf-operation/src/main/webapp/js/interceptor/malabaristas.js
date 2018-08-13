var MALABARISTAS_APP = angular.module("Malabaristas", ["ngRoute","ngAnimate"]);

MALABARISTAS_APP.config(function($httpProvider, $routeProvider) {
	$routeProvider.when('', {//デフォルトの画面
		templateUrl : '/template/home.html'
	})
	.when('/home', {
		templateUrl: '/template/home.html'
	})
	.when('/member', {
		templateUrl: '/template/member.html'
	})
	.otherwise({
		templateUrl : '/template/home.html'
	});

});

MALABARISTAS_APP.service("SharedDataService", function() { // Controller間で共有したい変数、関数
	var Data = {
		jobState: '',
		jobStateMessage: '',
	};
	return Data;
});