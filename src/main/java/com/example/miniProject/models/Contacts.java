package com.example.miniProject.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "adress", nullable = false)
    private String adress;

    @Column(name = "coordinates", nullable = false)
    private String coordinates;

    @Column(name = "logo", nullable = false)
    private  String logo;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Contacts() {
    }

    public Contacts(String title, String adress, String coordinates, String logo) {
        this.title = title;
        this.adress = adress;
        this.coordinates = coordinates;
        this.logo = logo;
    }

    public Contacts(String title, String adress, String coordinates, String logo, boolean status) {
        this.title = title;
        this.adress = adress;
        this.coordinates = coordinates;
        this.logo = logo;
        this.status = status;
    }
}
