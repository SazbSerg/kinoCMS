package com.example.miniProject.models;

import javax.persistence.*;

@Entity
public class MainNewsStocksBanners {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "main_news_stock_banner_image", nullable = true, length = 100)
    private String MainNewStockBannerImage;

    @Column(name = "main_news_stock_banner_url", nullable = true, length = 100)
    private String MainNewStockBannerUrl;

    @Column(name = "main_news_stock_banner_text", nullable = true, length = 100)
    private String MainNewStockBannerText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMainNewStockBannerImage() {
        return MainNewStockBannerImage;
    }

    public void setMainNewStockBannerImage(String mainNewStockBannerImage) {
        MainNewStockBannerImage = mainNewStockBannerImage;
    }

    public String getMainNewStockBannerUrl() {
        return MainNewStockBannerUrl;
    }

    public void setMainNewStockBannerUrl(String mainNewStockBannerUrl) {
        MainNewStockBannerUrl = mainNewStockBannerUrl;
    }

    public String getMainNewStockBannerText() {
        return MainNewStockBannerText;
    }

    public void setMainNewStockBannerText(String mainNewStockBannerText) {
        MainNewStockBannerText = mainNewStockBannerText;
    }

    public MainNewsStocksBanners() {
    }

    public MainNewsStocksBanners(String mainNewStockBannerImage, String mainNewStockBannerUrl, String mainNewStockBannerText) {
        MainNewStockBannerImage = mainNewStockBannerImage;
        MainNewStockBannerUrl = mainNewStockBannerUrl;
        MainNewStockBannerText = mainNewStockBannerText;
    }
}
