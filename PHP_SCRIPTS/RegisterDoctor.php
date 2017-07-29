<?php
$email = $_GET['email'];
$password = $_GET['password'];
$name = $_GET['name'];
$gender = $_GET['gender'];
$age = $_GET['age'];
$location = $_GET['location'];
$dob = $_GET['DOB'];
$hospital_id = $_GET['hosp'];
$phone = $_GET['phone'];
$altphone=$_GET['altphone'];
 $con = mysqli_connect('localhost','root','root','makeawish') or die('Unable to connect');
 
 
 
 $sql = "INSERT INTO doctor (email, password, name, age, phone, altphone, gender, DOB, hospital_id , approvedstatus) VALUES ('$email','$password','$name','$age','$phone','$altphone','$gender','$dob','$hospital_id','0')";
 
 
 if(mysqli_query($con,$sql)){
 echo '1';
 }
else {
echo 'Error'.$sql."</br>".mysqli_error($con);
}
  mysqli_close($con);
?>
