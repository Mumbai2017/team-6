<?php
	include 'header.php';
	include 'connect.php';
?>

<div class="col-lg-6 col-md-12 padd">
							<div class="card">
	                            <div class="card-header" data-background-color="#47A34B">
	                                <h4 class="title">Notify Donars</h4>
	                                <p class="category">Check the status of wish here: </p>
	                            </div>
	                            <div class="card-content table-responsive">
	                                <table class="table table-hover">
	                                    <thead class="text-muted">
	                                    <th>Child Name</th>
	                                    	<th>Hospital Name</th>
	                                    	<th>Location</th>
	                                    	<th>Volunteer Contact Details</th>
	                                    	<th>Send Mail</th>
	                                    </thead>
	                                    <tbody>

<?php

//Here the volunteer will be assigned for an approved request 
//Volunteers will be send an email 
//They can accept or decline the request

if($_POST['submit']){
$pid = $_POST['pid'];
$location = $_POST['location'];

	$sql = "SELECT `pid`,`name`,`wish_id`,`hospital`,`address` from `patient` where `pid` = $pid";
	$result = $connect->query($sql);
	if ($result->num_rows > 0) {
    // output data of each row
	    while($row = $result->fetch_assoc()) {
	    	$wish_id = $row['wish_id'];
	    	$p_id = $row['pid'];
	    	$name = $row['name'];
	    	$hospital = $row['hospital'];
	    	$location = $row['address'];

	    $sql1 = "SELECT `vid`,`email`,`phone` from `volunteers` where `location` = '$location' and `type` = 1";
		$result1 = $connect->query($sql1);
		if ($result1->num_rows > 0) {
			while($row1 = $result1->fetch_assoc()) {
				$vid = $row1['vid'];
				$volunteer_email = $row1['email'];
				$volunteer_phone = $row1['phone'];

				echo "
                <tr>
                	<td>".$name."</td>
                	<td>".$hospital."</td>
                	<td>".$location."</td>                	<td>".$volunteer_phone."</td>
                	<td><form action='volunteer_email.php' method='post'>
                	<input type='hidden' name= 'email' value=".$volunteer_email." />
                		<input type='hidden' name= 'name' value=".$name." />
                		<input type='hidden' name= 'pid' value=".$pid." />
                		<input type='hidden' name= 'hospital' value=".$hospital." />
                		<input type='hidden' name= 'location' value=".$location." />
                		<input type='hidden' name= 'vid' value=".$vid." />
                	<input type= 'submit' value= 'Request Visit' name='submit' /></form></td>
                </tr>";


			}

		}


	}

}

}


?>


<?php
	
	include 'footer.php';

?>