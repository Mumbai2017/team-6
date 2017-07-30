<?php
$referreddetails = $_GET['referreddetails'];
$w_id = $_GET['w_id'];
$pt_id = $_GET['pt_id'];
$special_notes = $_GET['pecialnotes'];
$dateofadmission = $_GET['dateofadmission'];
$dateidentified = $_GET['dateidentified'];
$wish1 = $_GET['wish1'];
$wish2 = $_GET['wish2'];
$wish3 = $_GET['wish3'];
$proposedate=$_GET['proposedate'];
$runwish = $_GET['runwish'];
$dateofsubmission=$_GET['dateofsubmission'];
$daysrequired=$_GET['daysrequired'];
$approvedwish=$_GET['approvedwish'];
$v_id=$_GET['v_id'];
$d1= $_GET['d1'];
$d2=$_GET['d2'];
$d3=$_GET['d3'];
$approvedbystaff= $_GET['approvedbystaff'];
$approvaldate=$_GET['approvaldate'];
$dateofwish=$_GET['dateofwish'];
$infoaboutfamily=$_GET['infoaboutfamily'];
$infoaboutfriend=$_GET['inforaboutfriend'];
$govidtaken=$_GET['govidtaken'];
$favcolor=$_GET['favcolor'];
$favbook=$_GET['favbook'];
$favgame=$_GET['favgame'];
$favfood=$_GET['favfood'];
$favmusic=$_GET['favmusic'];
$favhobby=$_GET['favhobby'];
$favshow=$_GET['favshow'];
$favactor=$_GET['favactor'];
$schooltrip=$_GET['schooltrip'];
$futurewish=$_GET['futurewish'];
$input1=$_GET['input1'];
$input2=$_GET['input2'];
$input3=$_GET['input3'];
$wishstatus=$_GET['wishstatus'];

 $con = mysqli_connect('localhost','root','root','makeawish') or die('Unable to connect');
 
 
 
 $sql = "INSERT INTO wishrecord VALUES ('$referreddetails','$w_id','$pt_id','$special_notes','$dateofadmission','$dateidentified','$wish1','$wish2','$wish3','$proposedate','$runwish','$dateofsubmission','$daysrequired','$approvedwish','$v_id','$d1','$d2','$d3','$approvedbystaff','$approvaldate','$dateofwish','$infoaboutfamily','$infoaboutfriend','$govidtaken','$favcolor','$favbook','$favgame','$favfood','$favmusic','$favhobby','$favshow','$favactor','$schooltrip','$futurewish','$input1','$input2','$input3','$wishstatus')";
 
 
 if(mysqli_query($con,$sql)){
 echo '1';
 }
else {
echo 'Error'.$sql."</br>".mysqli_error($con);
}
  mysqli_close($con);
?>
