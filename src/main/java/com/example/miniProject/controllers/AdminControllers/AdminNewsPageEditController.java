package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.News;
import com.example.miniProject.repo.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AdminNewsPageEditController {
    @Autowired
    private NewsRepository newsRepository;

    @GetMapping("/admin-news-page-edit/{id}")
    public String newsEdit(@PathVariable(value = "id") long id, Model model) {
        if (!newsRepository.existsById(id)) {
            return "redirect: /admin-news";}
        Optional<News> news = newsRepository.findById(id);
        ArrayList<News> res = new ArrayList<>();
        news.ifPresent(res :: add);
        model.addAttribute("news", res);
        return "/Admin/News/admin-news-page-edit";
    }

    @PostMapping("/admin-news-page-edit/{id}")
    public String newsPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String description,
                                 @RequestParam Date publicDate,
                                 @RequestParam boolean language, @RequestParam boolean status,
                                 @RequestParam String mainImage, @RequestParam String image1, @RequestParam String image2,
                                 @RequestParam String image3, @RequestParam String image4, @RequestParam String image5,
                                 @RequestParam String videoLink, @RequestParam String seoUrl, @RequestParam String seoTitle,
                                 @RequestParam String seoKeywords, @RequestParam String seoDescription){
        News news = newsRepository.findById(id).orElseThrow();
        news.setTitle(title);
        news.setDescription(description);
        news.setPublicDate(publicDate);
        news.setLanguage(language);
        news.setStatus(status);
        news.setMainImage(mainImage);
        news.setImage1(image1);
        news.setImage2(image2);
        news.setImage3(image3);
        news.setImage4(image4);
        news.setImage5(image5);
        news.setVideoLink(videoLink);
        news.setSeoUrl(seoUrl);
        news.setSeoTitle(seoTitle);
        news.setSeoKeywords(seoKeywords);
        news.setSeoDescription(seoDescription);
        newsRepository.save(news);
        return "redirect:/admin-news";
    }
}
