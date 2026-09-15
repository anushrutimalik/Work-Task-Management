var app = angular.module("eWork", []);
app.controller("empController", function($scope,$http) { 
	
	$http({
		url:'employee/readAll',
		method:'GET'
	})
	.then(function(response){
		console.log(response);
		$scope.employees =response.data;
	},function(error){
		console.log(error);
		Swal.fire({
		  title: "Error",
		  text: "erroroccured wile fetching record",
		  icon: "error"
		});
	});
	
	$scope.saveEmployee = function(){
		const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
		$("#err-msg").html("");
		$(".required").each(function(index){
			if($(this).val() == '' || $(this).val() == undefined){
			   $(this).focus();
			   $("#err-msg").html("Please fill all required fileds");
			   return false;
			}
			else if($(".required").length == index+1){
			    if(!regex.test($scope.employee.email)){
			    	$("#err-msg").html("Please fill valid email id");
			    	$("#email").focus();
     			    return false;
			     }
				 else{
					$http({
			    		url:'employee/create',
			    		method:'POST',
			    		data:$scope.employee
			    	})
			    	.then(function(response){
			    		console.log(response);
						$('#exampleModal').modal('hide');
						$scope.employee={};
						Swal.fire({
						  title: "Good job!",
						  text: "Employee has been saved!",
						  icon: "success"
						});
			    	},function(error){
			    		console.log(error);
			    		$("#err-msg").html("Error: "+error.data.message);
			    	});
				 }
		    }
		});
	}
});
app.controller("workController", function($scope, $http) { 
	
	$http({
		url:'work/readAll',
		method:'GET'
	})
	.then(function(response){
		$scope.works = response.data;
		console.log(response.data);
	},function(error){
		Swal.fire({
		  title: "Error",
		  text: "error occured while fetching records",
		  icon: "error"
		});
	});
	
	$scope.saveWork = function(){
		const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
		$("#err-msg-work").html("");
		$(".required").each(function(index){
			if($(this).val() == '' || $(this).val() == undefined){
			   $(this).focus();
			   $("#err-msg-work").html("Please fill all required fields");
			   return false;
			}
			else if($(".required").length == index+1){
				$http({
					url:'work/create',
					method:'POST',
					data:$scope.work
				})
				.then(function(response){
					$('#workModal').modal('hide');
					$scope.work = {};
					Swal.fire({
					  title: "Good job!",
					  text: "Work has been saved!",
					  icon: "success"
					}).then((result) => {
						$http({
							url:'work/readAll',
							method:'GET'
						}).then(function(res){
							$scope.works = res.data;
						});
					});
				},function(error){
					$("#err-msg-work").html("Error: " + error.data.message);
				});
		    }
		});
	}
});