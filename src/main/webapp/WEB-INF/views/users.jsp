<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
		

	<table border="0" width="100%" cellpadding="0" cellspacing="0" id="product-table">
		<tr>
			<th class="table-header-repeat line-left minwidth-1">Příjmení</th>
			<th class="table-header-repeat line-left minwidth-1">Jméno</th>
			<th class="table-header-repeat line-left minwidth-1">Login</th>
			<th class="table-header-repeat line-left">Email</th>
			<th class="table-header-repeat line-left">Role</th>
			<th class="table-header-options line-left">Možnosti</th>
		</tr>
		
		<c:forEach var="o" items="${userList}" varStatus="status">
            <tr <c:if test="${status.index%2==1}">class="alternate-row"</c:if>>
                <td>${o.getSurname()}</td>
                <td>${o.getName()}</td>
                <td>${o.getUsername()}</td>
                <td>${o.getEmail()}</td>
                <td>${o.getAuthority().getAuthority()}</td>
                <td class="options-width">
					<a href="users/edit/${o.getUsername()}" title="Upravit" class="icon-1 info-tooltip"></a>
					<a href="users/del/${o.getUsername()}" title="Smazat" class="icon-2 info-tooltip"></a>
				</td>   
            </tr>
        </c:forEach>
	</table>
