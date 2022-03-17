package com.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.models.Book;
import com.mvc.services.BookService;


@Controller
public class BooksApi {
	 private final BookService bookService;

	public BooksApi(BookService bookService) {
		this.bookService = bookService;

		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks();
	}

	@RequestMapping(value = "/api/books", method = RequestMethod.POST)
	public Book create(@RequestParam(value = "title") String title, @RequestParam(value = "description") String desc,
			@RequestParam(value = "language") String lang, @RequestParam(value = "pages") Integer numOfPages) {
		Book book = new Book(title, desc, lang, numOfPages);
		return bookService.createBook(book);
	}


	@RequestMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("title", book.getTitle());
		model.addAttribute("desc", book.getDescription());
		model.addAttribute("lang", book.getLanguage());
		model.addAttribute("book", book);
		return "index.jsp";
	}


	@RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT)
	public Book update(@PathVariable("id") Long id, @RequestParam(value = "title") String title,
			@RequestParam(value = "description") String desc, @RequestParam(value = "language") String lang,
			@RequestParam(value = "pages") Integer numOfPages) {

		Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
		return book;
	}

	@RequestMapping(value = "/api/books/{id}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}

}