from django.contrib.auth import get_user_model
from django.http import JsonResponse
from django.shortcuts import render
from django.views.generic import View
#import requests
from rest_framework.views import APIView
from rest_framework.response import Response
#import urllib.request
import pdb
import os
import sys
import json
import urllib
import urllib2

User = get_user_model()

class HomeView(View):
    def get(self, request, *args, **kwargs):
        return render(request, 'charts.html', {"customers": 10})



def get_data(request, *args, **kwargs):
    data = {
        "sales": 100,
        "customers": 10,
    }
    return JsonResponse(data) # http response


class ChartData(APIView):
    authentication_classes = []
    permission_classes = []
    """
    def get(self, request, format=None):
        qs_count = User.objects.all().count()
        labels = ["1pm", "2pm", "3pm", "4pm", "5pm", "6pm"]
        default_items = [qs_count, 89, 70, 75, 90, 50]
        data = {
                "labels": labels,
                "default": default_items,
        }
        print (data)
        return Response(data)
        """
    def get(self, request, format=None):
        qs_count = User.objects.all().count()
        url = "https://softwareengineeing.000webhostapp.com/read_water_level_daily.php"
        phpcontent = urllib2.urlopen(url, timeout=None)
        phpcontent = phpcontent.read()
        file = open("database.txt", "w+")
        print >> file, phpcontent
        file.close()
        database = open("database.txt", "r+")
        date_ = []
        levels = []
        for item in database:
			item = item.strip()
			if "date" in item:
				raw_data = item
				data_ = json.loads(raw_data)
				print (data_[0]["date"])
				date = data_[0]["date"]
				print (data_[0]["level"])
				level = data_[0]["level"]
				date_.append(date)
				levels.append(level)

        data = {
            "labels": date_,
            "default": levels,
        }
        print (data)
        return Response(data)  
