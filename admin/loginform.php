<!DOCTYPE html>
<html>
<head>
	<title>LogIn/SignUp</title>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
 
<script>
$(function(){
$('.tab-container a').click(function(){
 
var id=$(this).attr('id');
 
var el=$('.'+id);
 
var self=$(this);
 
if(!$(self).hasClass('active')){
 
var apanel=$('.'+$('.active').attr('id'));
apanel.fadeOut('fast',function(){
el.show();
 
$(self).parent().find('a').removeClass('active');
$(self).addClass('active');
});
}
});
});
</script>

<script type="text/javascript" language="javascript">

            function submitlogin() {
                var form = document.login;
				if(form.emailusername.value == ""){
					alert( "Enter email or username." );
					return false;
				}
				else if(form.password.value == ""){
					alert( "Enter password." );
					return false;
				}
			}
			function submitreg() {
				 var form = document.reg;
				
				 if(form.username.value == ""){
				 alert( "Enter username." );
				 return false;
				 }
				 else if(form.password.value == ""){
				 alert( "Enter password." );
				 return false;
				 }
				 else if(form.email.value == ""){
				 alert( "Enter email." );
				 return false;
				 }
			}

</script>

<style>


html, body {
background: #dedede none repeat scroll 0 0;
padding: 40px 20px;
}

h1 {
margin: 0;
color: #555555;
}


.container{
width:400px;
margin:30px auto;

}
.tab-container{
height:40px;
width:100%;
border-bottom:1px solid #cbcbcb;
}
.tab-container a {
background: #555 none repeat scroll 0 0;
border-radius: 3px 4px 0 0;
color: #fff;
float: right;
height: 40px;
line-height: 40px;
margin: 0 0 0 5px;
min-width: 90px;
padding: 0;
text-align: center;
text-decoration: none;
}
.tab-container a.active {
background: #fff none repeat scroll 0 0;
color: #555;
height: 41px;
}
.box-container{
box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
background:#fff;
width:100%;
}
.signup{
display:none;
}

center{
	
	color: red;
}


/*******************Login Page***********************/

.login-section {
background: rgb(255, 255, 255) none repeat scroll 0 0;
border-radius: 4px;
padding: 20px;
}

.login-section h1 {
color: rgb(0, 0, 0);
font-family: sans-serif;
font-size: 17px;
margin-bottom: 20px;
margin-top: 0;
text-align: center;
text-transform: uppercase;
}
.login-section input {
width: 100%;
height: 42px;
box-sizing: border-box;
border-radius: 5px;
border: 1px solid #ccc;
margin-bottom: 20px;
font-size: 14px;
font-family: sans-serif;
padding: 0 20px 0 50px;
outline: none;
}
.login-section input:focus{
border-color:#0079CE;
}
.login-section input[type="submit"] {
width: 100%;
padding:9px 7px;
background: #555;
box-sizing: border-box;
border-radius: 5px;
border: 1px solid #555;
color: #fff;
font-weight: bold;
text-transform: uppercase;
font-size: 14px;
outline: none;
font-family:sans-serif;
cursor: pointer;
}

.login-section input[type="submit"]:hover {
background: #444;
}
.login-section p {
text-align: center;
}


#username, #email, #name {
background: rgba(0, 0, 0, 0) url("assets/img/uname.png") no-repeat scroll 11px center;
}
#password, #location
{
background: rgba(0, 0, 0, 0) url("assets/img/pass.png") no-repeat scroll 11px center;
}
#phone
{
background: rgba(0, 0, 0, 0) url("assets/img/phone.png") no-repeat scroll 11px center;
}

@media only screen and (max-width: 400px) {
.login-section {
width:85%;
}
}
</style>

</head>
<body>
<center><h1>Make A Wish</h1></center>
	<div class="container">
<div class="tab-container">
<a href="javascript:;" id="signup">Signup</a>
<a href="javascript:;" class="active" id="login">Login</a>
</div>
<div class="box-container">
<div class="login">
<div class="login-section">
<h1>Please Login</h1>
<form action="index.php" method="post" name="login">
<input type="text" id="email" placeholder="Email" name="email" value="" required="">
<input type="password" id="password" placeholder="Password" name="password" value="" required="">
<input onclick="return(submitlogin());" type="submit" name="submit" value="Login" />
</form>
</div>
</div>
 
<div class="signup">
<div class="login-section">
<h1>Create new Account</h1>
<form action="register_admin.php" method="POST" name="reg">
<input type="text" id="name" name="name" placeholder="Name" value="" required="">
<input type="text" id="email" name="email" placeholder="Email" value="" required="">
<input type="text" id="location" name="location" placeholder="Location" value="" required="">

<input type="text" id="phone" name="phone" placeholder="Phone" value="" required="">
<input type="password" id="password" name="password" placeholder="Password" value="" required="">
<input onclick="return(submitreg());" type="submit" name="register" value="Register" />
</form>
</div>
</div>
</div>
</div>
</body>
</html>