/**
 * 
 */
var app=angular.module('RestfulWebServices.controllers',[]);
app.controller('MyCtrl1',['$scope','UserFactory',function ($scope,UserFactory){
	UserFactory.get({},function(UserFactory){
		$scope.fn=UserFactory.fn;
	})
}]);