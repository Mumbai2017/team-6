<?php

         $email = $_GET['email'];
         $password = $_GET['password'];

         $con = mysqli_connect("localhost","root","root","makeawish");
         if (!$con)
               {
                         die('Could not connect: ' . mysql_error());
                }

     

           $query = "select name from donor where email='$email' AND password='$password'";
            
           $i=mysqli_query($con,$query);

         $count = 0;

          while($row = mysqli_fetch_array($i))
            {
             $count = $count+1;
           //  $nm = $row['Name'];
                             }
          
 if($count==1) {
echo "1";
}
else{
echo "hi".mysqli_error($con);
}
 mysqli_close($con);
               
    ?>
