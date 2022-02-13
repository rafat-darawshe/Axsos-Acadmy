
from django.shortcuts import render, redirect
from .models import dojos, ninjas


def index(request):
    all_dojos = dojos.objects.all
    context = {
        'all_dojos' : all_dojos
    }

    return render(request, "index.html", context)

def dojo_create(request):
    dojos.objects.create(
        name  = request.POST['name'],
        city  = request.POST['city'],
        state  = request.POST['state']
        
        
    )
    return redirect('/')

def ninja_create(request):
    if request.POST['dojo_id'] == '0':
        return redirect('/')
    else:
        dojo = dojos.objects.get(id=request.POST['dojo_id'])
        ninjas.objects.create(
            first_name  = request.POST['first_name'],
            last_name  = request.POST['last_name'],
            dojo = dojo
        )
    return redirect('/')