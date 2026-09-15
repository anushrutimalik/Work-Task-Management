<!doctype html>
<html lang="en" ng-app="eWork">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>eWork</title>
  </head>
  <body>
    <jsp:include page="fragments/header.jsp"></jsp:include>
    <div class="container" ng-controller="empController">
	    <div class="row">
	       <div class="col-lg-10">
	          <h4>Employee Management</h4>
	       </div>
	       <div class="col-lg-2">
	           <button type="button" class="btn btn-sm btn-primary w-100" data-bs-toggle="modal" data-bs-target="#exampleModal">
				  Add Employee
				</button>
	       </div>
	    </div><br/>
	    <div class="row">
	      <div class="col-lg-12">
	         <table class="table table-striped">
               <thead>
                 <tr>
                   <th>SNo</th><th>Employee Name</th><th>Email</th><th>Department</th><th>Designation</th><th>Action</th>
                 </tr>
               </thead>
               <tbody>
                   <tr ng-repeat="employee in employees">
                     <td ng-bind="$index+1"></td>
                     <td ng-bind="employee.fullname"></td>
                     <td ng-bind="employee.email"></td>
                     <td ng-bind="employee.department"></td>
                     <td ng-bind="employee.designation"></td>
                     <td><button class="btn btn-sm btn-outline-secondary">edit</button></td>
                   </tr>
               </tbody>
             </table>
	      </div>
	    </div>
    <!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Employee Registration</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <div class="row">
	          <div class="col-lg-12">
	                <div class="mb-3">
					  <label for="fullname" class="form-label">Full Name</label>
					  <input type="text" class="form-control required" ng-model="employee.fullname" id="fullname" placeholder="Employee Fullname">
					</div>
	          </div>
	        </div>
	        <div class="row">
	          <div class="col-lg-6">
	                <div class="mb-3">
					  <label for="dob" class="form-label">D.O.B.</label>
					  <input type="date" class="form-control required" ng-model="employee.dob"  id="dob" placeholder="Employee Fullname">
					</div>
	          </div>
	          <div class="col-lg-6">
	                <div class="mb-3">
					  <label for="email" class="form-label">Email</label>
					  <input type="text" class="form-control required" ng-model="employee.email" id="email" placeholder="Employee Email">
					</div>
	          </div>
	        </div>
	         <div class="row">
	          <div class="col-lg-6">
	                <div class="mb-3">
					  <label for="department" class="form-label">Department</label>
					  <select class="form-control required" ng-model="employee.department" id="department" >
					    <option value="">--select--</option>
					    <option value="Accounts">Accounts</option>
					    <option value="Admin">Administration</option>
					    <option value="Recruitment">Recruitment</option>
					    <option value="Exam">Exam</option>
					  </select>
					</div>
	          </div>
	          <div class="col-lg-6">
	                <div class="mb-3">
					  <label for="designation" class="form-label">Designation</label>
					  <input type="text" class="form-control required"  ng-model="employee.designation" id="designation" placeholder="Employee Designation">
					</div>
	          </div>
	        </div>
	        <p id="err-msg" class="text-danger text-center"></p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary" ng-click="saveEmployee()">Save changes</button>
	      </div>
	    </div>
	  </div>
	</div>
	</div>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="js/app.js"></script>
  </body>
</html>