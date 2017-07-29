<?php

         $name = $_GET['name'];
         $fathername = $_GET['fathername'];
         $mothername = $_GET['mothername'];
        $dob = $_GET['dob'];

         $con = mysqli_connect("localhost","root","root","makeawish");
         if (!$con)
               {
                         die('Could not connect: ' . mysql_error());
                }

           mysqli_select_db($con ,"root");

           $query = "select name from doctor where name='$name' AND fathername='$fathername' AND mothername='$mothername' AND DOB='$dob'";
            
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
elseif($count==0){
    echo ""0;
}
else{
    echo mysqli_error($con);
}

 mysqli_close($con);
               
    ?>
