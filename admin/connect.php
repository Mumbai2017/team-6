
<?php
$server = "localhost";
$username = "root";
$password = "";
$db_name = "makeawish";
$connect=mysqli_connect($server,$username,$password,$db_name) or die();
if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }

?>