from django.shortcuts import render, redirect
def index(request):
    if 'count' not in request.session:
        request.session['count'] = 0
    else:
        request.session['count'] += 1
    

    return render(request, 'index.html')

def destroy_session(request):
    request.session['count'] = 0
    
    return redirect("/")

def plus(request):
    request.session['count'] += 1
    
    return redirect("/")
