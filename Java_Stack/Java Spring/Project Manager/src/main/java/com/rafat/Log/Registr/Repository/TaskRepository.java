package com.rafat.Log.Registr.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rafat.Log.Registr.models.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findAll();
    Optional<Task> findById(Long id);

}
