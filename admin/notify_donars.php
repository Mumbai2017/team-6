<?php
	include 'header.php';
	include 'connect.php';
?>

<div class="col-lg-6 col-md-12 padd">
							<div class="card">
	                            <div class="card-header" data-background-color="#47A34B">
	                                <h4 class="title">Children's Wish Status</h4>
	                                <p class="category">Check the status here: </p>
	                            </div>
	                            <div class="card-content table-responsive">
	                                <table class="table table-hover">
	                                    <thead class="text-warning">
	                                    <th>Donar Name</th>
	                                    	<th>Child Name</th>
	                                    	<th>Status</th>
	                                    	<th>Send Mail</th>
	                                    </thead>
	                                    <tbody>

<?php

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
    		if($status == 5){
    			echo "
                <tr>
                	<td>".$donar_name."</td>
                	<td>".$name."</td>
                	<td>5</td>
                	<td><form action='mail.php' method='post'><input type='hidden' name= 'email' value=".$donar_email." /><input type= 'submit' value= 'Send a Mail' name='submit' /></form></td>
                </tr>";
    	}
    	}
    }
        }
} else {
    echo "No entries in the table";
}
	
}

}
?>

    
	                                        
	                                    </tbody>
	                                </table>
	                            </div>
	                        </div>
						</div>
					</div>
				</div>
			</div>

<?php
	
	include 'footer.php';

?>