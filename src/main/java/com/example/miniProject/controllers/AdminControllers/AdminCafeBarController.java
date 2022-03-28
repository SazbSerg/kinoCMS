package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.CafeBar;
import com.example.miniProject.repo.CafeBarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminCafeBarController {
    @Autowired
    CafeBarRepository cafeBarRepository;

    @GetMapping("/admin-cafe-bar")
    public String getCafeBar() {
        return "/Admin/Pages/admin-cafe-bar";
    }

    @PostMapping("/admin-cafe-bar")
    public String postCafeBar(@RequestParam String title, @RequestParam String description, @RequestParam String publicDate,
                              @RequestParam boolean language, @RequestParam boolean status,
                              @RequestParam String mainImage, @RequestParam String image1, @RequestParam String image2,
                              @RequestParam String image3, @RequestParam String image4, @RequestParam String image5,
                              @RequestParam String seoUrl, @RequestParam String seoTitle,
                              @RequestParam String seoKeywords, @RequestParam String seoDescription){
        CafeBar cafeBar = new CafeBar(title, description, publicDate, language, status, mainImage, image1, image2, image3, image4, image5,
                seoUrl, seoTitle, seoKeywords, seoDescription);
        cafeBarRepository.save(cafeBar);
        return "redirect:/admin-pages";
    }
}
