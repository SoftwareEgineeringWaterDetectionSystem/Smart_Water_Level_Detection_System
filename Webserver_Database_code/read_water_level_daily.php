<?php 
error_reporting(0);
require "init_rpi.php";

$sql = "SELECT * FROM `water_level` WHERE now_date = CURDATE()";

$result = mysqli_query($con, $sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo '[{"date":"' . $row["now_date"]. '","level":"' . $row["level"]. '"'. "}]\r\n";
        
    }
} else {
    echo "0 results";
}
?>
