package com.example.miniProject.models;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    @Column(name = "main_screen", nullable = false, length = 300)
    private String mainScreen;

    @Column(name = "screen1", nullable = false, length = 300)
    private String screen1;

    @Column(name = "screen2", nullable = false, length = 300)
    private String screen2;

    @Column(name = "screen3", nullable = false, length = 300)
    private String screen3;

    @Column(name = "screen4", nullable = false, length = 300)
    private String screen4;

    @Column(name = "screen5", nullable = false, length = 300)
    private String screen5;

    @Column(name = "trailer_url", nullable = false, length = 300)
    private String trailerUrl;

    @Column(name = "movie_type_2D", nullable = false, length = 300)
    private boolean movieType2D;

    @Column(name = "movie_type_3D", nullable = false, length = 300)
    private boolean movieType3D;

    @Column(name = "movie_type_imax", nullable = false, length = 300)
    private boolean movieTypeImax;

    @Column(name = "seo_url", nullable = false, length = 300)
    private String seoUrl;

    @Column(name = "seo_title", nullable = false, length = 300)
    private String seoTitle;

    @Column(name = "seo_keywords", nullable = false, length = 300)
    private String seoKeywords;

    @Column(name = "seo_description", nullable = false, length = 300)
    private String seoDescription;

    @Column(name = "current_or_soon", nullable = false, length = 300)
    private boolean currentOrSoon;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", nullable = true, length = 1600)
    private String description;

    @Column(name = "language")
    private boolean language;

    public boolean isLanguage() {
        return language;
    }

    public void setLanguage(boolean language) {
        this.language = language;
    }

    public void setMovieType2D(boolean movieType2D) {
        this.movieType2D = movieType2D;
    }

    public boolean getMovieType2D() {
        return movieType2D;
    }

    public boolean isMovieType2D() {
        return movieType2D;
    }

    public boolean isMovieType3D() {
        return movieType3D;
    }

    public void setMovieType3D(boolean movieType3D) {
        this.movieType3D = movieType3D;
    }

    public boolean isMovieTypeImax() {
        return movieTypeImax;
    }

    public void setMovieTypeImax(boolean movieTypeImax) {
        this.movieTypeImax = movieTypeImax;
    }

    public boolean isCurrentOrSoon() {
        return currentOrSoon;
    }

    public void setCurrentOrSoon(boolean currentOrSoon) {
        this.currentOrSoon = currentOrSoon;
    }

    public Boolean getMovieType3D() {
        return movieType3D;
    }

    public void setMovieType3D(Boolean movieType3D) {
        this.movieType3D = movieType3D;
    }

    public Boolean getMovieTypeImax() {
        return movieTypeImax;
    }

    public void setMovieTypeImax(Boolean movieTypeImax) {
        this.movieTypeImax = movieTypeImax;
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

    public String getScreen1() {
        return screen1;
    }

    public void setScreen1(String screen1) {
        this.screen1 = screen1;
    }

    public String getScreen2() {
        return screen2;
    }

    public void setScreen2(String screen2) {
        this.screen2 = screen2;
    }

    public String getScreen3() {
        return screen3;
    }

    public void setScreen3(String screen3) {
        this.screen3 = screen3;
    }

    public String getScreen4() {
        return screen4;
    }

    public void setScreen4(String screen4) {
        this.screen4 = screen4;
    }

    public String getScreen5() {
        return screen5;
    }

    public void setScreen5(String screen5) {
        this.screen5 = screen5;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainScreen() {
        return mainScreen;
    }

    public void setMainScreen(String mainScreen) {
        this.mainScreen = mainScreen;
    }

    public String getTitle() {
        return title;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Film() {
    }



    public Film(String title, String description, String mainScreen, String screen1, String screen2, String screen3, String screen4, String screen5,
                String trailerUrl, Boolean movieType2D, Boolean movieType3D, Boolean movieTypeImax, String seoUrl, String seoTitle, String seoKeywords,
                String seoDescription, boolean currentOrSoon) {
        this.mainScreen = mainScreen;
        this.screen1 = screen1;
        this.screen2 = screen2;
        this.screen3 = screen3;
        this.screen4 = screen4;
        this.screen5 = screen5;
        this.trailerUrl = trailerUrl;
        this.movieType2D = movieType2D;
        this.movieType3D = movieType3D;
        this.movieTypeImax = movieTypeImax;
        this.seoUrl = seoUrl;
        this.seoTitle = seoTitle;
        this.seoKeywords = seoKeywords;
        this.seoDescription = seoDescription;
        this.currentOrSoon = currentOrSoon;
        this.title = title;
        this.description = description;
    }

    public Film(String mainScreen, String screen1, String screen2, String screen3, String screen4, String screen5, String trailerUrl, boolean movieType2D, boolean movieType3D, boolean movieTypeImax, String seoUrl, String seoTitle, String seoKeywords, String seoDescription, boolean currentOrSoon, String title, String description, boolean language) {
        this.mainScreen = mainScreen;
        this.screen1 = screen1;
        this.screen2 = screen2;
        this.screen3 = screen3;
        this.screen4 = screen4;
        this.screen5 = screen5;
        this.trailerUrl = trailerUrl;
        this.movieType2D = movieType2D;
        this.movieType3D = movieType3D;
        this.movieTypeImax = movieTypeImax;
        this.seoUrl = seoUrl;
        this.seoTitle = seoTitle;
        this.seoKeywords = seoKeywords;
        this.seoDescription = seoDescription;
        this.currentOrSoon = currentOrSoon;
        this.title = title;
        this.description = description;
        this.language = language;
    }
}
