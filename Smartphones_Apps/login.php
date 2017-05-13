<?php 
error_reporting(0);
require "init_rpi.php";


$sql = "SELECT * FROM `register_1` WHERE name='$_POST[name]' AND password='$_POST[password]'";



$result = mysqli_query($con, $sql);

$response = array();

while($row = mysqli_fetch_array($result)){
	$response = array("id"=>$row[0],"name"=>$row[1],"password"=>$row[2],"email"=>$row[3]);
}

echo json_encode(array("user"=>$response));

?>
