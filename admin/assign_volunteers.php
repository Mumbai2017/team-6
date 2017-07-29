<?php
	include 'header.php';
	include 'connect.php';
?>

<div class="col-lg-6 col-md-12 padd">
							<div class="card">
	                            <div class="card-header" data-background-color="blue">
	                                <h4 class="title"></h4>
	                                <p class="category">Approved Wishes : </p>
	                            </div>
	                            <div class="card-content table-responsive">
	                                <table class="table table-hover">
	                                    <thead class="text-info">
	                                    
	                                    	<th>Child Name</th>
	                                    	<th>Hospital</th>
	                                    	<th>Status</th>
	                                    	<th>Proceed</th>
	                                    </thead>
	                                    <tbody>

<?php

$sql = "SELECT `pid`,`name`,`wish_id`,`hospital`,`address` from `patient`";
$result = $connect->query($sql);
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
    	$wish_id = $row['wish_id'];
    	$p_id = $row['pid'];
    	$name = $row['name'];
    	$hospital = $row['hospital'];
    	$location = $row['address'];

        $sql1 = "SELECT `wishstatus` from `wishrecord` where `w_id` = '$wish_id'";
		$result1 = $connect->query($sql1);
		if ($result1->num_rows > 0) {
    	// output data of each row
    	while($row1 = $result1->fetch_assoc()) {
    		$status = $row1['wishstatus'];
    		if($status == 0){
    			echo "
                <tr>

                	<td>".$name."</td>
                	<td>".$hospital."</td>
                	<td>0</td>

                	<td><form action='select_volunteer.php' method='post'><input type='hidden' name= 'location' value=".$location." /><input type='hidden' name= 'pid' value=".$p_id." /><input type= 'submit' value= 'Proceed further' name='submit' /></form></td>
                </tr>";
    	}
    	}
    }
        }
} else {
    echo "No entries in the table";
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