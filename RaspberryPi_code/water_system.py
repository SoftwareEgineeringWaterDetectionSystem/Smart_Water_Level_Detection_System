
import RPi.GPIO as GPIO
import urllib
import urllib2
import requests
from time import sleep
GPIO.setmode(GPIO.BCM)

try:

        while 1:
                url2 = 'http://softwareengineeing.000webhostapp.com/insert_water_level.php'
                count = 0
                GPIO.setup(2, GPIO.OUT, initial=GPIO.LOW)
                sleep(0.05)
                GPIO.setup(14, GPIO.IN)
                GPIO.setup(15, GPIO.IN)
                GPIO.setup(18, GPIO.IN)
                GPIO.setup(12, GPIO.IN)
                GPIO.setup(16, GPIO.IN)
                GPIO.setup(20, GPIO.IN)
                GPIO.setup(10, GPIO.IN)
                GPIO.setup(9, GPIO.IN)
                GPIO.setup(11, GPIO.IN)
                GPIO.setup(5, GPIO.IN)
                GPIO.setup(6, GPIO.IN)
                GPIO.setup(13, GPIO.IN)
                GPIO.setup(19, GPIO.IN)
                GPIO.setup(26, GPIO.IN)
                GPIO.setup(21, GPIO.IN)

                if(GPIO.input(14) == GPIO.LOW):
                        level=[('level','15')]
                        level = urllib.urlencode(level)
                        req = urllib2.Request(url2, level)
                        page=urllib2.urlopen(req).read()
                        print page
                        #count = 15
                        #print("level=%d")%count
                        sleep(1)
                elif(GPIO.input(15) == GPIO.LOW):
                        level=[('level','14')]
                        level = urllib.urlencode(level)
                        req = urllib2.Request(url2, level)
                        page=urllib2.urlopen(req).read()
                        print page
                        #count = 14
                        #print("level=%d")%count
                        sleep(1)
                elif(GPIO.input(18) == GPIO.LOW):
                        level=[('level','13')]
                        level = urllib.urlencode(level)
                        req = urllib2.Request(url2, level)
                        page=urllib2.urlopen(req).read()
                        print page
                        #count = 13
                        #print("level=%d")%count
                        sleep(1)
                elif(GPIO.input(12) == GPIO.LOW):
                        level=[('level','12')]
                        level = urllib.urlencode(level)
                        req = urllib2.Request(url2, level)
                        page=urllib2.urlopen(req).read()
                        print page
                        #count = 12
                        #print("level=%d")%count
                        sleep(1)
                elif(GPIO.input(16) == GPIO.LOW):
                        level=[('level','11')]
                        level = urllib.urlencode(level)
                        req = urllib2.Request(url2, level)
                        page=urllib2.urlopen(req).read()
                        print page
                        #count = 11
                        #print("level=%d")%count
                        sleep(1)
                elif(GPIO.input(20) == GPIO.LOW):
                        level=[('level','10')]
                        level = urllib.urlencode(level)
                        req = urllib2.Request(url2, level)
                        page=urllib2.urlopen(req).read()
                        print page
                        #count = 10
                        #print("level=%d")%count
                        sleep(1)
                elif(GPIO.input(10) == GPIO.LOW):
                        level=[('level','9')]
                        level = urllib.urlencode(level)
                        req = urllib2.Request(url2, level)
                        page=urllib2.urlopen(req).read()
                        print page
                        #count = 9
                        #print("level=%d")%count
                        sleep(1)
                elif(GPIO.input(9) == GPIO.LOW):
                        level=[('level','8')]
                        level = urllib.urlencode(level)
                        req = urllib2.Request(url2, level)
                        page=urllib2.urlopen(req).read()
                        print page
                        #count = 8
                        #print("level=%d")%count
                        sleep(1)
                elif(GPIO.input(11) == GPIO.LOW):
                        level=[('level','7')]
                        level = urllib.urlencode(level)
                        req = urllib2.Request(url2, level)
                        page=urllib2.urlopen(req).read()
                        print page
                        #count = 7
                        #print("level=%d")%count
                        sleep(1)
                elif(GPIO.input(5) == GPIO.LOW):
                        GPIO.output(2, GPIO.HIGH)
                        level=[('level','6')]
                        level = urllib.urlencode(level)
                        req = urllib2.Request(url2, level)
                        page=urllib2.urlopen(req).read()
                        print page
                        #count = 6
                        #print("level=%d")%count
                        sleep(1)
                elif(GPIO.input(6) == GPIO.LOW):
                        level=[('level','5')]
                        level = urllib.urlencode(level)
                        req = urllib2.Request(url2, level)
                        page=urllib2.urlopen(req).read()
                        print page
                        #count = 5
                        #print("level=%d")%count
                        sleep(1)
                elif(GPIO.input(13) == GPIO.LOW):
                        level=[('level','4')]
                        level = urllib.urlencode(level)
                        req = urllib2.Request(url2, level)
                        page=urllib2.urlopen(req).read()
                        print page
                        #count = 4
                        #print("level=%d")%count
                        sleep(1)
                elif(GPIO.input(19) == GPIO.LOW):
                        level=[('level','3')]
                        level = urllib.urlencode(level)
                        req = urllib2.Request(url2, level)
                        page=urllib2.urlopen(req).read()
                        print page
                        #count = 3
                        #print("level=%d")%count
                        sleep(1)
                elif(GPIO.input(26) == GPIO.LOW):
                        level=[('level','2')]
                        level = urllib.urlencode(level)
                        req = urllib2.Request(url2, level)
                        page=urllib2.urlopen(req).read()
                        print page
                        #count = 2
                        #print("level=%d")%count
                        sleep(1)
                elif(GPIO.input(21) == GPIO.LOW):
                        level=[('level','1')]
                        level = urllib.urlencode(level)
                        req = urllib2.Request(url2, level)
                        page=urllib2.urlopen(req).read()
                        print page
                        #count = 1
                        #print("level=%d")%count
                        sleep(1)
                else:
                        level=[('level','0')]
                        level = urllib.urlencode(level)
                        req = urllib2.Request(url2, level)
                        page=urllib2.urlopen(req).read()
                        print page
                        #url = "http://softwareengineering.000webhostapp.com/try_pali.php"
                        #response = urllib.urlopen(url).read()
                        #print response
                        #print("level=%d")%count


                        sleep(1)


except KeyboardInterrupt:
        print ("\nCtrl-C pressed. Program exiting...")

finally:
        GPIO.cleanup() # run on exit