<?php

error_reporting(0);

$db_name = "id1489556_software_eng";
$mysql_user = "id1489556_admin";
$mysql_pass = "software";
$server_name = "localhost";

$con = mysqli_connect($server_name, $mysql_user, $mysql_pass, $db_name);

if(!$con){
	echo '{"message":"Unable to connect to the database."}';
}


?>