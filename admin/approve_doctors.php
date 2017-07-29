<?php
	include 'header.php';
	include 'connect.php';
?>


	        <div class="content">
	            <div class="container-fluid">
	                <div class="row">
	                    <div class="col-md-12">
	                        <div class="card">
	                            <div class="card-header" data-background-color="purple">
	                                <h4 class="title">Simple Table</h4>
	                                <p class="category">Here is a subtitle for this table</p>
	                            </div>
	                            <div class="card-content table-responsive">
	                                <table class="table">
	                                    <thead class="text-primary">
	                                    	<th>Name</th>
	                                    	<th>Email</th>
	                                    	<th>Status</th>
											<th>Approve</th>
											<th>Reject</th>
	                                    </thead>
	                                    
	                                        
	                                        	                                        
	                                        
	                                    

<?php
	
	$sql = "SELECT * FROM `doctor` where `approvedstatus` = 0";
	$result = $connect->query($sql);

	if ($result->num_rows > 0) {
	    // output data of each row
	    while($row = $result->fetch_assoc()) {
	        
	        $name = $row['name'];
	        $email = $row['email'];
	        $age = $row['age'];
	        $phone = $row['phone'];
	        $approvedstatus = $row['approvedstatus'];
	        
	        echo "<tr>
	       <td>".$name."</td>	
	       <td>".$email."/td>	
	       <td>".$approvedstatus."</td>
	       <td><form method='POST' action='ap_re_doc.php'><input type='submit' name='submit1' value= 'Approve'/></td>
	       	       <td><input type='submit' name='submit2' value= 'Reject'/>
	       	       <input type='hidden' name='email' value= '".$email."'/></form></td>	
	       </tr>";
	    }
	    
	} else {
	    echo "Error";
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