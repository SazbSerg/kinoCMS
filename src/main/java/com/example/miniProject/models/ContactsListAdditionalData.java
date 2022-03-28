package com.example.miniProject.models;


import javax.persistence.*;

@Entity
public class ContactsListAdditionalData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "status", nullable = true)
    private boolean status;

    @Column(name = "publuc_date", nullable = true)
    private String publicDate;

    @Column(name = "seo_url", nullable = false)
    private String seoUrl;

    @Column(name = "seo_title", nullable = false)
    private String seoTitle;

    @Column(name = "seo_keywords", nullable = false)
    private String seoKeywords;

    @Column(name = "seo_description", nullable = false)
    private String seoDescription;

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

    public String getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate;
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

    public ContactsListAdditionalData() {
    }

    public ContactsListAdditionalData(String name, String publicDate, String seoUrl, String seoTitle, String seoKeywords, String seoDescription) {
        this.name = name;
        this.publicDate = publicDate;
        this.seoUrl = seoUrl;
        this.seoTitle = seoTitle;
        this.seoKeywords = seoKeywords;
        this.seoDescription = seoDescription;
    }
}
