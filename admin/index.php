<?php
session_start();
include 'header.php';
include 'connect.php';
?>

<?php

echo "Login Successful";
echo $_SESSION['user'];

?>

<?php

include 'footer.php';


?>