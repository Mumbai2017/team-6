<?php

	include "connect.php";
	
	if($_POST['register']){
		$name = $_POST['name'];
		$email = $_POST['email'];
		$location = $_POST['location'];
		$password = $_POST['password'];
		$phone = $_POST['phone'];
		$sql = "INSERT INTO `mawstaff` (`name`,`email`,`location`,`phone`,`password`) VALUES ('$name','$email','$location','$phone','$password')";

		if ($connect->query($sql) === TRUE) {
		echo "New record created successfully";
		} else {
		echo "Error: " . $sql . "<br>" . $connect->error;
		}
	}


?>