'use strict';

/**
 * @author Logic Heart 
 */

 frontApp.service('LoginService', ['$http', '$q', function($http, $q){
    var obj={};
    
    obj.getUserByEmail = function(email){
		return $http.post("getUserByEmail?email="+email);
	}
	
	obj.checkEmail=function(email){
		return $http.post('checkEmail?email='+email);
	};
	
	obj.register=function(user){
		return $http.post('register',user);
	};
	
	
    
		 obj.userLogin = function(user){
			  return $http.post('logins?email='+user.email+'&password='+user.password).then(function(response){
				  if(response.data !=null){
            		  window.location.href="adminDashboard";
                }else{
                	$scope.failuremessage = "Please enter valid email address and password.";
                }
				  return response.data;
             }, 
             function(errResponse){
                 console.log(errResponse);
                 return $q.reject(errResponse);
             }
           );
   }
	
	return obj;
} ]);