package com.rafat.Log.Registr.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rafat.Log.Registr.models.Project;
import com.rafat.Log.Registr.models.User;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	
    // this method retrieves all the books from the database
    List<Project> findAll();
    Optional<Project> findById(Long id);
    List<Project> findByMembersNotContaining(User user);


}