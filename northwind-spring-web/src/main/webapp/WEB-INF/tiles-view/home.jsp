<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<h1>Welcome to Northwind</h1>

<a href="<c:url value="/customers" />">Customers</a> | 
<a href="<c:url value="/customers-datatables" />">Customers Datatables</a>
