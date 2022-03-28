package com.example.miniProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MainNewsStocksBannersOptions {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "rotation_speed_main_news_stocks_banners", nullable = false)
    private String  rotationSpeedOfMainNewsStocksBanners;

    @Column(name = "status_main_news_stocks_banners", nullable = false)
    private boolean statusOfMainNewsStocksBanners;

    public String getRotationSpeedOfMainNewsStocksBanners() {
        return rotationSpeedOfMainNewsStocksBanners;
    }

    public void setRotationSpeedOfMainNewsStocksBanners(String rotationSpeedOfMainNewsStocksBanners) {
        this.rotationSpeedOfMainNewsStocksBanners = rotationSpeedOfMainNewsStocksBanners;
    }

    public boolean isStatusOfMainNewsStocksBanners() {
        return statusOfMainNewsStocksBanners;
    }

    public void setStatusOfMainNewsStocksBanners(boolean statusOfMainNewsStocksBanners) {
        this.statusOfMainNewsStocksBanners = statusOfMainNewsStocksBanners;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MainNewsStocksBannersOptions() {
    }

    public MainNewsStocksBannersOptions(String rotationSpeedOfMainNewsStocksBanners, boolean statusOfMainNewsStocksBanners) {
        this.rotationSpeedOfMainNewsStocksBanners = rotationSpeedOfMainNewsStocksBanners;
        this.statusOfMainNewsStocksBanners = statusOfMainNewsStocksBanners;
    }
}
