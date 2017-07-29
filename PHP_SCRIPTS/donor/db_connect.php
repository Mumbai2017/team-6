<?php
	$conn= mysqli_connect("http://13.229.56.82/phpmyadmin","root","root",makeawish);
	if(!$conn){
		echo "Connection Failed"
	}
	session_start();
?>