from django.urls import path     
from . import views
urlpatterns = [
    path('', views.index),
    path('destroy_session', views.destroy_session),
    path('plus', views.plus),	   
]