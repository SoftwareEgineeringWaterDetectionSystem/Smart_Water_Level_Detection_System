<?php 
error_reporting(0);
require "init_rpi.php";

$level = $_POST["level"]; //water_level
//$level = "2";
date_default_timezone_set("Asia/Kuala_Lumpur");
$time = date("H:i:s");
echo $time;
$sql = "INSERT INTO water_level (now_date, now_time, level)
VALUES (now(), '".$time."', '".$level."')";

//echo $sql ;

if(!mysqli_query($con, $sql)){
	echo '{"message":"Unable to save the data to the database."}';
}
else{
	echo '{"message":"Table updated"}';
}
$conn->close();
?>
