 
 <?php
$refname = $_GET['refname'];
$fathername = $_GET['fathername'];
$mothername = $_GET['mothername'];
$disease = $_GET['disease'];
$dob = $_GET['DOB'];
// $type = $_GET['type'];

// $phone = $_GET['phone'];
 $con = mysqli_connect('localhost','root','root','makeawish') or die('Unable to connect');

 
 $query ="select count(refname) as cnt from volunteers where refname= '$refname' AND fathername = '$fathername' AND mothername = '$mothername'";
$result=mysqli_query($con,$query);
$row=mysqli_fetch_assco($result);
if(row["cnt"]==0){
$sql = "INSERT INTO doctorreferral VALUES ('$refname','$fathername','$mothername','$disease','$dob')";
 mysqli_query($con,$sql);
 echo "1";
}
else {
echo "2";
}
  mysqli_close($con);
