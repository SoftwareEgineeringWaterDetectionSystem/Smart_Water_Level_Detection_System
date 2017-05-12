<?php 
error_reporting(0);
require "init_rpi.php";

$sql = "SELECT * FROM `water_level` WHERE now_date = CURDATE()";

$result = mysqli_query($con, $sql);

$response = array();

while($row = mysqli_fetch_array($result)){
	$response = array("now_date"=>$row[1],"now_time"=>$row[2],"level"=>$row[3]);
        echo json_encode(array($response));

}


?>
