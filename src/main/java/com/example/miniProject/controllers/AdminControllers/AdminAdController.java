package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.Ad;
import com.example.miniProject.repo.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminAdController {

    @Autowired
    AdRepository adRepository;

    @GetMapping("/admin-ad")
    public String getAd() {
        return "/Admin/Pages/admin-ad";
    }

    @PostMapping("/admin-ad")
    public String postAd(@RequestParam String title, @RequestParam String description, @RequestParam String publicDate,
                         @RequestParam boolean language, @RequestParam boolean status,
                         @RequestParam String mainImage, @RequestParam String image1, @RequestParam String image2,
                         @RequestParam String image3, @RequestParam String image4, @RequestParam String image5,
                         @RequestParam String seoUrl, @RequestParam String seoTitle,
                         @RequestParam String seoKeywords, @RequestParam String seoDescription){
        Ad ad = new Ad(title, description, publicDate, language, status, mainImage, image1, image2, image3, image4, image5,
                seoUrl, seoTitle, seoKeywords, seoDescription);
        adRepository.save(ad);
        return "redirect:/admin-pages";
    }
}
