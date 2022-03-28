package com.example.miniProject.repo;

import com.example.miniProject.models.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository <Film, Long> {
}
