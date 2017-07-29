<?php

include 'connect.php';
$email = $_POST['email'];
echo $email;

if($_POST['submit1']){
	$sql = "UPDATE `doctor` SET `approvedstatus`=1 WHERE `email` = '$email'";

	if ($connect->query($sql) === TRUE) {
    echo "Record updated successfully".$email;
} else {
    echo "Error updating record: " . $connect->error;
    echo $email;
}

}
else{

	$sql = "DELETE FROM `doctor` WHERE `email`='$email'";

	if ($connect->query($sql) === TRUE) {
    echo "Record deleted successfully".$email;
} else {
    echo "Error deleting record: " . $connect->error;
    echo $email;
}


}

header("Location: approve_doctors.php");

?>