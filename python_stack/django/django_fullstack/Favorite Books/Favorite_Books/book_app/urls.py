from django.urls import path     
from . import views
urlpatterns = [
    path('', views.books),
    path('add', views.add),
    path('favorite', views.favorite),
    path('favorite/<book_id>', views.favorite),
    path('<book_id>', views.details),
    path('update/<book_id>', views.update),
    path('delete/<book_id>', views.delete),
    path('unfavorite/<book_id>', views.unfavorite),

]