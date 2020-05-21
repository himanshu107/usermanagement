'use strict';



var HomeController=function($scope, $sce, $rootScope, $http, $location, $route, $window, $compile, $routeParams, $timeout,HomeService,LoginService) {
    
    $rootScope.pageTitle=$route.current.title;
    $rootScope.title=$route.current.title;
    $rootScope.description=$route.current.description;
    $scope.mesage=" ";
  
    $scope.createAccount = function(){
    	$(".userLogin").modal("show");
    }
    
    $scope.closeLoginPopup =function(){
    	$(".userLogin").modal("hide");
    }
    
  
  
  
}