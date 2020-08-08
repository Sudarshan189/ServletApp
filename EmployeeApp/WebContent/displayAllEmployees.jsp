<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

</head>
<body>


<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="#">Employee</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="addEmployee.jsp">Add Employee</a>
      </li>
    </ul>
  </div>
</nav>



<h3 align="center">Employee Details</h3><br>
	<table class="table table-bordered table-striped mr-5">
	
		<thead align="center">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Employee Name</th>
				<th scope="col">Employee Salary</th>
				<th scope="col">Employee Department</th>
				<th scope="col">Edit</th>
				<th scope="col">Delete</th>
				
			</tr>
		</thead>
		<tbody align="center">
		<c:forEach var="emp" items="${requestScope.employeeList}">
			<tr>
				<th scope="row">${emp.employeeId}</th>
				<td>${emp.employeeName}</td>
				<td>${emp.employeeSalary }</td>
				<td>${emp.employeeDepartment }</td>
				<td><a href="editEmployee?id=${emp.employeeId }" class="btn btn-primary btn-sm">Edit</a></td>
				<td><a class="btn btn-danger btn-sm" href="deleteEmployee?id=${emp.employeeId }">Delete</a></td>
				
			</tr>
		</c:forEach>
		</tbody>

	</table>
</body>
</html>