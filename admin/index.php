<?php
session_start();
include 'header.php';
include 'connect.php';
?>

<?php


if($_POST['submit']){

$email = $_POST['email'];
$password = $_POST['password'];

$sql = "SELECT `name` FROM `mawstaff` where `email`= '$email' AND `password`='$password' ";
$result = $connect->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo "Login Successful";
        $_SESSION['user'] = $row['name'];
        echo $_SESSION['user'];
    }
} else {
    echo "0 results";
}

}
?>

<?php

include 'footer.php';


?>