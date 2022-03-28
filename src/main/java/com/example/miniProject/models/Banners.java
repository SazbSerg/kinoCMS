package com.example.miniProject.models;

import javax.persistence.*;

@Entity
public class Banners {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Banners(String mainTopBannerImage1, String mainTopBannerImage2, String mainTopBannerImage3, String mainTopBannerImage4, String mainTopBannerImage5) {
        this.mainTopBannerImage1 = mainTopBannerImage1;
        this.mainTopBannerImage2 = mainTopBannerImage2;
        this.mainTopBannerImage3 = mainTopBannerImage3;
        this.mainTopBannerImage4 = mainTopBannerImage4;
        this.mainTopBannerImage5 = mainTopBannerImage5;
    }

    public Banners(String mainTopBannerImage1, String mainTopBannerUrl1, String mainTopBannerText1, String mainTopBannerImage2, String mainTopBannerUrl2, String mainTopBannerText2, String mainTopBannerImage3, String mainTopBannerUrl3, String mainTopBannerText3, String mainTopBannerImage4, String mainTopBannerUrl4, String mainTopBannerText4, String mainTopBannerImage5, String mainTopBannerUrl5, String mainTopBannerText5, String mainTopBannerTimeScroll) {
        this.mainTopBannerImage1 = mainTopBannerImage1;
        this.mainTopBannerUrl1 = mainTopBannerUrl1;
        this.mainTopBannerText1 = mainTopBannerText1;
        this.mainTopBannerImage2 = mainTopBannerImage2;
        this.mainTopBannerUrl2 = mainTopBannerUrl2;
        this.mainTopBannerText2 = mainTopBannerText2;
        this.mainTopBannerImage3 = mainTopBannerImage3;
        this.mainTopBannerUrl3 = mainTopBannerUrl3;
        this.mainTopBannerText3 = mainTopBannerText3;
        this.mainTopBannerImage4 = mainTopBannerImage4;
        this.mainTopBannerUrl4 = mainTopBannerUrl4;
        this.mainTopBannerText4 = mainTopBannerText4;
        this.mainTopBannerImage5 = mainTopBannerImage5;
        this.mainTopBannerUrl5 = mainTopBannerUrl5;
        this.mainTopBannerText5 = mainTopBannerText5;
        this.mainTopBannerTimeScroll = mainTopBannerTimeScroll;
    }

    public Banners() {
    }

    @Column(name = "main_top_banner_image_1", nullable = false, length = 50)
    private String mainTopBannerImage1;

    @Column(name = "main_top_banner_url_1", nullable = true, length = 300)
    private String mainTopBannerUrl1;

    @Column(name = "main_top_banner_text_1", nullable = true, length = 500)
    private String mainTopBannerText1;

    @Column(name = "main_top_banner_image_2", nullable = false, length = 50)
    private String mainTopBannerImage2;

    @Column(name = "main_top_banner_url_2", nullable = true, length = 300)
    private String mainTopBannerUrl2;

    @Column(name = "main_top_banner_text_2", nullable = true, length = 500)
    private String mainTopBannerText2;

    @Column(name = "main_top_banner_image_3", nullable = false, length = 50)
    private String mainTopBannerImage3;

    @Column(name = "main_top_banner_url_3", nullable = true, length = 300)
    private String mainTopBannerUrl3;

    @Column(name = "main_top_banner_text_3", nullable = true, length = 500)
    private String mainTopBannerText3;

    @Column(name = "main_top_banner_image_4", nullable = false, length = 50)
    private String mainTopBannerImage4;

    @Column(name = "main_top_banner_url_4", nullable = true, length = 300)
    private String mainTopBannerUrl4;

    @Column(name = "main_top_banner_text_4", nullable = true, length = 500)
    private String mainTopBannerText4;

    @Column(name = "main_top_banner_image_5", nullable = false, length = 50)
    private String mainTopBannerImage5;

    @Column(name = "main_top_banner_url_5", nullable = true, length = 300)
    private String mainTopBannerUrl5;

    @Column(name = "main_top_banner_text_5", nullable = true, length = 500)
    private String mainTopBannerText5;

    @Column(name = "main_top_banner_time_scroll", nullable = true, length = 5)
    private String mainTopBannerTimeScroll;

    public String getMainTopBannerImage1() {
        return mainTopBannerImage1;
    }

    public void setMainTopBannerImage1(String mainTopBannerImage1) {
        this.mainTopBannerImage1 = mainTopBannerImage1;
    }

    public String getMainTopBannerUrl1() {
        return mainTopBannerUrl1;
    }

    public void setMainTopBannerUrl1(String mainTopBannerUrl1) {
        this.mainTopBannerUrl1 = mainTopBannerUrl1;
    }

    public String getMainTopBannerText1() {
        return mainTopBannerText1;
    }

    public void setMainTopBannerText1(String mainTopBannerText1) {
        this.mainTopBannerText1 = mainTopBannerText1;
    }

    public String getMainTopBannerImage2() {
        return mainTopBannerImage2;
    }

    public void setMainTopBannerImage2(String mainTopBannerImage2) {
        this.mainTopBannerImage2 = mainTopBannerImage2;
    }

    public String getMainTopBannerUrl2() {
        return mainTopBannerUrl2;
    }

    public void setMainTopBannerUrl2(String mainTopBannerUrl2) {
        this.mainTopBannerUrl2 = mainTopBannerUrl2;
    }

    public String getMainTopBannerText2() {
        return mainTopBannerText2;
    }

    public void setMainTopBannerText2(String mainTopBannerText2) {
        this.mainTopBannerText2 = mainTopBannerText2;
    }

    public String getMainTopBannerImage3() {
        return mainTopBannerImage3;
    }

    public void setMainTopBannerImage3(String mainTopBannerImage3) {
        this.mainTopBannerImage3 = mainTopBannerImage3;
    }

    public String getMainTopBannerUrl3() {
        return mainTopBannerUrl3;
    }

    public void setMainTopBannerUrl3(String mainTopBannerUrl3) {
        this.mainTopBannerUrl3 = mainTopBannerUrl3;
    }

    public String getMainTopBannerText3() {
        return mainTopBannerText3;
    }

    public void setMainTopBannerText3(String mainTopBannerText3) {
        this.mainTopBannerText3 = mainTopBannerText3;
    }

    public String getMainTopBannerImage4() {
        return mainTopBannerImage4;
    }

    public void setMainTopBannerImage4(String mainTopBannerImage4) {
        this.mainTopBannerImage4 = mainTopBannerImage4;
    }

    public String getMainTopBannerUrl4() {
        return mainTopBannerUrl4;
    }

    public void setMainTopBannerUrl4(String mainTopBannerUrl4) {
        this.mainTopBannerUrl4 = mainTopBannerUrl4;
    }

    public String getMainTopBannerText4() {
        return mainTopBannerText4;
    }

    public void setMainTopBannerText4(String mainTopBannerText4) {
        this.mainTopBannerText4 = mainTopBannerText4;
    }

    public String getMainTopBannerImage5() {
        return mainTopBannerImage5;
    }

    public void setMainTopBannerImage5(String mainTopBannerImage5) {
        this.mainTopBannerImage5 = mainTopBannerImage5;
    }

    public String getMainTopBannerUrl5() {
        return mainTopBannerUrl5;
    }

    public void setMainTopBannerUrl5(String mainTopBannerUrl5) {
        this.mainTopBannerUrl5 = mainTopBannerUrl5;
    }

    public String getMainTopBannerText5() {
        return mainTopBannerText5;
    }

    public void setMainTopBannerText5(String mainTopBannerText5) {
        this.mainTopBannerText5 = mainTopBannerText5;
    }

    public String getMainTopBannerTimeScroll() {
        return mainTopBannerTimeScroll;
    }

    public void setMainTopBannerTimeScroll(String mainTopBannerTimeScroll) {
        this.mainTopBannerTimeScroll = mainTopBannerTimeScroll;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}

