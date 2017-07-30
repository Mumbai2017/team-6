<?php
         $email = $_GET['us'];
         $password = $_GET['pw'];
$con = mysqli_connect('localhost','root','root','makeawish') or die('Unable to connect');
$query = "select email from doctor where email='$email' AND password='$password'";
            
           $i=mysqli_query($con,$query);
         $count = 0;
          while($row = mysqli_fetch_array($i))
            {
             $count = $count+1;
           //  $nm = $row ['Name'];
                             }
          
 if($count==1) {
echo "1";
}
 mysqli_close($con);
               
    ?>
