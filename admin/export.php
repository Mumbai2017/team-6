<?php
    include 'connect.php';
    if(isset($_POST['export'])){
        $tab=$_POST['select'];
        //echo $tab;
        ob_end_clean();
         header('Content-Type: text/csv; charset=utf-8');  
      header('Content-Disposition: attachment; filename=data.csv');  
      $output = fopen("php://output", "w");  
      //fputcsv($output, array('', 'First Name', 'Last Name', 'Email', 'Joining Date'));  
      $query = "SELECT * from $tab";  
      $result = mysqli_query($connect, $query); 
    
    while($row = mysqli_fetch_assoc($result))  
      {  
            fputcsv($output,array_keys($row));
           fputcsv($output, $row);  
      }  
      fclose($output); 
    }
    
    ?>


<?php
  
 
  include 'header.php';

?>

<div class="container padd">
<form action="export.php" method="POST" role="form">
	<legend>Form title</legend>

	<div class="form-group">
	<select name="select">
    <option value="mawstaff">Admin</option>
    <option value="doctor">Doctor</option>
    <option value="donor">Donor</option>
    <option value="wishrecord">Wish Record</option>
    </select>

<input type="submit" class="btn btn-default" name="export" value="Export CSV">

	</div>
</form>


</div>

<script>

</script>

<?php

  include 'footer.php';

?>




