package com.example.miniProject.models;

import javax.persistence.*;

@Entity
public class AdminContactsPageStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "status", nullable = false)
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AdminContactsPageStatus() {
    }

    public AdminContactsPageStatus(boolean status) {
        this.status = status;
    }
}
