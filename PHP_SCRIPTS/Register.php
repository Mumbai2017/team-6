<?php
$email = $_GET['email'];
$password = $_GET['password'];
$name = $_GET['name'];
$gender = $_GET['gender'];
$location = $_GET['location'];
$dob = $_GET['DOB'];
$type = $_GET['type'];

$phone = $_GET['phone'];

 $con = mysqli_connect('13.229.56.82','','') or die('Unable to connect');

 $sql = "INSERT INTO volunteers (email,password,name,gender,location,DOB,type,phone) VALUES('$email','$password','$name',$gender,'$location','$dob','$type','$phone')";


 if(mysqli_query($con,$sql)){
 echo '1';
 }
else {
echo 'Error';
}
  mysqli_close($con);
