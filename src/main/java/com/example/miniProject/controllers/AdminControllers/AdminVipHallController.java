package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.VipHall;
import com.example.miniProject.repo.VipHallRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminVipHallController {
    @Autowired
    VipHallRepositiry vipHallRepositiry;

    @GetMapping("/admin-vip-hall")
    public String getVipHall() {
        return "/Admin/Pages/admin-vip-hall";
    }


    @PostMapping("/admin-vip-hall")
    public String postVipHall(@RequestParam String title, @RequestParam String description, @RequestParam String publicDate,
                              @RequestParam boolean language, @RequestParam boolean status,
                              @RequestParam String mainImage, @RequestParam String image1, @RequestParam String image2,
                              @RequestParam String image3, @RequestParam String image4, @RequestParam String image5,
                              @RequestParam String seoUrl, @RequestParam String seoTitle,
                              @RequestParam String seoKeywords, @RequestParam String seoDescription){
        VipHall vipHall = new VipHall(title, description, publicDate, language, status, mainImage, image1, image2, image3, image4, image5,
                seoUrl, seoTitle, seoKeywords, seoDescription);
        vipHallRepositiry.save(vipHall);
        return "redirect:/admin-pages";
    }
}
