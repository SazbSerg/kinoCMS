package com.example.miniProject.models;

import javax.persistence.*;

@Entity
public class BackgroundBanner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "background_banner", nullable = true)
    private String  backgroundBanner;

    @Column(name = "status_background_banner", nullable = false)
    private boolean statusBackgroundBanner;

    public String getBackgroundBanner() {
        return backgroundBanner;
    }

    public void setBackgroundBanner(String backgroundBanner) {
        this.backgroundBanner = backgroundBanner;
    }

    public boolean isStatusBackgroundBanner() {
        return statusBackgroundBanner;
    }

    public void setStatusBackgroundBanner(boolean statusBackgroundBanner) {
        this.statusBackgroundBanner = statusBackgroundBanner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BackgroundBanner() {
    }

    public BackgroundBanner(String backgroundBanner, boolean statusBackgroundBanner) {
        this.backgroundBanner = backgroundBanner;
        this.statusBackgroundBanner = statusBackgroundBanner;
    }

    public BackgroundBanner(boolean statusBackgroundBanner) {
        this.statusBackgroundBanner = statusBackgroundBanner;
    }

    public BackgroundBanner(Long id, boolean statusBackgroundBanner) {
        this.id = id;
        this.statusBackgroundBanner = statusBackgroundBanner;
    }
}
