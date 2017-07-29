<?php

         $email = $_GET['us'];
         $password = $_GET['pw'];

         $con = mysqli_connect("localhost","root","root","makeawish");
         if (!$con)
               {
                         die('Could not connect: ' . mysql_error());
                }

           mysqli_select_db($con ,"root");

           $query = "select email from doctor where email='$email' AND password='$password'";
            
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
else{
echo mysqli_error($con);
}
 mysqli_close($con);
               
    ?>
