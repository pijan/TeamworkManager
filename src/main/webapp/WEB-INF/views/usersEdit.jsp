<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<form:form method="post" action="users/action/editUser">
	<form:hidden path="username" />
	
		<table border="0" cellpadding="0" cellspacing="0"  id="id-form">	
		<tr>
			<th valign="top">Heslo:</th>
			<td><form:password path="password" class="inp-form"/></td>
			<td>
			</td>
		</tr>
		<tr>
			<th valign="top">Email:</th>
			<td><form:input path="email" class="inp-form"/></td>
			<td>
			
			    <div class="error-left"></div>
				<div class="error-inner">*</div>
			
			</td>
		</tr>
		<tr>
			<th valign="top">Křestní jméno:</th>
			<td><form:input path="name" class="inp-form"/></td>
			<td></td>
		</tr>
		<tr>
			<th valign="top">Příjmení:</th>
			<td><form:input path="surname" class="inp-form"/></td>
			<td></td>
		</tr>
				 
		<tr>
		<th valign="top">Role:</th>
		<td>	
		<form:select path="authority.authority" class="styledselect_form_1">
			<form:option value="ROLE_USER" label="ROLE_USER" />
			<form:option value="ROLE_ADMIN" label="ROLE_ADMIN" />
		</form:select>
		</td>
		<td></td>
		</tr>
		<tr>
			<th valign="top">Aktivní:</th>
			<td><form:checkbox path="enabled" value="1" class="inp-form" checked="true"/></td>
			<td></td>
		</tr>
		<tr>
			<th>&nbsp;</th>
			<td valign="top">
				<input type="submit" value="" class="form-submit" />
				<input type="reset" value="" class="form-reset"  />
			</td>
			<td></td>
		</tr>
	</table>

</form:form>  