
<?php
$server = "localhost";
$username = "root";
$password = "root";
$db_name = "makeawish";
$connect=mysqli_connect($server,$username,$password,$db_name) or die();
echo "hello";

if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }

?>
