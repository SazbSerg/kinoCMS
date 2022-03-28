package com.example.miniProject.repo;

import com.example.miniProject.models.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository <Stock, Long> {
}
