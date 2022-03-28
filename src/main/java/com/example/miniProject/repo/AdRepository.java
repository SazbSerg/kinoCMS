package com.example.miniProject.repo;

import com.example.miniProject.models.Ad;
import org.springframework.data.repository.CrudRepository;

public interface AdRepository extends CrudRepository <Ad, Long> {
}
