<?php
$email = $_GET['email'];
$password = $_GET['password'];
$name = $_GET['name'];
// $gender = $_GET['gender'];
$location = $_GET['location'];
$dob = $_GET['DOB'];
//$type = $_GET['type'];
$phone = $_GET['phone'];
 $con = mysqli_connect('localhost','root','root','makeawish') or die('Unable to connect');
 $sql = "INSERT INTO `donor` (`did`, `email`, `password`, 'name' , `location`, `DOB`,`phone`) VALUES (NULL,'$email','$password','$name','$location','$dob','$phone')";
 if(mysqli_query($con,$sql)){
 echo '1';
 }
else {
echo 'Error';
}
  mysqli_close($con);
?>