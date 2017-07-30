 
 <?php
$refname = $_GET['refname'];
$fathername = $_GET['fathername'];
$mothername = $_GET['mothername'];
$disease = $_GET['disease'];
$dob = $_GET['DOB'];
// $type = $_GET['type'];

// $phone = $_GET['phone'];
 $con = mysqli_connect('localhost','root','root','makeawish') or die('Unable to connect');
 
 $query ="select refname from volunteers where refname= '$refname' AND fathername = '$fathername' AND mothername = '$mothername'";
 $sql = "INSERT INTO doctorreferral VALUES ('$refname','$fathername','$mothername','$disease','$dob')";

 if(mysqli_query($con,$sql)){
 echo '1';
 }
else if(mysqli_query($con,$query)){
echo '2';
}
  mysqli_close($con);