package com.example.miniProject.repo.TestRepos;

import com.example.miniProject.models.TestPackage.ParentClass;
import org.springframework.data.repository.CrudRepository;

public interface ParentClassRepo extends CrudRepository<ParentClass, Long> {
}
