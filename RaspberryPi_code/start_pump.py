import RPi.GPIO as GPIO
import urllib
import urllib2
import requests
from time import sleep
GPIO.setmode(GPIO.BCM)

try:
	urllib.urlopen('http://akuzul.pagekite.me/killclean.php')
        sleep(1)
	urllib.urlopen('http://akuzul.pagekite.me/kill.php')
	sleep(1)
	while 1:   
            GPIO.setup(2, GPIO.OUT, initial=GPIO.LOW)
            sleep(0.05)
	    GPIO.output(2, GPIO.HIGH)
            sleep(1)


except KeyboardInterrupt:
        print ("\nCtrl-C pressed. Program exiting...")

finally:
        GPIO.cleanup() # run on exit
