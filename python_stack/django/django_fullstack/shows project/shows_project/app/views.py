
from django.shortcuts import redirect, render
from .models import Show


def show(request):
    return redirect('/shows')


def new(request):
    return render(request, 'new.html')


def create_show(request):
    show = Show.objects.create(
        title=request.POST['title'], network=request.POST['network'], date=request.POST['date'], desc=request.POST['desc'])

    return redirect(f'/shows/{show.id}')


def shows_info(request, id):
    context = {
        'show': Show.objects.get(id=int(id))
    }
    return render(request, 'show.html', context)


def shows(request):
    context = {
        'shows': Show.objects.all()
    }
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