package com.example.miniProject.controllers.AdminControllers;

import com.example.miniProject.models.Ad;
import com.example.miniProject.models.VipHall;
import com.example.miniProject.repo.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AdminAdEditController {
    @Autowired
    AdRepository adRepository;

    @GetMapping("/admin-ad-edit/{id}")
    public String getAdEdit(@PathVariable(value = "id") long id, Model model) {
        if (!adRepository.existsById(id)) {
            return "redirect: /admin-pages";}
        Optional<Ad> ad = adRepository.findById(id);
        ArrayList<Ad> res = new ArrayList<>();
        ad.ifPresent(res :: add);
        model.addAttribute("ads", res);
        return "/Admin/Pages/admin-ad-edit";
    }

    @PostMapping("/admin-ad-edit/{id}")
    public String postAdEdit(@PathVariable(value = "id") long id,
                             @RequestParam String title,
                             @RequestParam String description,
                             @RequestParam String publicDate,
                             @RequestParam boolean language,
                             @RequestParam boolean status,
                             @RequestParam String mainImage,
                             @RequestParam String image1,
                             @RequestParam String image2,
                             @RequestParam String image3,
                             @RequestParam String image4,
                             @RequestParam String image5,
                             @RequestParam String seoUrl,
                             @RequestParam String seoTitle,
                             @RequestParam String seoKeywords,
                             @RequestParam String seoDescription){
        Ad ad = adRepository.findById(id).orElseThrow();
        ad.setTitle(title);
        ad.setDescription(description);
        ad.setPublicDate(publicDate);
        ad.setLanguage(language);
        ad.setStatus(status);
        ad.setMainImage(mainImage);
        ad.setImage1(image1);
        ad.setImage2(image2);
        ad.setImage3(image3);
        ad.setImage4(image4);
        ad.setImage5(image5);
        ad.setSeoUrl(seoUrl);
        ad.setSeoTitle(seoTitle);
        ad.setSeoKeywords(seoKeywords);
        ad.setSeoDescription(seoDescription);
        adRepository.save(ad);
        return "redirect:/admin-pages";
    }
}
