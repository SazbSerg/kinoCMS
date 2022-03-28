package com.example.miniProject.repo;

import com.example.miniProject.models.Contacts;
import org.springframework.data.repository.CrudRepository;

public interface ContactsRepository extends CrudRepository <Contacts, Long> {
}
