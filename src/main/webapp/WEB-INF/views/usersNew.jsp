<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form method="post" action="users/action/addUser">

		<table border="0" cellpadding="0" cellspacing="0"  id="id-form">
		<tr>
			<th valign="top">Login:</th>
			<td><form:input path="username" class="inp-form"/></td>
			<td>
			<div class="error-left"></div>
			<div class="error-inner">*</div>
			</td>
		</tr>
		<tr>
			<th valign="top">Heslo:</th>
			<td><form:input path="password" type="password" class="inp-form"/></td>
			<td>
			<div class="error-left"></div>
			<div class="error-inner">*</div>
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
			<th valign="top">Křestní jméno:</th>
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
			<option value="ROLE_USER">ROLE_USER</option>
			<option value="ROLE_ADMIN">ROLE_ADMIN</option>
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
 