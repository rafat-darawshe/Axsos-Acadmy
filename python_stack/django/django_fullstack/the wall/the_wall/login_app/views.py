from distutils import errors
from django.shortcuts import render, HttpResponse, redirect
from .models import User
from wall_app.models import Message, Comment
from django.contrib import messages
import bcrypt

def index(request):
    
    return render(request, 'login.html')


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
        request.session['userid'] = new_user.id
        return redirect('/dojo_wall/wall')
    return redirect('/')

def login(request):
    user = User.objects.filter(email=request.POST['email'])
    if len(user) != 0:
        logged_user = user[0]
        if bcrypt.checkpw(request.POST['pw'].encode(), logged_user.password.encode()):
            request.session['userid'] = logged_user.id
            return redirect('/dojo_wall/wall')

    return redirect('/')

def logout(request):
    request.session.clear()
    return redirect('/')

    
    