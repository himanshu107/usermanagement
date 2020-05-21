'use strict'

/**
 * @author Hk
 */

 var frontApp=angular.module('frontApp',['ngRoute','ui.bootstrap','ui.select','angular-bootbox','kendo.directives','ng.ckeditor','vcRecaptcha']);

    
   
 frontApp.config(['$routeProvider','$locationProvider',function($routeProvider, $locationProvider) {
    $locationProvider.hashPrefix('!');
    
    $routeProvider.when('/home',{
        title : 'Clicks Home',
        templateUrl : 'home',
        controller : HomeController
    });
    
    $routeProvider.when('/create-an-account',{
        title : 'Clicks : Create An Account',
        templateUrl : 'static/front/create-an-account.html',
        controller : LoginController
    });
    
    
    $routeProvider.when('/create-account',{
        title : 'Clicks : Create Account',
        templateUrl : 'static/front/home.html',
        controller : LoginController
    });
    
    $routeProvider.when('/login',{
        title : 'Clicks : Login Form',
        templateUrl : 'static/front/login.html',
        controller : LoginController
    });
    
    
    $routeProvider.when('/resetPassword/:userId?',{
        title : 'Clicks : Login Form',
        templateUrl : 'static/front/reset-password.html',
        controller : LoginController
    });
    
    $routeProvider.otherwise({
    	redirectTo : '/home'
    });

 }]);
 
	frontApp.directive('activeMenu', ['$location', function($location) {
		return {
			restrict: 'A',
			link: function(scope, element, args) {
				var activeClass = args.activeMenu || 'active',
					links = element.find('li');

				scope.$on('$routeChangeStart', function() {
					var path = $location.path();
					links.removeClass(activeClass);

					for (var i = 0, len = links.length; i < len; i++) {
						var listItem = angular.element(links[i]),
						href = listItem.find('a').attr('href').replace(/!|#/g, '');
						if (href == path) {
							listItem.addClass(activeClass);
						}
					}
				});
			}
		};
	}]);