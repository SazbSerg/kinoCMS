package com.example.miniProject.models;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class TestAjax {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "par1", nullable = false, length = 50)
    private String par1;

    @Column(name = "par2", nullable = false, length = 50)
    private String par2;

    public String getPar1() {
        return par1;
    }

    public void setPar1(String par1) {
        this.par1 = par1;
    }

    public String getPar2() {
        return par2;
    }

    public void setPar2(String par2) {
        this.par2 = par2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TestAjax() {
    }

    @JsonCreator
    public TestAjax(@JsonProperty("par1") String par1, @JsonProperty("par2") String par2) {
        this.par1 = par1;
        this.par2 = par2;
    }
}
