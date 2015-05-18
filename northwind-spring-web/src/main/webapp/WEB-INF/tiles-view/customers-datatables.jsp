<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.7/css/jquery.dataTables.css"/>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" charset="utf-8">
$(document).ready(function() {
	$('#customers').dataTable( {
		"serverSide": true,
		"processing": true,
		"paging": true,
		"pagingType": "full_numbers",
		"displayStart": 0,		
		"pageLength": 10,
		"columns": [
			{"data": "id"},
			{"data": "companyName"},
			{"data": "contactName"},
			{"data": "contactTitle"},
			{"data": "address"},
			{"data": "city"},
			{"data": "region"},
			{"data": "postalCode"},
			{"data": "country"},
			{"data": "phone"},
			{"data": "fax"}
        ],
		"ajax": '<c:url value="/rest/customers-datatables" />'
	});
});
</script>
<a href="<c:url value="/" />">Home</a>
<h3>Customers Datatables</h3>
<table id="customers" class="cell-border display hover" cellspacing="0" width="100%">
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
	<tfoot>
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
	</tfoot>
	<tbody>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</tbody>
</table>
