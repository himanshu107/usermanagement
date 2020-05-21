
'use strict'
/**
 * 
 */
var adminApp= angular.module('adminApp', ['ngRoute','ngIdle','angular-bootbox','kendo.directives','ui.select','ui.bootstrap','ng.ckeditor','angularUtils.directives.dirPagination']);

adminApp.config(['$routeProvider','$locationProvider',function($routeProvider, $locationProvider) {
$locationProvider.hashPrefix('!');

$routeProvider.when('/adminDashboardHome',{
	title : 'Admin Dashboard',
	templateUrl : 'adminDashboardHome',
	controller : AdminDashboardController
});


$routeProvider.when('/articles',{
	title : 'Click Dashboard',
	templateUrl : 'static/admin/articles.html',
	controller : AdminDashboardController
});

$routeProvider.otherwise({
	redirectTo : '/adminDashboardHome'
});
}]);


