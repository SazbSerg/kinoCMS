package com.example.miniProject.models.TestPackage;

import javax.persistence.*;
import java.util.List;

@Entity
public class ParentClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "parent_field", nullable = false, length = 300)
    private String parentField;

    @Override
    public String toString() {
        return "ParentClass{" +
               "id=" + id +
               ", parentField='" + parentField + '\'' +
               ", children=" + children +
               '}';
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_class_id")
    private List<ChildClass> children;

    public String getParentField() {
        return parentField;
    }

    public void setParentField(String parentField) {
        this.parentField = parentField;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ChildClass> getChildren() {
        return children;
    }

    public void setChildren(List<ChildClass> children) {
        this.children = children;
    }

    public ParentClass() {
    }

    public ParentClass(String parentField) {
        this.parentField = parentField;
    }
}
