<!doctype html>
<html lang="en" ng-app="eWork">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Work Management</title>
  </head>
  <body>
    <jsp:include page="fragments/header.jsp"></jsp:include>
    
    <div class="container" ng-controller="workController">
	    <div class="row mt-4">
	       <div class="col-lg-10">
	          <h4>Work Management</h4>
	       </div>
	       <div class="col-lg-2">
	           <button type="button" class="btn btn-sm btn-primary w-100" data-bs-toggle="modal" data-bs-target="#workModal">
				  Add Work
				</button>
	       </div>
	    </div><br/>
	    
	    <div class="row">
	      <div class="col-lg-12">
	         <table class="table table-striped">
               <thead>
                 <tr>
                   <th>SNo</th><th>Title</th><th>Description</th><th>Status</th><th>Created On</th><th>Action</th>
                 </tr>
               </thead>
               <tbody>
                   <tr ng-repeat="work in works">
                     <td ng-bind="$index+1"></td>
                     <td ng-bind="work.title"></td>
                     <td ng-bind="work.description"></td>
                     <td ng-bind="work.status"></td>
                     <td ng-bind="work.createdOn"></td>
                     <td><button class="btn btn-sm btn-outline-secondary">edit</button></td>
                   </tr>
               </tbody>
             </table>
	      </div>
	    </div>

	<div class="modal fade" id="workModal" tabindex="-1" aria-labelledby="workModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="workModalLabel">Add New Work</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <div class="row">
	          <div class="col-lg-12">
	                <div class="mb-3">
					  <label for="title" class="form-label">Work Title</label>
					  <input type="text" class="form-control required" ng-model="work.title" id="title" placeholder="Enter Work Title">
					</div>
	          </div>
	        </div>
	        <div class="row">
	          <div class="col-lg-12">
	                <div class="mb-3">
					  <label for="description" class="form-label">Description</label>
					  <textarea class="form-control required" ng-model="work.description" id="description" placeholder="Enter Work Description"></textarea>
					</div>
	          </div>
	        </div>
	        <p id="err-msg-work" class="text-danger text-center"></p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary" ng-click="saveWork()">Save changes</button>
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