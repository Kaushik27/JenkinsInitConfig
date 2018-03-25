var app = angular.module("myApp", []);

app.run(function($rootScope, $http) {

});

app.controller('myCtrl', function($scope, $http) {
	console.log("here i am");
	$scope.insertData = function(student) {
		console.log("inside controller");
		console.log($scope.student.name);
		console.log($scope.student.age);
		console.log($scope.student.gender);
		$http.post('/insertData', student).then(function(success) {
			console.log("success");
		}, function(error) {
			console.log("fail");
		});
	}

});
