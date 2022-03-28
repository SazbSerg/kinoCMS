package com.example.miniProject.models;

import javax.persistence.*;

@Entity
public class TestModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "test", nullable = false)
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TestModel(String test) {
        this.test = test;
    }

    public TestModel() {
    }
}
