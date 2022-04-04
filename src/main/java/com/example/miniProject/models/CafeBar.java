package com.example.miniProject.models;


import javax.persistence.*;

@Entity
public class CafeBar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "publuc_date")
    private String publicDate;

    @Column(name = "language")
    private boolean language;

    @Column(name = "status")
    private boolean status;

    @Column(name = "main_image")
    private  String mainImage;

    @Column(name = "image_1")
    private String image1;

    @Column(name = "image_2")
    private String image2;

    @Column(name = "image_3")
    private String image3;

    @Column(name = "image_4")
    private String image4;

    @Column(name = "image_5")
    private String image5;

    @Column(name = "seo_url")
    private String seoUrl;

    @Column(name = "seo_title")
    private String seoTitle;

    @Column(name = "seo_keywords")
    private String seoKeywords;

    @Column(name = "seo_description")
    private String seoDescription;

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

    public String getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(String publicDate) {
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

    public CafeBar() {
    }

    public CafeBar(String title, String description, String publicDate, boolean language, boolean status, String image1, String image2, String image3, String image4, String image5, String seoUrl, String seoTitle, String seoKeywords, String seoDescription) {
        this.title = title;
        this.description = description;
        this.publicDate = publicDate;
        this.language = language;
        this.status = status;
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

    public CafeBar(String title, String description, String publicDate, boolean language, boolean status,
                   String image1, String image2, String image3, String image4, String image5,
                   String seoUrl, String seoTitle, String seoKeywords, String seoDescription, String mainImage) {
              this.title = title;
              this.description = description;
              this.publicDate = publicDate;
              this.language = language;
              this.status = status;
              this.image1 = image1;
              this.image2 = image2;
              this.image3 = image3;
              this.image4 = image4;
              this.image5 = image5;
              this.seoUrl = seoUrl;
              this.seoTitle = seoTitle;
              this.seoKeywords = seoKeywords;
              this.seoDescription = seoDescription;
              this.mainImage = mainImage;
          }

    public CafeBar(String mainImage) {
        this.mainImage = mainImage;
    }
}
