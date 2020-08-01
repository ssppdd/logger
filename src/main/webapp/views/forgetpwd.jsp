<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unlock Account</title>

</head>

  <body>

<h3><font color="green">${Msg}</font></h3>
<h3><font color="red">${errMsg}</font></h3>
<form:form action="forgetpwd" modelAttribute="email" method="POST">
		<table>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
				</tr>
				<td><input type="submit" value="Submit" /></td>
		</table>
	</form:form>
	 </body>
</html>