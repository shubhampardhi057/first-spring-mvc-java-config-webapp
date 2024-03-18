<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>

	<h2>List Of Employees :</h2>

	<p><b>Simple List:</b><p>
	
	${empList}
	
	<p><b>Iterated List:</b><p>

	<ol>
		<c:forEach var="emp" items="${empList}">
		
			<li>${emp}</li>
			
		</c:forEach>
	</ol>
<a href="index.jsp">Click here to return HOME Page</a>
</body>
</html>