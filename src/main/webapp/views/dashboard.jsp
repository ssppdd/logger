<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>Welcome</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
$(document).ready(function() {
	var option="1";
	showDiv(option);
});
function showDiv(option) {
	if(option == "1"){
	$(option).show();
	$('#2').show();
	$('#3').show();
	$('#4').hide();
}else{
	$('#1').show();
	$('#4').show();
	$('#2').hide();
	$('#3').hide();
	}
}
</script>
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
  </style>
</head>
<body>

<div id="1" class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4>${userInfo.firstName}  ${userInfo.lastName} Blog</h4>
      <ul class="nav nav-pills nav-stacked">
        <li><a href="javascript:showDiv('1')">Home</a></li>
        <li><a href="javascript:showDiv('4')">Profile</a></li>
        <li><a href="javascript:showDiv('3')">Change Password</a></li>
        <li><a href="http://localhost:7654/Register/login">Logout</a></li>
      </ul><br>
      <div id="2" class="input-group">
        <input type="text" class="form-control" placeholder="Search Blog..">
        <span class="input-group-btn">
          <button class="btn btn-default" type="button">
            <span class="glyphicon glyphicon-search"></span>
          </button>
        </span>
      </div>
    </div>

    <div class="col-sm-9">
     <div id="4" hidden= true class="form-group">
     <h2><strong>Profile Info</strong></h2>
     <form:form action="unlock" modelAttribute="userInfo" method="POST">
      <label for="formGroupExampleInput">First Name</label> 
      <form:input type="text" class="form-control" id="formGroupExampleInput" path="firstName" readonly="true"/>
      <label for="formGroupExampleInput2">Last Name</label> 
      <form:input type="text" class="form-control" id="formGroupExampleInput2" path="lastName" readonly="true"/>
      <label for="formGroupExampleInput3">Email</label> 
      <form:input type="text" class="form-control" id="formGroupExampleInput3" path="email" readonly="true"/>
      <label for="formGroupExampleInput4">Mobile Number</label> 
      <form:input type="text" class="form-control" id="formGroupExampleInput4" path="phNo" readonly="true"/>
      <label for="formGroupExampleInput5">Date-of-Birth</label> 
      <form:input type="text" class="form-control" id="formGroupExampleInput5" path="dob" readonly="true"/>
      <label for="formGroupExampleInput6">Gender</label> 
      <form:input type="text" class="form-control" id="formGroupExampleInput6" path="gender" readonly="true"/>
      </form:form>
     </div>
     
    <div id="3">
      <h4><small>RECENT POSTS</small></h4>
      <hr>
      <h2>I Love Food</h2>
      <h5><span class="glyphicon glyphicon-time"></span> Post by Jane Dane, Sep 27, 2015.</h5>
      <h5><span class="label label-danger">Food</span> <span class="label label-primary">Ipsum</span></h5><br>
      <p>Food is my passion. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
      <br><br>
      
      <h4><small>RECENT POSTS</small></h4>
      <hr>
      <h2>Officially Blogging</h2>
      <h5><span class="glyphicon glyphicon-time"></span> Post by ${userInfo.firstName} Doe, Sep 24, 2015.</h5>
      <h5><span class="label label-success">Lorem</span></h5><br>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
      <hr>

      <h4>Leave a Comment:</h4>
      <form role="form">
        <div class="form-group">
          <textarea class="form-control" rows="3" required></textarea>
        </div>
        <button type="submit" class="btn btn-success">Submit</button>
      </form>
      <br><br>
      </div>
      </div>
    </div>
     
</div>

<footer class="container-fluid">
  <p>Footer Text</p>
</footer>
	
</body>
</html>

  