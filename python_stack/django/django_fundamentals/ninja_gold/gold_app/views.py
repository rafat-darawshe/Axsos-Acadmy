from django.shortcuts import render, redirect
import random
from time import gmtime, strftime


def show(request):
    return render(request , 'gold.html')

def process(request):
    request.session['total']
    request.session['time']=strftime("%Y-%m-%d %H:%M %p", gmtime())

    if request.POST['which_form']=='farm':
        request.session['farm_a']='farm_a'
        request.session['farm_earn']=random.randint(10,20)
        request.session['total']+=request.session['farm_earn']

    elif request.POST['which_form']=='cave':
        request.session['cave_a']='cave_a'
        request.session['cave_earn']=random.randint(5,10)
        request.session['total']+=request.session['cave_earn']

    elif request.POST['which_form']=='house':
        request.session['house_a']='house_a'
        request.session['house_earn']=random.randint(2,5)
        request.session['total']+=request.session['house_earn']

    elif request.POST['which_form']=='casino':
        request.session['casino_a']='casino_a'
        request.session['casino_earn']=random.randint(-50,50)
        request.session['total']+=request.session['casino_earn']
    return redirect('/')