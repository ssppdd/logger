<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="./js/app.js">
	
</script>

<title>Unlock Account</title>

</head>

  <body>

	<h2>Unlock Account</h2>
	<p>
		<font color='red'>${errMsg}</font>
	</p>
	
	<form:form action="unlock" modelAttribute="unlock" method="POST">
		<table>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" readonly="true" /></td>
				</tr>
				
			<tr>
				<td>Temporary Password :</td>
				<td><form:input path="temPwd" /></td>
			</tr>
			
			<tr>
				<td>New Password :</td>
				<td><form:input path="newPwd" /></td>
			</tr>
			
			<tr>
				<td>Confirm Password :</td>
				<td><form:input path="cnfPwd" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Unlock"
					onclick="javascript:return validatePwds()" /></td>
			</tr>			
		</table>
	</form:form>
  </body>
</html>