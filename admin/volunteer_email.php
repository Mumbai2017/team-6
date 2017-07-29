<?php
/*
$to = "aditisakhare21@gmail.com";
$subject = "Welcome to TestCompany";
$body = "Hello Aditi, Your registration is successfull.\nPlease confirm by clicking this link.";
$headers = "From: noreply@gmail.com";

if(mail($to,$subject,$body,$headers))
	echo "Mail has been sent to ".$to;
else
	echo "Error. Mail could not be sent. Try again.";	

print phpinfo();
*/

?>
<?php
include 'connect.php';
require 'PHPMailer-master/PHPMailerAutoload.php';

if($_POST['submit']){
	$vid = $_POST['vid'];
$volunteer_email = $_POST['email'];
$name= $_POST['name'];
$hospital = $_POST['hospital'];
$location = $_POST['location'];
$pid = $_POST['pid'];
}

$mail = new PHPMailer;


//$mail->SMTPDebug = 3;                               // Enable verbose debug output

$mail->isSMTP();                                      // Set mailer to use SMTP
$mail->Host = 'smtp.gmail.com';  // Specify main and backup SMTP servers
$mail->SMTPAuth = true;                               // Enable SMTP authentication
$mail->Username = 'testcompany610@gmail.com';                 // SMTP username
$mail->Password = 'safesafe123';                           // SMTP password
$mail->SMTPSecure = 'tls';                            // Enable TLS encryption, `ssl` also accepted
$mail->Port = 587;                                    // TCP port to connect to
$mail->setLanguage('fr', '/optional/path/to/language/directory');

$mail->setFrom('testcompany610@gmail.com', 'Test Company');
$mail->addAddress($volunteer_email);     // Add a recipient
//$mail->addAddress('aditisakhare21.com');               // Name is optional
$mail->addReplyTo('aditisakhare21@gmail.com', 'Information');
//$mail->addCC('cc@example.com');
//$mail->addBCC('bcc@example.com');

//$mail->addAttachment('/var/tmp/file.tar.gz');         // Add attachments
//$mail->addAttachment('assets/img/wish1.jpg', 'new.jpg');    // Optional name
$mail->isHTML(true);                                  // Set email format to HTML

$mail->Subject = 'Here is the subject';
$mail->Body    = " Request for a visit:
<br>
<b>Details are as follows</b>:
<br>

<b>Name of Child</b>: ".$name."
<br>
<b>Hospital</b>: ".$hospital."
<br>
<b>Location</b>: ".$location."
<form action= 'http://localhost/team-6/admin/update_request.php' method = 'POST' >
<input type = 'submit' name='submit' value = 'Accept' />
<input type = 'hidden' name='pid' value=".$pid." />
<input type = 'hidden' name='email' value=".$volunteer_email." />
<input type = 'hidden' name='vid' value=".$vid." />
<input type = 'submit' name='submit1' value = 'Reject' />
</form>
"
;
$mail->AltBody = 'This is the body in plain text for non-HTML mail clients';
if(!$mail->send()) {
    echo 'Message could not be sent.';
    echo 'Mailer Error: ' . $mail->ErrorInfo;
} else {
    echo 'Message has been sent';
    
}


header("Location: index.php");
?>