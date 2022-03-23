package com.rafat.Log.Registr.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rafat.Log.Registr.models.Book;
import com.rafat.Log.Registr.models.User;

//.. imports .. //

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findAll();

	List<Book> findByBorrowerNull();

	List<Book> findByBorrower(User borrower);


}