<?php 
error_reporting(0);
require "init_rpi.php";

//$name = $_POST["name"];
//$password = $_POST["password"];

//$name = "www";
//$password = "www";

//$sql = "SELECT * FROM `user_info` WHERE name='".$name."' AND `password`='".$password."';";
//$sql = "SELECT * FROM `register_1` WHERE name='$_GET[name]' AND password='$_GET[password]'";
$sql = "SELECT * FROM `register_1` WHERE name='$_POST[name]' AND password='$_POST[password]'";


//if(!mysqli_query($con, $sql)){
//	echo '{"message":"Unable to get the data to the database."}';
//}

//if(mysqli_query($con, $sql)){
//	echo '{"message":"Good."}';
//}

$result = mysqli_query($con, $sql);

$response = array();

while($row = mysqli_fetch_array($result)){
	$response = array("id"=>$row[0],"name"=>$row[1],"password"=>$row[2],"email"=>$row[3]);
}

echo json_encode(array("user"=>$response));

?>
