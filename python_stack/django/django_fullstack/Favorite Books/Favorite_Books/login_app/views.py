from distutils import errors
from django.shortcuts import render, HttpResponse, redirect
from .models import User
from book_app.models import *
from django.contrib import messages
import bcrypt

def index(request):
    
    return render(request, 'login.html')


def register(request):
    if request.method == 'POST':
        errors = User.objects.register_validator(request.POST)
        request.session['which_form'] = request.POST['which_form']

        if errors:
            for error in errors:
                messages.error(request, errors[error])
            return redirect('/')    
        
        user_pw=request.POST['pw']
        hash_pw = bcrypt.hashpw(user_pw.encode(), bcrypt.gensalt()).decode()
        print(hash_pw)
        User.objects.create(
            first_name=request.POST['f_n'],
            last_name=request.POST['l_n'],
            email=request.POST['email'],
            password=hash_pw,
            birthday=request.POST['birthday'],
            )
        user = User.objects.filter(email=request.POST['email'])
        if user:
            logged_user = user[0]
        request.session['userid'] = logged_user.id
        return redirect('/books')
    return redirect('/')

def login(request):
    user = User.objects.filter(email=request.POST['email'])
    request.session['which_form'] = request.POST['which_form']
    errors = User.objects.login_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/')
    if len(user) != 0:
        logged_user = user[0]
        if bcrypt.checkpw(request.POST['pw'].encode(), logged_user.password.encode()):
            request.session['userid'] = logged_user.id
            return redirect('/books')
    return redirect('/')

def logout(request):
    request.session.clear()
    return redirect('/')

    
    