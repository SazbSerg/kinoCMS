package com.example.miniProject.repo.TestRepos;

import com.example.miniProject.models.TestPackage.ChildClass;
import org.springframework.data.repository.CrudRepository;

public interface ChildClassRepo extends CrudRepository<ChildClass, Long> {
}
