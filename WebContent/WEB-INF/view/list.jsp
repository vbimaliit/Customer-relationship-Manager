<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix ="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html >
<html>
<head>

<title>Customer</title>

<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>
		<div id="wrapper">
			<div id="header">
			<h2> CRM - Customer RelationShip Manager</h2>
			</div>
		</div>
		
		<div id="container">
			<div id="content">
			
			<input type ="button"   value ="AddCustomer"
			onclick = "window.location.href='showaddform' ; return false"/>
			
			<br> <br>
			<form:form action ="searchcustomer" ModelAttribute ="customername" method ="POST">
			Search Customer <input type="text" name="customername"/>
			<input type="submit" value ="Search" />
			</form:form>
			
			<br> <br>
			<table>
			       <tr>
			       <th> Firstname </th>
			       <th> Lastname </th>
			       <th> Email_id </th>
			       <th>Action</th>
			       </tr>
			       
			       <c:forEach var="tempcustomer" items="${customers}">
			       <c:url var="updatelink"  value ="/customer/showupdateform">
			       <c:param name="customerid" value="${tempcustomer.id }" />
			       </c:url>
			       
			       
			       <c:url var="deletelink"  value ="/customer/delete">
			       <c:param name="customerid" value="${tempcustomer.id }" />
			       </c:url>
			       
			       <tr>
			       		<td>${tempcustomer.firstname}</td>
			       		<td>${tempcustomer.lastname}</td>
			       		<td>${tempcustomer.email_id}</td>
			       		<td><a href ="${updatelink}">update</a>
							<a href ="${deletelink}" 
							onclick="if(!(confirm('Are you sure you want to delete this')))return false">|delete</a>			       		
			       		</td>
			       	</tr>
			       	</c:forEach>
			       
			</table>
			</div>
		</div>
		
		
</body>
</html>