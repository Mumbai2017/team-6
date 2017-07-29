<?php

	
include 'connect.php';

$pid = $_POST['pid'];
$email = $_POST['email'];
$vid = $_POST['vid'];
echo $email;
    echo $vid."<br>";
    echo $pid;

if($_POST['submit']){
	$sql = "UPDATE `wishrecord` SET `wishstatus`=1 WHERE `pat_id` =  $pid  ";
	if ($connect->query($sql) === TRUE) {
    echo "Record updated successfully";
    
	}

	$sql1 = "UPDATE `wishrecord` SET `v_id`= $vid WHERE `pat_id` =  $pid  ";
	if ($connect->query($sql1) === TRUE) {
    echo "Record updated successfully";
    echo $sql1;
}
} else {
    echo "Error updating record: " . $connect->error;
    echo $email;
}



header("Location: index.php");


?>