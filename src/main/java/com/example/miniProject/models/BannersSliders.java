package com.example.miniProject.models;

import javax.persistence.*;

@Entity
public class BannersSliders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "banner_image", nullable = true, length = 100)
    private String bannerImage;

    @Column(name = "banner_url", nullable = true, length = 100)
    private String bannerUrl;

    @Column(name = "banner_text", nullable = true, length = 100)
    private String bannerText;

    public BannersSliders() {
    }

    public BannersSliders(String bannerImage, String bannerUrl, String bannerText) {
        this.bannerImage = bannerImage;
        this.bannerUrl = bannerUrl;
        this.bannerText = bannerText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getBannerText() {
        return bannerText;
    }

    public void setBannerText(String bannerText) {
        this.bannerText = bannerText;
    }
}
