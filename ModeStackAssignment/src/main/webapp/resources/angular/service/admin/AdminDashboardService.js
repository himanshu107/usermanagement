
'use strict';
/**
 * 
 */

adminApp.service('AdminDashboardService', [ '$http', '$q', function($http, $q) {
	var obj = {};

	obj.getAllArticles = function(){
		return $http.get("getAllArticles");
	}
	
	obj.saveArticles = function(article){
		return $http.post("saveArticles",article);
	}
	
	return obj;

}]);
