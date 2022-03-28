package com.example.miniProject.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class MainPage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "phone_number_1", nullable = false)
    private String phoneNumber1;

    @Column(name = "phone_number_2", nullable = false)
    private String phoneNumber2;

    @Column(name = "language", nullable = false)
    private boolean language;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "seo_text", nullable = false, length = 2000)
    private String seoText;

    @Column(name = "seo_url", nullable = false)
    private String seoUrl;

    @Column(name = "seo_title", nullable = false)
    private String seoTitle;

    @Column(name = "seo_keywords", nullable = false)
    private String seoKeywords;

    @Column(name = "seo_description", nullable = false)
    private String seoDescription;

    @Column(name = "creating_date", nullable = false, length = 20)
    private String creatingDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public boolean isLanguage() {
        return language;
    }

    public void setLanguage(boolean language) {
        this.language = language;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getSeoText() {
        return seoText;
    }

    public void setSeoText(String seoText) {
        this.seoText = seoText;
    }

    public String getSeoUrl() {
        return seoUrl;
    }

    public void setSeoUrl(String seoUrl) {
        this.seoUrl = seoUrl;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getSeoKeywords() {
        return seoKeywords;
    }

    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    public String getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(String publicDate) {
        this.creatingDate = publicDate;
    }

    public MainPage() {
    }

    public MainPage(String name, String phoneNumber1, String phoneNumber2, boolean language,
                    boolean status, String seoText, String seoUrl, String seoTitle, String seoKeywords,
                    String seoDescription, String creatingDate) {
        this.name = name;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
        this.language = language;
        this.status = status;
        this.seoText = seoText;
        this.seoUrl = seoUrl;
        this.seoTitle = seoTitle;
        this.seoKeywords = seoKeywords;
        this.seoDescription = seoDescription;
        this.creatingDate = creatingDate;
    }
}
