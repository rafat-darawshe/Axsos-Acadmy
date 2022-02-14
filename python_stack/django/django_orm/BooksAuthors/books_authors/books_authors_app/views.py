from django.shortcuts import redirect, render
from .models import Book, Author


def books(request):
    context = {
        'books': Book.objects.all()
    }
    return render(request, 'index.html', context)



def book_details(request, id):
    context = {
        'book': Book.objects.get(id=int(id)),
        'authors': Author.objects.all()
    }
    return render(request, 'bookinfo.html', context)



def author_details(request, id):
    context = {
        'author': Author.objects.get(id=int(id)),
        'books': Book.objects.all()
    }
    return render(request, 'authorsinfo.html', context)


def authors(request):
    context = {
        'authors': Author.objects.all()
    }
    return render(request, 'authors.html', context)



def new_book(request):
    Book.objects.create(
        title=request.POST['title'], desc=request.POST['description'])

    return redirect('/')



def new_author(request):

    Author.objects.create(
        first_name=request.POST['first_name'], last_name=request.POST['last_name'], notes=request.POST['notes'])
    return redirect('/authors')



def add_author(request, id):

    book = Book.objects.get(id=int(id))
    author = Author.objects.get(id=int(request.POST['author']))
    book.authors.add(author)
    return redirect(f'/books/{id}')



def add_book(request, id):

    author = Author.objects.get(id=int(id))
    book = Book.objects.get(id=int(request.POST['book']))
    author.books.add(book)
    return redirect(f'/authors/{id}')