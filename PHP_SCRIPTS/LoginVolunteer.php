<?php

         $email = $_GET['us'];
         $password = $_GET['pw'];

         $con = mysqli_connect("localhost","root","root");
         if (!$con)
               {
                         die('Could not connect: ' . mysql_error());
                }

           mysqli_select_db($con ,"makeawish");

           $query = "select email from volunteers where email='$email' AND password='$password'";
            
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
