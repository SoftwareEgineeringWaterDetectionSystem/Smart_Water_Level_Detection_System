import RPi.GPIO as GPIO
import urllib
import requests
from time import sleep
GPIO.setmode(GPIO.BCM)

try:
        urllib.urlopen('http://akuzul.pagekite.me/killpump.php')
        urllib.urlopen('http://akuzul.pagekite.me/kill.php')
	while 1:
            GPIO.setup(2, GPIO.OUT, initial=GPIO.LOW)
            GPIO.output(2, GPIO.LOW)
            sleep(0.05)
	    sleep(1)

finally:
        GPIO.cleanup() # run on exit
