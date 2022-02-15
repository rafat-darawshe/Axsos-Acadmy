from distutils import errors
from django.shortcuts import render, HttpResponse, redirect
from django.contrib import messages
from .models import *
import bcrypt

def index(request):
    
    return render(request, 'login.html')

def success(request):
    if 'user_id' not in request.session:
        return redirect('/')
    return render(request, 'success.html')

def register(request):
    if request.method == 'POST':
        errors = User.objects.validator(request.POST)
        if errors:
            for error in errors:
                messages.error(request, errors[error])
            return redirect('/')    
        
        user_pw=request.POST['pw']
        hash_pw = bcrypt.hashpw(user_pw.encode(), bcrypt.gensalt()).decode()
        print(hash_pw)
        new_user = User.objects.create(
            first_name=request.POST['f_n'],
            last_name=request.POST['l_n'],
            email=request.POST['email'],
            password=hash_pw
            )
        print(new_user)
        request.session['user_id'] = new_user.id
        request.session['user_name'] = f"{new_user.first_name} {new_user.last_name}"
        return redirect('/success')
    return redirect('/')

def login(request):
    user = User.objects.filter(email=request.POST['email'])
    if len(user) != 0:
        logged_user = user[0]
        if bcrypt.checkpw(request.POST['pw'].encode(), logged_user.password.encode()):
            request.session['user_id'] = logged_user.id
            request.session['user_name'] = f"{logged_user.first_name} {logged_user.last_name}"

            return redirect('/success')
    return redirect('/')

def logout(request):
    request.session.clear()
    return redirect('/')

    
    