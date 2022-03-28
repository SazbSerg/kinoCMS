package com.example.miniProject.repo;

import com.example.miniProject.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long> {
}
