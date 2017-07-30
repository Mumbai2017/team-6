
<?php
	include 'header.php';
	include 'connect.php';
?>

<div class="col-lg-6 col-md-12 padd">
							<div class="card">
	                            <div class="card-header" data-background-color="orange">
	                                <h4 class="title">Prioritized Queue</h4>
	                                <p class="category">Check the suggested status here: </p>
	                            </div>
	                            <div class="card-content table-responsive">
	                                <table class="table table-hover">
	                                    <thead class="text-warning">
	                                    <th>Child ID</th>
	                                    	<th>Name</th>
	                                    	<th>Wish Id</th>
	                                    	<th>Status</th>
	                                    </thead>
	                                    <tbody>
<?php
$month = 07;
$date = 30;


$sql = "SELECT * from `patient`";
$result = $connect->query($sql);
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
    	$wish_id = $row['wish_id'];
    	$p_id = $row['pid'];
    	$name = $row['name'];
    	$dob = $row['DOB'];
    	$convert_date = strtotime($dob);
        $month = date('F',$convert_date);
        $year = date('Y',$convert_date);
        $name_day = date('l',$convert_date);
        $day = date('j',$convert_date);
    	$days = $day - $date;

    	//echo $p_id."<br>";
    	$sql2 = " SELECT * from `wishrecord` where `w_id` = $wish_id and (`rushwish`= 1 and $days <= 7) and `wishstatus` = 0 ";
		$result2 = $connect->query($sql2);
		if ($result2->num_rows > 0) {

    	// output data of each row
    	while($row2 = $result2->fetch_assoc()) {
    		$status = $row2['wishstatus'];
    		echo "
                <tr>
                	<td>".$p_id."</td>
                	<td>".$name."</td>
                	<td>".$wish_id."</td>
                	<td>".$status."</td>
                </tr>";
    	}
    }

    $sql3 = "SELECT * from `wishrecord` where `w_id` = $wish_id and (`rushwish`= 0 and $days <= 7 ) and `wishstatus` = 0";
		$result3 = $connect->query($sql3);
		if ($result3->num_rows > 0) {
    	// output data of each row
    	while($row3 = $result3->fetch_assoc()) {
    		$status = $row3['wishstatus'];
    		echo "
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
/*
    $sql2 = "SELECT * from `wishrecord` where `w_id` = $wish_id and (`rushwish`= 1 and $days > 7) and `wishstatus` = 0";
		$result2 = $connect->query($sql2);
		if ($result2->num_rows > 0) {
    	// output data of each row
    	while($row2 = $result2->fetch_assoc()) {
    		$status = $row2['wishstatus'];
    		echo "
                <tr>
                	<td>".$p_id."</td>
                	<td>".$name."</td>
                	<td>".$wish_id."</td>
                	<td>".$status."</td>
                </tr>";
    	}
    }

    $sql3 = "SELECT * from `wishrecord` where `w_id` = $wish_id and (`rushwish`= 0 and $days <= 7 ) and `wishstatus` = 0";
		$result3 = $connect->query($sql3);
		if ($result3->num_rows > 0) {
    	// output data of each row
    	while($row3 = $result3->fetch_assoc()) {
    		$status = $row3['wishstatus'];
    		echo "
                <tr>
                	<td>".$p_id."</td>
                	<td>".$name."</td>
                	<td>".$wish_id."</td>
                	<td>".$status."</td>
                </tr>";
    	}
    }

    $sql4 = "SELECT * from `wishrecord` where `w_id` = $wish_id and (`rushwish`= 0 and $days > 7 ) and `wishstatus` = 0";
		$result4 = $connect->query($sql4);
		if ($result4->num_rows > 0) {
    	// output data of each row
    	while($row4 = $result4->fetch_assoc()) {
    		$status = $row4['wishstatus'];
    		echo "
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
	
*/
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