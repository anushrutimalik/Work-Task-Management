<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" ng-app="myApp">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light" ng-controller="loginCtrl">
    <div class="container">
        <div class="row justify-content-center align-items-center vh-100">
            <div class="col-md-5 col-lg-4">
                <div class="card shadow">
                    <div class="card-body p-4">
                        
                        <h2 class="text-center mb-4">Work Assignment</h2>
                        <h4>Login</h4>
                        <form>
                            <!-- Email -->
                            <div class="mb-3">
                                <label for="email" class="form-label">
                                    Email Address
                                </label>
                                <input 
                                    type="email" id="emailId"
                                    class="form-control required" 
                                    id="email" 
                                    placeholder="Enter your email"
                                    ng-model="userInfo.email"
                                    >
                            </div>

                            <!-- Password -->
                            <div class="mb-3">
                                <label for="password" class="form-label">
                                    Password
                                </label>
                                <input 
                                    type="password" 
                                    class="form-control required" 
                                    id="password" 
                                    placeholder="Enter your password"
                                    ng-model="userInfo.password"
                                    
                                    >
                            </div>

                            <!-- Login Button -->
                            <div class="d-grid">
                                <button type="button" class="btn btn-primary" ng-click="loginProcess()">
                                    Login
                                </button>
                            </div>
                        </form><br/>
                        <p class="text-center text-danger">{{message}}</p>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
    <script type="text/javascript">
            var app = angular.module("myApp", []);
            app.controller("loginCtrl", function($scope,$http) { 
            	$scope.message = "";
            	const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                $scope.loginProcess = function(){
            		$scope.message = "";
            		$(".required").each(function(index){
            			if($(this).val() == '' || $(this).val() == undefined){
            			   $(this).focus();
            			   $scope.message = "Please fill all required fileds";
            			   return false;
            			}
            			else if($(".required").length == index+1){
            			    if(!regex.test($scope.userInfo.email)){
            			    	$scope.message = "Please fill valid email id";
            			    	$("#emailId").focus();
                 			    return false;
            			    }else{
            			    	console.log($scope.userInfo);
            			    	$http({
            			    	    url: '/security/api/loginProcess',
            			    	    method: 'POST',
            			    	    data: $.param({
            			    	        email: $scope.userInfo.email,
            			    	        password: $scope.userInfo.password
            			    	    }),
            			    	    headers: {
            			    	        'Content-Type': 'application/x-www-form-urlencoded'
            			    	    }
            			    	})
            			    	.then(function(response){
            			    		console.log(response);
            			    		window.location.href="home";
            			    	},function(error){
            			    		console.log(error);
            			    		$scope.message=error.data.message;
            			    	});
            			    }
            			}
            		});
            	}
            });
    </script>   
</body>
</html>