<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<a href="<c:url value="/" />">Home</a>
<h3>Customers</h3>
<table border="1" style="border-collapse: collapse;">
	<thead>
		<tr>
			<th>Id</th>
			<th>Company name</th>
			<th>Contact name</th>
			<th>Contact title</th>
			<th>Address</th>
			<th>City</th>
			<th>Region</th>
			<th>Postal code</th>
			<th>Country</th>
			<th>Phone</th>
			<th>Fax</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${customerList}" var="customer">
		<tr>
			<td><c:out value="${customer.id}" /></td>
			<td><c:out value="${customer.companyName}" /></td>
			<td><c:out value="${customer.contactName}" /></td>
			<td><c:out value="${customer.contactTitle}" /></td>
			<td><c:out value="${customer.address}" /></td>
			<td><c:out value="${customer.city}" /></td>
			<td><c:out value="${customer.region}" /></td>
			<td><c:out value="${customer.postalCode}" /></td>
			<td><c:out value="${customer.country}" /></td>
			<td><c:out value="${customer.phone}" /></td>
			<td><c:out value="${customer.fax}" /></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
