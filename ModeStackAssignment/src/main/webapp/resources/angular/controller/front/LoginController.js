'use strict';



var LoginController = function($scope, $rootScope, $http, $location, $timeout, $window,$compile,$route ,$routeParams, LoginService,HomeService,vcRecaptchaService) {

	$rootScope.pageTitle = $route.current.title;
	$scope.message = "";
	$scope.dumCourseId = $routeParams.dumCourseId;
	$scope.optionId = $routeParams.optionId;
	$scope.dumSudentCourseId = $routeParams.dumSudentCourseId;
	$scope.guestId = $routeParams.guestId;
	$scope.totalCourseFees = $routeParams.fee;
	$scope.contentShow=false;

    $scope.vm = this;
    $scope.vm.publicKey="6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI";
    
	$scope.user={};
	
	$scope.frontloginsubmit= function(user,loginForm){
		
		if (vcRecaptchaService.getResponse() === "") { 
   			alert("Please resolve the captcha and submit!")
   		}
		
		loginForm.$submitted = true;
        $(".angular-validate-error").show();
      
        if(loginForm.$valid){
            $("#formErrorMSg").html(' ');
         
            if (vcRecaptchaService.getResponse() === "") { 
       			alert("Please resolve the captcha and submit!")
       		} else {
       			vcRecaptchaService.getResponse()
       		
            LoginService.userLogin($scope.user).then(function(response){
            	console.log(response.data)
                                    	  if(response.data !=null){
                                    		  window.location.href="/superadminredirect";
                                        }else{
                                        	$scope.failuremessage = "Please enter valid email address and password.";
                                        }
                                        },
                                          function(errResponse){
                                        	$scope.failuremessage = "Please enter valid email address and password.";
                                          });
                               
       		}
             
       }
    }; 
    
    
    $scope.registeUser = function(user,registrationForm){
  	  registrationForm.$submitted=true;
  	$scope.user=user;
        $(".angular-validate-error").show();
        if(registrationForm.$valid){
      	 
            $("#formErrorMSg").html(' ');
           
            LoginService.register(user).then(function(response){
            	$scope.message= response.data;
    			 registrationForm.$submitted=false;
    		        $(".angular-validate-error").hide();
            });
            
            $timeout(function(){
		    	  $scope.message = "";
		    	  window.location.href="#!/login";
		      },3000);
        }
        
    }
    
    $scope.showForgotPassword = function(){
    	$scope.contentShow=true;	
    }
    
      
       
       $scope.signUp = function(){
       		window.location.href="#!/enter-website";
       }
 
   	//If the recaptcha value is empty alert error else alert the recaptcha resonse
       $scope.resetPassword= function(user,resetForm) {
   		if (vcRecaptchaService.getResponse() === "") { 
   			alert("Please resolve the captcha and submit.")
   		} else {
   			//alert(vcRecaptchaService.getResponse());
   			if(user.password == user.cnfpassword){
   				HomeService.updatePassword($scope.userId,user.password).then(function(response){
   	   				$scope.successmessage = "Password updated successfully.";
   	   			});
   				$timeout(function(){
  	    		  $scope.successmessage ="";
  	    		 window.location.href="./#!/login";
  	    	  },4000)
   				
   			}else{
   				$scope.failuremessage = "Password doesn't match.";
   			}
   			
   			
   		}
   	}
}