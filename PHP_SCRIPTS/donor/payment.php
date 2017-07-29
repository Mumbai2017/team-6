<?php
	if($_SERVER["REQUEST_METHOD"]=="POST"){
	require 'db_connect.php'
	makePayment();

}
public function checkUser()
{
	global $connect;
	$email_id = $_POST[''];
	$pass=$_POST['password'];

	$query = "SELECT * from donor WHERE dn_email= '$email_id;'";
	$result = mysqli_query($connect , $query) or die (mysqli_error($connect));
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