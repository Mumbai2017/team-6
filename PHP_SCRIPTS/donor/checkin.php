<?php
// 	include 'db_connect.php';
// 	$response = array();
// 	if(isset($_POST['email'] && isset($_POST['pass']))){
// 		$email = $_POST['email'];
// 		$pass = $_POST['pass'];

// 		$result= mysqli_query("SELECT * FROM donor WHERE email = '$email' AND password= '$pass'") or die(mysql_error());
// 		if(mysqli_num_rows ($result) > 0){
// 			$response["details"]=array();
// 			while ($row = mysqli_fetch_array($result)){
// 				$details['email']=$row['email'];
// 				$details['password']=$row['password'];

// 				array_push($response["details"],$details);
// 			}
// 			$response["success"] = 1;
// 			echo json_encode($response);
// 		}
// 		else{

// 			$response["success"] = 0;
// 			$response["message"] = "No User Found. Please Register First.";
// 			echo json_encode($response);

// 	}
// }

	require 'db_connect.php'
	checkUser();
public function checkUser()
{
	global $connect;
	$email_id = $_POST['email'];
	$pass=$_POST['password'];

$email_id='test@gmail.com';
$pass='12345678';
echo $email_id;
echo $pass;
	$query = "SELECT * from donor WHERE email= '$email_id'and password='$pass'";
	$result = mysqli_query($connect , $query) or die (mysqli_error($connect));
	print_r($result);
	$number_rows = mysqli_num_rows($result);
	$details = array();
	if($number_rows>0){
		while ($row = mysqli_fetch_assoc($result)) {
			# code...
			$details [] = $row; 
		}
	}
	header('Content-Type: application/json');
	echo json_encode(array("donor"->$details));
	mysqli_close($connect);


}
?>
