package com.example.miniProject.repo;

import com.example.miniProject.models.ContactsListAdditionalData;
import org.springframework.data.repository.CrudRepository;

public interface ContactsListAdditionalRepository extends CrudRepository <ContactsListAdditionalData, Long> {
}
