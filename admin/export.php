<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" media="screen" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/css/bootstrap.min.css">

    <title>Export</title>
<!--  -->
<style>

</style>

</head>

<body>

<div class="container">
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
</body>

</html>
<?php
    include 'connect.php';
    echo "hello";
    if(isset($_POST['export'])){
        $tab=$_POST['select'];
        echo $tab;
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



