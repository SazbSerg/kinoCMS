package com.example.miniProject.config;

//import com.example.miniProject.util.RedirectInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Value("${upload.path.cafe.bar}")
    private String uploadPathCafeBar;

    @Value("${upload.path.main.page.top.banners}")
    private String uploadPathMainPageTopBanners;

    @Value("${upload.path.background.banner}")
    private String uploadPathBackgroundBanner;

    @Value("${upload.path}")
    private String uploadPath;

    @Value("${upload.path.main.page.news.stocks.banners}")
    private String uploadPathMainPageNewsStocksBanners;

    @Value("${upload.path.film}")
    private String uploadPathFilm;

    @Value("${upload.path.cinema}")
    private String uploadPathCinema;

    @Value("${upload.path.hall}")
    private String uploadPathHall;

    @Value("${upload.path.news}")
    private String uploadPathNews;

    @Value("${upload.path.stocks}")
    private String uploadPathStocks;

    @Value("${upload.path.about.cinema}")
    private String uploadPathAboutCinema;

    @Value("${upload.path.vip.hall}")
    private String uploadPathVipHall;

    @Value("${upload.path.ad}")
    private String uploadPathAd;

    @Value("${upload.path.children.room}")
    private String uploadPathChildrenRoom;

    @Value("${upload.path.page.new.page}")
    private String uploadPathPageNewPage;

    @Value("${upload.path.contacts}")
    private String uploadPathContacts;

    //   @Bean
 //   public RestTemplate getRestTemplate() {
 //       return new RestTemplate();
 //   }

  //  public void addViewControllers(ViewControllerRegistry registry) {
  //      registry.addViewController("/login").setViewName("login");
  //  }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/cafe-bar-images/**")
                .addResourceLocations("file://" + uploadPathCafeBar + "/");

        registry.addResourceHandler("/main-page-top-banners-images/**")
                .addResourceLocations("file://" + uploadPathMainPageTopBanners + "/");

        registry.addResourceHandler("/background-banner-image/**")
                .addResourceLocations("file://" + uploadPathBackgroundBanner + "/");

        registry.addResourceHandler("/main-page-news-stocks-banners-images/**")
                .addResourceLocations("file://" + uploadPathMainPageNewsStocksBanners + "/");

        registry.addResourceHandler("/film-images/**")
                .addResourceLocations("file://" + uploadPathFilm + "/");

        registry.addResourceHandler("/cinema-images/**")
                .addResourceLocations("file://" + uploadPathCinema + "/");

        registry.addResourceHandler("/hall-images/**")
                .addResourceLocations("file://" + uploadPathHall + "/");

        registry.addResourceHandler("/news-images/**")
                .addResourceLocations("file://" + uploadPathNews + "/");

        registry.addResourceHandler("/stocks-images/**")
                .addResourceLocations("file://" + uploadPathStocks + "/");

        registry.addResourceHandler("/about-cinema-images/**")
                .addResourceLocations("file://" + uploadPathAboutCinema + "/");

        registry.addResourceHandler("/vip-hall-images/**")
                .addResourceLocations("file://" + uploadPathVipHall + "/");

        registry.addResourceHandler("/ad-images/**")
                .addResourceLocations("file://" + uploadPathAd + "/");

        registry.addResourceHandler("/children-room-images/**")
                .addResourceLocations("file://" + uploadPathChildrenRoom + "/");

        registry.addResourceHandler("/page-new-page-images/**")
                .addResourceLocations("file://" + uploadPathPageNewPage + "/");

        registry.addResourceHandler("/contacts-images/**")
                .addResourceLocations("file://" + uploadPathContacts + "/");

        registry.addResourceHandler("/img/**")
                .addResourceLocations("file://" + uploadPath + "/");

        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
         }

 //   @Override
 //   public void addInterceptors(InterceptorRegistry registry) {
 //       registry.addInterceptor(new RedirectInterceptor());
 //   }
}
