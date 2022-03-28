package com.example.miniProject.repo;

import com.example.miniProject.models.TestTable;
import org.springframework.data.repository.CrudRepository;

public interface TestTableRepository extends CrudRepository<TestTable, Long> {
}
