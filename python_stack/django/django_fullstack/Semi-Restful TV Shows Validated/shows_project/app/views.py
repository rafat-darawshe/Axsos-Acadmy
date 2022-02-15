
from django.shortcuts import redirect, render
from .models import Show
from django.contrib import messages



def show(request):
    
    return redirect('/shows')


def new(request):
    return render(request, 'new.html')


def create_show(request):
    errors = Show.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)

        return redirect('/shows/new')

    else:
        show = Show.objects.create(
            title=request.POST['title'], network=request.POST['network'], date=request.POST['date'], desc=request.POST['desc'])

        return redirect(f'/shows/{show.id}')

def shows_info(request, id):
    context = {
        'show': Show.objects.get(id=int(id))
    }
  
    return render(request, 'show.html', context)


def all_show(request):
    context = {
        'shows': Show.objects.all()
    }
    print("rafat")
    return render(request, 'shows.html', context)


def edit(request, id):
    show = Show.objects.get(id=int(id))
    print(show.date)
    context = {
        'show': show,
        'date': show.date.isoformat()
    }
    return render(request, 'edit.html', context)


def update(request, id):
    errors = Show.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)

        return redirect(f'/shows/{id}/edit')
    else:
        show = Show.objects.get(id=int(id))
        show.title = request.POST['title']
        show.network = request.POST['network']
        show.desc = request.POST['desc']
        show.date = request.POST['date']
        show.save()
        return redirect(f'/shows/{id}')


def delete(request, id):
    show = Show.objects.get(id=int(id))
    show.delete()
    return redirect('/shows')