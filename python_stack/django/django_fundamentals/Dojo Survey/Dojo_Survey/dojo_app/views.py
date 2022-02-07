from django.shortcuts import render, redirect 
def index(request):
    return render(request,"index.html")
def result(request):
    if request.method == 'POST':
        context = {
            "username" : request.POST['username'],
            "location" : request.POST['location'],
            "fav" : request.POST['fav'],
            "comment" : request.POST['comment']
        }
        return render(request,"show.html", context)
    return render(request,"show.html")
