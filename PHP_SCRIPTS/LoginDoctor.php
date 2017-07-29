<?php

         $email = $_GET['email'];
         $password = $_GET['password'];

         $con = mysqli_connect("localhost","root","root");
         if (!$con)
               {
                         die('Could not connect: ' . mysql_error());
                }

           mysqli_select_db($con ,"root");

           $query = "select Name from doctor where email='$email' AND password='$password'";
            
           $i=mysqli_query($con,$query);

         $count = 0;

          while($row = mysqli_fetch_array($i))
            {
             $count = $count+1;
           //  $nm  =  $row['Name'];
                             }
          
 if($count==1) {
echo "1";
}
 mysqli_close($con);
               
    ?>
