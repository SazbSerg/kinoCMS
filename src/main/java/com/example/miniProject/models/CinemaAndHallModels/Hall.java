package com.example.miniProject.models.CinemaAndHallModels;

import javax.persistence.*;

@Entity
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "hall_number", nullable = false)
    private String hallNumber;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "hall_plan", nullable = false)
    private String hallPlan;

    @Column(name = "language", nullable = false)
    private boolean language;

    @Column(name = "top_image", nullable = false)
    private  String topImage;

    @Column(name = "image_1", nullable = false)
    private String image1;

    @Column(name = "image_2", nullable = false)
    private String image2;

    @Column(name = "image_3", nullable = false)
    private String image3;

    @Column(name = "image_4", nullable = false)
    private String image4;

    @Column(name = "image_5", nullable = false)
    private String image5;

    @Column(name = "seo_url", nullable = false)
    private String seoUrl;

    @Column(name = "seo_title", nullable = false)
    private String seoTitle;

    @Column(name = "seo_keywords", nullable = false)
    private String seoKeywords;

    @Column(name = "seo_description", nullable = false)
    private String seoDescription;

    @Column(name = "local_date", nullable = false, length = 20)
    private String localDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(String hallNumber) {
        this.hallNumber = hallNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHallPlan() {
        return hallPlan;
    }

    public void setHallPlan(String hallPlan) {
        this.hallPlan = hallPlan;
    }

    public boolean isLanguage() {
        return language;
    }

    public void setLanguage(boolean language) {
        this.language = language;
    }

    public String getTopImage() {
        return topImage;
    }

    public void setTopImage(String topImage) {
        this.topImage = topImage;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
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

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public Hall() {
    }

    public Hall(String hallNumber, String description, String hallPlan, boolean language,
                String topImage, String image1, String image2, String image3, String image4, String image5,
                String seoUrl, String seoTitle, String seoKeywords, String seoDescription, String localDate) {
        this.hallNumber = hallNumber;
        this.description = description;
        this.hallPlan = hallPlan;
        this.language = language;
        this.topImage = topImage;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.image5 = image5;
        this.seoUrl = seoUrl;
        this.seoTitle = seoTitle;
        this.seoKeywords = seoKeywords;
        this.seoDescription = seoDescription;
        this.localDate = localDate;
    }
}
