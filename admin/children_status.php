<?php
	include 'header.php';
	include 'connect.php';
?>
<div class="col-lg-6 col-md-12 padd">
							<div class="card">
	                            <div class="card-header" data-background-color="orange">
	                                <h4 class="title">Children's Wish Status</h4>
	                                <p class="category">Check the status here: </p>
	                            </div>
	                            <div class="card-content table-responsive">
	                                <table class="table table-hover">
	                                    <thead class="text-warning">
	                                    <th>Child ID</th>
	                                    	<th>Name</th>
	                                    	<th>Wish Id</th>
	                                    	<th>Status</th>
	                                    </thead>
<?php

//	$sql = "SELECT `patient.name`, `wishrecord.status` 
//FROM `patient` INNER JOIN `wishrecord` ON `patient.wish_id`=`wishrecord.w_id`";

$sql = "SELECT `pid`,`name`,`wish_id` from `patient`";
$result = $connect->query($sql);
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
    	$wish_id = $row['wish_id'];
    	$p_id = $row['pid'];
    	$name = $row['name'];

        $sql1 = "SELECT `wishstatus` from `wishrecord` where `w_id` = $wish_id";
		$result1 = $connect->query($sql1);
		if ($result1->num_rows > 0) {
    	// output data of each row
    	while($row1 = $result1->fetch_assoc()) {
    		$status = $row1['wishstatus'];
    		echo "<tbody>
                <tr>
                	<td>".$p_id."</td>
                	<td>".$name."</td>
                	<td>".$wish_id."</td>
                	<td>".$status."</td>
                </tr>";
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