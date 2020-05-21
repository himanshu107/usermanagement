'use strict'
/**
 * 
 * 
*/
var AdminDashboardController = function($scope, $rootScope, $http, $location, $route,$routeParams,$window,$timeout,AdminDashboardService) {
	$rootScope.pageTitle = $route.current.title;
	$scope.itemsPerPage=10;
	$scope.currentPage=1;
	
	$scope.getAllArticles = function(){
		AdminDashboardService.getAllArticles().then(function(response){
				$scope.allArticles = response.data;
				console.log(response.data)
		            }); 
				
	}
	
	$scope.addNewArticlePopUp = function(){
		
		$(".addNewArticlePopUp").modal("show");
	}
	
	$scope.closeaddNewArticlePopUp = function(){
		$(".addNewArticlePopUp").modal("hide");
	}
	
	$scope.sort = function(keyname){
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    }

	$scope.addArticle = {};
	$scope.saveArticle = function(addArticle,editLinkForm){
		editLinkForm.$submitted= true;
		$(".angular-validate-error").show();
		if(editLinkForm.$valid){
			$("#formErrorMSg").html(' ');
			AdminDashboardService.saveArticles(addArticle).then(function(response){
				$window.scrollTo(0,0);
				$scope.addArticle = {};
				editLinkForm.$submitted= false;
				$(".angular-validate-error").hide();
				$scope.successmessage="Article has benn Saved Successfully!";
				$timeout(function() {
					$scope.getAllArticles();
					$scope.successmessage="";
					$scope.closeaddNewArticlePopUp();
					}, 2000);
			});
			
		}
	}
}