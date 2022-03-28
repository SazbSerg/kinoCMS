package com.example.miniProject.repo;

import com.example.miniProject.models.TestAjax;
import com.example.miniProject.models.TestModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestRepo extends CrudRepository<TestModel, Long> {

}
