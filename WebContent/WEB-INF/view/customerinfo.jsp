<%@ taglib prefix ="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html >
<html>
<head>

<title>Save Customer</title>

<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
		  
<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-custoner-style.css" />
		  
		  
</head>
<body>
	<div id="wrapper">
			<div id="header">
			<h2> CRM - Customer RelationShip Manager</h2>
			</div>
		</div>
		
		<div id = "container">
		<h3>Save Customer </h3>
		<form:form action="addcustomer" modelAttribute="customer" method="POST">
		<table>
		<tbody>
		 <tr>
		 <td><label>First name</label></td>
		 <td><form:input path="firstname"/></td>
		 </tr>
		 
		 <tr>
		 <td><label>Last name</label></td>
		 <td><form:input path="lastname"/></td>
		 </tr>
		 
		 
		 <tr>
		 <td><label>Email_id</label></td>
		 <td><form:input path="email_id"/></td>
		 </tr>
		  
		  <tr>
		  <td> <label></label></td>
		  <td><input type ="submit" value ="save" class="save" /></td>
		  </tr>
		</tbody>
		</table>
		</form:form>
		</div>
</body>
</html>