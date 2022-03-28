package com.example.miniProject.repo;

import com.example.miniProject.models.News;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News, Long> {
}
