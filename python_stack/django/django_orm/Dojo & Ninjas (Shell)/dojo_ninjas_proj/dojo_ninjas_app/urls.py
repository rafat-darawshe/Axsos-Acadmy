from django.urls import path
from . import views
                    
urlpatterns = [
    path('', views.index),
    path('dojos/create', views.dojo_create), 
    path('ninjas/create', views.ninja_create)
]