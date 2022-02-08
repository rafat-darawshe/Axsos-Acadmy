from django.urls import path     
from . import views
urlpatterns = [
    path('', views.game),
    path('guess', views.guess),
    path('reset', views.reset),
]