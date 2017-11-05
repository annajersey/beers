 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Beer Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
		h1,h3{text-align:center}
		form, table{margin:0 auto;}
	</style>
</head>
<body>


<h1>
	Add a Beer
</h1>

<c:url var="addAction" value="/beers/add" ></c:url>

<form:form action="${addAction}" commandName="beer">
<table>
	<c:if test="${!empty beer.beerName}">
	<tr>
		<td>
			<form:label path="beerId">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="beerId" readonly="true" size="8"  disabled="true" />
			<form:hidden path="beerId" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="beerName">
				<spring:message text="Beer Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="beerName" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="BeerSubName">
				<spring:message text="Beer SubName"/>
			</form:label>
		</td>
		<td>
			<form:input path="beerSubName" />
		</td>
		<td>
			<c:forEach items="${beer.getBeerToMalt()}" var="btm">
				${btm.weight},
			</c:forEach>p.()
		</td>
	</tr>

	<tr>
		<td colspan="2">
			<c:if test="${!empty beer.beerName}">
				<input type="submit"
					value="<spring:message text="Edit Beer"/>" />
			</c:if>
			<c:if test="${empty beer.beerName}">
				<input type="submit"
					value="<spring:message text="Add Beer"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Beer List</h3>
<c:if test="${!empty listBeers}">
	<table class="tg">
	<tr>
		<th > ID</th>
		<th> Name</th>
		<th > Sub Name</th>
		<th > Hops</th>
		<th > Malt</th>
		<th > </th>
		<th > </th>
	</tr>
	<c:forEach items="${listBeers}" var="beer">
		<tr>
			<td>${beer.beerId}</td>
			<td>${beer.beerName}</td>
			<td>${beer.beerSubName}</td>
			<td>
				<c:forEach items="${beer.hops}" var="hop">
					${hop.hopName},
				</c:forEach>
			</td>
			<td>
				${beer.getMaltsString()}
			</td>
			<td><a href="<c:url value='/edit/${beer.beerId}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${beer.beerId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
