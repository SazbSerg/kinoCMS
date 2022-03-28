package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.News;
import com.example.miniProject.repo.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Date;

@Controller
public class AdminNewsPageController {

    @Autowired
    private NewsRepository newsRepository;

    @GetMapping("/admin-news-page")
    public String getNews() {
        return "/Admin/News/admin-news-page";
    }

    @PostMapping("/admin-news-page")
    public String postNews(@RequestParam String title, @RequestParam String description, @RequestParam Date publicDate,
                              @RequestParam boolean language, @RequestParam boolean status,
                              @RequestParam String mainImage, @RequestParam String image1, @RequestParam String image2,
                              @RequestParam String image3, @RequestParam String image4, @RequestParam String image5,
                              @RequestParam String videoLink, @RequestParam String seoUrl, @RequestParam String seoTitle,
                              @RequestParam String seoKeywords, @RequestParam String seoDescription){
        News news = new News(title, description, publicDate, language, status, mainImage, image1, image2, image3, image4, image5,
                videoLink, seoUrl, seoTitle, seoKeywords, seoDescription);
        newsRepository.save(news);
        return "redirect:/admin-news";
    }
}
