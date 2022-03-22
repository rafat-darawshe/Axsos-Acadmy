package com.rafat.Log.Registr.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafat.Log.Registr.Repository.BookRepository;
import com.rafat.Log.Registr.models.Book;
import com.rafat.Log.Registr.models.User;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;

	@Autowired
	private UserService userServ;

	public List<Book> allBooks() {
		return bookRepo.findAll();
	}

	public Book findBookById(Long id) {
		Optional<Book> b = bookRepo.findById(id);
		if (b.isPresent()) {
			Book book = b.get();
			return book;
		} else {
			return null;
		}
	}

	public void createBook(Book b, Long loggedUserId) {
		User loggedUser = userServ.findUserById(loggedUserId);
		b.setUser(loggedUser);
		bookRepo.save(b);
	}

	public void updateBook(Book updatedBook, Long bookId) {

		Book book = this.findBookById(bookId);
		book.setTitle(updatedBook.getTitle());
		book.setAuthor(updatedBook.getAuthor());
		book.setThoughts(updatedBook.getThoughts());
		bookRepo.save(book);
	}

}