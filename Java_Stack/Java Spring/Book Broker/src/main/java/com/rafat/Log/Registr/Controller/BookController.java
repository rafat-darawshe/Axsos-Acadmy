package com.rafat.Log.Registr.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.rafat.Log.Registr.Service.BookService;
import com.rafat.Log.Registr.Service.UserService;
import com.rafat.Log.Registr.models.Book;
import com.rafat.Log.Registr.models.User;

@Controller
public class BookController {
	@Autowired
	private BookService bookServ;
	@Autowired
	private UserService userServ;

	@GetMapping("/books")
	public String home(Model model, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			User loggedUser = userServ.findUserById((long) session.getAttribute("user_id"));
			List<Book> books = bookServ.allBooks();
			model.addAttribute("books", books);
			model.addAttribute("loggedUser", loggedUser);
			return "/user/dashboard.jsp";
		}

		return "redirect:/home";
	}

	@GetMapping("/bookmarket")
	public String bookmarket(Model model, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			User loggedUser = userServ.findUserById((long) session.getAttribute("user_id"));
			List<Book> availableBooks = bookServ.availableBooks();
			List<Book> borrowdBooksByLoggedUser = bookServ.borrowedBooks((long) session.getAttribute("user_id"));
			model.addAttribute("availabeBooks", availableBooks);
			model.addAttribute("borrowedBooks", borrowdBooksByLoggedUser);
			model.addAttribute("loggedUser", loggedUser);
			return "/book/bookmarket.jsp";
		}

		return "redirect:/home";
	}

	@PostMapping("/books/{id}")
	public String borrow(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("user_id") != null) {

			bookServ.borrowBook(id, (long) session.getAttribute("user_id"));

			return "redirect:/bookmarket";

		} else {
			return "redirect:/home";
		}

	}

	@PutMapping("/books/{id}/return")
	public String returnBook(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("user_id") != null) {

			bookServ.returnBorrowedBook(id);

			return "redirect:/bookmarket";

		} else {
			return "redirect:/home";
		}

	}

	@DeleteMapping("/books/{id}")
	public String delete(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("user_id") != null) {

			bookServ.deleteBook(id);
			return "redirect:/bookmarket";

		} else {
			return "redirect:/home";
		}

	}

	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("newBook") Book newBook, HttpSession session) {
		if (session.getAttribute("user_id") != null) {

			return "/book/add.jsp";
		}

		return "redirect:/home";
	}

	@PostMapping("/books")
	public String register(@Valid @ModelAttribute("newBook") Book newBook, BindingResult result, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			if (result.hasErrors()) {

				return "/book/add.jsp";
			} else {

				bookServ.createBook(newBook, (long) session.getAttribute("user_id"));

				return "redirect:/books";
			}
		} else {
			return "redirect:/home";
		}

	}

	@GetMapping("/books/{id}")
	public String home(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("user_id") != null) {

			Book book = bookServ.findBookById(id);
			model.addAttribute("book", book);
			model.addAttribute("loggedUserId", session.getAttribute("user_id"));
			return "/book/info.jsp";
		}

		return "redirect:/home";
	}

	@GetMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			Book book = bookServ.findBookById(id);
			model.addAttribute("book", book);
			return "/book/edit.jsp";
		}

		return "redirect:/home";
	}

	@PutMapping("/books/{id}")
	public String editBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result,
			HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			if (result.hasErrors()) {

				return "/book/edit.jsp";
			} else {
				bookServ.updateBook(book, id);
				return "redirect:/books";
			}
		} else {
			return "redirect:/home";
		}

	}


}