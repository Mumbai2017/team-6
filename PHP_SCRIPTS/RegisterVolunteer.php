<?php
$email = $_GET['email'];
$password = $_GET['password'];
$name = $_GET['name'];
$gender = $_GET['gender'];
$location = $_GET['location'];
$dob = $_GET['DOB'];
$type = $_GET['type'];
$phone = $_GET['phone'];

 $con = mysqli_connect('localhost','root','root','makeawish') or die('Unable to connect');

<<<<<<< HEAD
 $sql = "INSERT INTO volunteers (vid, email, password, name , gender, location, DOB, type) VALUES (NULL,'$email','$password','$name','$gender','$location','$dob','$type')";


=======
 $sql = "INSERT INTO volunteers (vid, email, password, name , gender, location, DOB, type, phone) VALUES (NULL,'$email','$password','$name','$gender','$location','$dob','$type','$phone')";
>>>>>>> ea56a9a5552348428d67eabe92e3ed90bd56635b

 if(mysqli_query($con,$sql)){
 echo '1';
 }
else {
echo 'Error'.$sql."</br>".mysqli_error($con);
}
  mysqli_close($con);
?>
