from django.urls import path     
from . import views
urlpatterns = [
    path('', views.show),
    path('shows', views.all_show),
    path('shows/new', views.new),	
    path('shows/create', views.create_show),
    path('shows/<id>', views.shows_info),	
    path('shows/<id>/edit', views.edit),
    path('shows/<id>/update', views.update),
    path('shows/<id>/delete', views.delete),
      
]