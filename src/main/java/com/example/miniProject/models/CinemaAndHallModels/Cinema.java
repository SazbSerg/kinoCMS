package com.example.miniProject.models.CinemaAndHallModels;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "hall_id")
    private List<Hall> halls;

    @Column(name = "cinema_title", nullable = false)
    private String cinemaTitle;

    @Column(name = "language", nullable = false)
    private boolean language;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "conditions", nullable = false)
    private String conditions;

    @Column(name = "logo", nullable = false)
    private String hallPlan;

    @Column(name = "top_banner", nullable = false)
    private  String topBanner;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Hall> getHalls() {
        return halls;
    }

    public void setHalls(List<Hall> halls) {
        this.halls = halls;
    }

    public String getCinemaTitle() {
        return cinemaTitle;
    }

    public void setCinemaTitle(String cinemaTitle) {
        this.cinemaTitle = cinemaTitle;
    }

    public boolean isLanguage() {
        return language;
    }

    public void setLanguage(boolean language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getHallPlan() {
        return hallPlan;
    }

    public void setHallPlan(String hallPlan) {
        this.hallPlan = hallPlan;
    }

    public String getTopBanner() {
        return topBanner;
    }

    public void setTopBanner(String topBanner) {
        this.topBanner = topBanner;
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

    public Cinema() {
    }

    public Cinema(String cinemaTitle, boolean language, String description, String conditions, String hallPlan,
                  String topBanner, String image1, String image2, String image3, String image4, String image5,
                  String seoUrl, String seoTitle, String seoKeywords, String seoDescription) {
        this.cinemaTitle = cinemaTitle;
        this.language = language;
        this.description = description;
        this.conditions = conditions;
        this.hallPlan = hallPlan;
        this.topBanner = topBanner;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.image5 = image5;
        this.seoUrl = seoUrl;
        this.seoTitle = seoTitle;
        this.seoKeywords = seoKeywords;
        this.seoDescription = seoDescription;
    }
}
