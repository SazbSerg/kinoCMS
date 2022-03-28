package com.example.miniProject.repo;

import com.example.miniProject.models.SmsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SMSRepository extends JpaRepository<SmsModel, Long> {
}
