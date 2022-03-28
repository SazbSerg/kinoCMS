package com.example.miniProject.controllers.AdminControllers;

import com.example.miniProject.models.CafeBar;
import com.example.miniProject.models.VipHall;
import com.example.miniProject.repo.VipHallRepositiry;
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
public class AdminVipHallEditController {

    @Autowired
    VipHallRepositiry vipHallRepositiry;

    @GetMapping("/admin-vip-hall-edit/{id}")
    public String getVipHallEdit(@PathVariable(value = "id") long id, Model model) {
        if (!vipHallRepositiry.existsById(id)) {
            return "redirect: /admin-pages";}
        Optional<VipHall> vipHall = vipHallRepositiry.findById(id);
        ArrayList<VipHall> res = new ArrayList<>();
        vipHall.ifPresent(res :: add);
        model.addAttribute("vipHalls", res);
        return "/Admin/Pages/admin-vip-hall-edit";
    }

    @PostMapping("/admin-vip-hall-edit/{id}")
    public String postVipHallEdit(@PathVariable(value = "id") long id,
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
        VipHall vipHall = vipHallRepositiry.findById(id).orElseThrow();
        vipHall.setTitle(title);
        vipHall.setDescription(description);
        vipHall.setPublicDate(publicDate);
        vipHall.setLanguage(language);
        vipHall.setStatus(status);
        vipHall.setMainImage(mainImage);
        vipHall.setImage1(image1);
        vipHall.setImage2(image2);
        vipHall.setImage3(image3);
        vipHall.setImage4(image4);
        vipHall.setImage5(image5);
        vipHall.setSeoUrl(seoUrl);
        vipHall.setSeoTitle(seoTitle);
        vipHall.setSeoKeywords(seoKeywords);
        vipHall.setSeoDescription(seoDescription);

        vipHallRepositiry.save(vipHall);
        return "redirect:/admin-pages";
    }
}
