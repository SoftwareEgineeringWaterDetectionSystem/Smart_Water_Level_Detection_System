<?php
error_reporting(0);
require "init_rpi.php";

$name = $_POST["name"];
$password = $_POST["password"];
$email = $_POST["email"];

//$name = "sdf";
//$password = "sdf";
//$email = "sdf@r54";

//$sql = "INSERT INTO `user_info` (`id`,`name`, `password`, `email`) VALUES (NULL, '".$name."', '".$password."', '".$email."');";
$sql = "INSERT INTO `register_1` (`id`,`name`, `password`, `email`) VALUES (NULL, '".$name."', '".$password."', '".$email."');";
if(!mysqli_query($con, $sql)){
	echo '{"message":"Unable to save the data to the database."}';
}

?>