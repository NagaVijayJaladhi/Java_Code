<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>

<title>Spring Boot AngularJS example</title>
<script type="text/javascript">
	var app = angular.module("CustomerManagement", []);

	//Controller Part
	app.controller("CustomerController", function($scope, $http) {

		$scope.customers = [];
		$scope.customerForm = {
			id : -1,
			customerName : "",
			email : ""
		};

		//Now load the data from server
		_refreshCustomerData();

		//HTTP POST/PUT methods for add/edit customer 
		// with the help of id, we are going to find out whether it is put or post operation

		$scope.submitCustomer = function() {

			var method = "";
			var url = "";
			if ($scope.customerForm.id == -1) {
				//Id is absent in form data, it is create new customer operation
				method = "POST";
				url = '/addCustomer';
			} else {
				//Id is present in form data, it is edit customer operation
				method = "PUT";
				url = '/addCustomer';
			}

			$http({
				method : method,
				url : url,
				data : angular.toJson($scope.customerForm),
				headers : {
					'Content-Type' : 'application/json'
				}
			}).then(_success, _error);
		};

		//HTTP DELETE- delete customer by Id
		$scope.deleteCustomer = function(customer) {
			$http({
				method : 'DELETE',
				url : '/deleteCustomer/' + customer.id
			}).then(_success, _error);
		};

		// In case of edit, populate form fields and assign form.id with customer id
		$scope.editCustomer = function(customer) {

			$scope.customerForm.customerName = customer.customerName;
			$scope.customerForm.email = customer.email;
			$scope.customerForm.id = customer.id;
		};

		/* Private Methods */
		//HTTP GET- get all customers collection
		function _refreshCustomerData() {
			$http({
				method : 'GET',
				url : 'http://localhost:8080/getAllCustomers'
			}).then(function successCallback(response) {
				$scope.customers = response.data;
			}, function errorCallback(response) {
				console.log(response.statusText);
			});
		}

		function _success(response) {
			_refreshCustomerData();
			_clearFormData()
		}

		function _error(response) {
			console.log(response.statusText);
		}

		//Clear the form
		function _clearFormData() {
			$scope.customerForm.id = -1;
			$scope.customerForm.customerName = "";
			$scope.customerForm.email = "";

		}
		;
	});
</script>
<style>
.blue-button {
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',
		endColorstr='#188BC0', GradientType=0);
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 12px;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 4px;
	border: 1px solid #1A87B9
}

.red-button {
	background: #CD5C5C;
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 12px;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 4px;
	border: 1px solid #CD5C5C
}

table {
	font-family: "Helvetica Neue", Helvetica, sans-serif;
	width: 50%;
}

caption {
	text-align: left;
	color: silver;
	font-weight: bold;
	text-transform: uppercase;
	padding: 5px;
}

th {
	background: SteelBlue;
	color: white;
}

tbody tr:nth-child(even) {
	background: WhiteSmoke;
}

tbody tr td:nth-child(2) {
	text-align: center;
}

tbody tr td:nth-child(3), tbody tr td:nth-child(4) {
	text-align: center;
	font-family: monospace;
}

tfoot {
	background: SeaGreen;
	color: white;
	text-align: right;
}

tfoot tr th:last-child {
	font-family: monospace;
}

td, th {
	border: 1px solid gray;
	width: 25%;
	text-align: left;
	padding: 5px 10px;
}
</style>
<head>
<body ng-app="CustomerManagement" ng-controller="CustomerController">
	<h1>Customer Mart</h1>
	<form ng-submit="submitCustomer()">
		<table>

			<tr>
				<th colspan="2">Add/Edit customer</th>
			</tr>
			<tr>
				<td>Customer Name</td>
				<td><input type="text" ng-model="customerForm.customerName" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" ng-model="customerForm.email" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit"
					class="blue-button" /></td>
			</tr>
		</table>
	</form>
	<table>
		<tr>

			<th>Customer Name</th>
			<th>Email</th>
			<th>Operations</th>

		</tr>

		<tr ng-repeat="customer in customers">

			<td>{{ customer.customerName }}</td>
			<td>{{ customer.email }}</td>

			<td><a ng-click="editCustomer(customer)" class="blue-button">Edit</a>
				| <a ng-click="deleteCustomer(customer)" class="red-button">Delete</a></td>
		</tr>

	</table>
</body>
</html>