<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="./js/app.js"></script>
<link href="./css/style.css" rel="stylesheet">
<title>Register</title>

</head>
  <body>

  	<p>
		<font color='green'>${succMsg}</font>
	</p>
	<p>
		<font color='red'>${errMsg}</font>
	</p>
<div class="container" id="wrap">
	  <div class="row">
        <div class="col-md-6 col-md-offset-3">	
	<form:form action="register1" modelAttribute="register" method="POST" class="form" role="form"> <legend>Sign Up</legend>
		<h4>It's free and always will be.</h4>
                    <div class="row">
                        <div class="col-xs-6 col-md-6">
				<form:input type="text" path="firstName" name="firstname" class="form-control input-lg" placeholder="First Name"  />
				</div>
			<div class="col-xs-6 col-md-6">
                            <form:input type="text" path="lastName" name="lastname" class="form-control input-lg" placeholder="Last Name"  />
                             </div>
                    </div>
                    
			<form:input type="text" path="email" name="email" class="form-control input-lg" placeholder="Your Email"  />
						<font color='red'><div id="dupEmail"> </div></font>	
					<form:input path="phNo" class="form-control input-lg" placeholder="Mobile Number"  />
					<label>Date-Of-Birth</label>
					<form:input path="dob" type="date" class="form-control input-lg" placeholder="Date-Of-Birth"  />
								
 <label>Gender : </label>                    <label class="radio-inline">
                        <form:radiobutton name="gender" path="gender" value="M" id="gender" />                        Male
                    </label>
                    <label class="radio-inline">
                        <form:radiobutton name="gender" path="gender" value="F" id="gender" />                        Female
                    </label>
                    <br />
			
				<div class="row">		
			<div class="col-xs-4 col-md-4">
				<label>Country</label>
				<form:select path="countryId" class = "form-control input-lg">
						<form:option value="">-Select-</form:option>
						<form:options items="${countryMap}" />
					</form:select>
			 </div>
                        
			
			<div class="col-xs-4 col-md-4">
				<label>State</label>
				<form:select path="stateId" class = "form-control input-lg">
						<form:option value="">-Select-</form:option>
					</form:select>
			
			 </div>
              <div class="col-xs-4 col-md-4">
				<label>City</label>
				<form:select path="cityId" class = "form-control input-lg">
						<form:option value="">-Select-</form:option>
					</form:select>
					</div>
			
				<br />
              <span class="help-block">By clicking Create my account, you agree to our Terms and that you have read our Data Use Policy, including our Cookie Use.</span>
                    <button class="btn btn-lg btn-primary btn-block signup-btn" type="submit">
                        Create my account</button>
                        <button class="btn btn-lg btn-secondary btn-block signup-btn" type="reset">
                        Reset</button>
                   
          </div>
           </form:form>  
</div>            
</div>
</div>
	
  </body>
</html>