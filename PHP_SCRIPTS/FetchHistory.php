<?php
  $connect = mysqli_connect('localhost','root','root','makeawish') or die('Unable to connect');
  $sql3 = "SELECT `did`,`email`, `name`, `p_id` FROM `donor`";
$result3 = $connect->query($sql3);
if ($result3->num_rows > 0) {
    // output data of each row
    while($row3 = $result3->fetch_assoc()) {

    		$p_id = $row3['p_id'];
    		$donar_name = $row3['name'];
    		$donar_email = $row3['email'];

$sql = "SELECT `pid`,`name`,`wish_id` from `patient` where `pid`= '$p_id'";
$result = $connect->query($sql);
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
    	$wish_id = $row['wish_id'];
    	$p_id = $row['pid'];
    	$name = $row['name'];

        $sql1 = "SELECT `wishstatus` from `wishrecord` where `w_id` = '$wish_id'";
		$result1 = $connect->query($sql1);
		if ($result1->num_rows > 0) {
    	// output data of each row
    	while($row1 = $result1->fetch_assoc()) {
    		$status = $row1['wishstatus'];
    		echo $donar_name . " - " . $status."<br />";
      }
    }
    }}}}
?>
