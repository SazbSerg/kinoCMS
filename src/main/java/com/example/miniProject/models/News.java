package com.example.miniProject.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "publuc_date", nullable = false)
    private Date publicDate;

    @Column(name = "language", nullable = false)
    private boolean language;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "main_image", nullable = false)
    private  String mainImage;

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

    @Column(name = "video_link", nullable = false)
    private String videoLink;

    @Column(name = "seo_url", nullable = false)
    private String seoUrl;

    @Column(name = "seo_title", nullable = false)
    private String seoTitle;

    @Column(name = "seo_keywords", nullable = false)
    private String seoKeywords;

    @Column(name = "seo_description", nullable = false)
    private String seoDescription;

    public News() {
    }

    public News(String title, String description, Date publicDate,
                boolean language, boolean status,
                String mainImage, String image1, String image2, String image3, String image4, String image5,
                String videoLink, String seoUrl, String seoTitle, String seoKeywords, String seoDescription) {
        this.title = title;
        this.description = description;
        this.publicDate = publicDate;
        this.language = language;
        this.status = status;
        this.mainImage = mainImage;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.image5 = image5;
        this.videoLink = videoLink;
        this.seoUrl = seoUrl;
        this.seoTitle = seoTitle;
        this.seoKeywords = seoKeywords;
        this.seoDescription = seoDescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
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

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
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

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
