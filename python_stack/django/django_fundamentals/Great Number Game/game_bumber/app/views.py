from importlib.resources import contents
from multiprocessing import context
from django.shortcuts import render, HttpResponse, redirect
import random

def game(request):
    if 'guess_c' not in request.session:
        request.session['guess_c'] = random.randint(1, 100)
        request.session['too_low'] = False
        request.session['too_high'] = False
        request.session['just_right'] = False
     
    return render(request, 'game.html')
    
def guess(request):
    request.session['too_low'] = False
    request.session['too_high'] = False
    request.session['just_right'] = False
    
    if (int(request.POST['guess']) < request.session['guess_c']):
        request.session['too_low'] = True
        
    elif (int(request.POST['guess']) > request.session['guess_c']):
        request.session['too_high'] = True
        
    else:
        request.session['just_right'] = True    
    

    return redirect('/')

def reset(request):
    request.session.flush()
    
    return redirect('/')