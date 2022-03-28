package com.example.miniProject.models.TestPackage;

import javax.persistence.*;
import java.util.List;

@Entity
public class ChildClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "child_field", nullable = false, length = 300)
    private String childField;

    public ChildClass() {
    }

    public ChildClass(String childField) {
        this.childField = childField;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChildField() {
        return childField;
    }

    public void setChildField(String childField) {
        this.childField = childField;
    }
}
