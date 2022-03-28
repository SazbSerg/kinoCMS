package com.example.miniProject.models;

import javax.persistence.*;

@Entity
public class MainTopBannersOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "rotation_speed", nullable = false)
    private String  rotationSpeed;

    @Column(name = "status", nullable = false)
    private boolean status;

    public String getRotationSpeed() {
        return rotationSpeed;
    }

    public void setRotationSpeed(String rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }

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

    public MainTopBannersOptions() {
    }

    public MainTopBannersOptions(String rotationSpeed, boolean status) {
        this.rotationSpeed = rotationSpeed;
        this.status = status;
    }
}
