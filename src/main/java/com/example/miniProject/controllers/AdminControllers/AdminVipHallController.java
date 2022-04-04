package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.VipHall;
import com.example.miniProject.repo.VipHallRepositiry;
import com.example.miniProject.services.adminVipHallServices.AdminVipHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class AdminVipHallController {

    @Autowired
    private VipHallRepositiry vipHallRepositiry;

    @Autowired
    private AdminVipHallService adminVipHallService;


    @GetMapping("/admin-vip-hall")
    public String getVipHall() {
        return "/Admin/Pages/admin-vip-hall";
    }


    @PostMapping("/admin-vip-hall")
    public String postVipHall(@RequestParam String title,
                              @RequestParam String description,
                              @RequestParam String publicDate,
                              @RequestParam boolean language,
                              @RequestParam boolean status,
                              @RequestParam("mainImage") MultipartFile file,
                              @RequestParam("image1") MultipartFile file1,
                              @RequestParam("image2") MultipartFile file2,
                              @RequestParam("image3") MultipartFile file3,
                              @RequestParam("image4") MultipartFile file4,
                              @RequestParam("image5") MultipartFile file5,
                              @RequestParam String seoUrl,
                              @RequestParam String seoTitle,
                              @RequestParam String seoKeywords,
                              @RequestParam String seoDescription) throws IOException {
        adminVipHallService.saveVipHallData(title, description, publicDate, language, status, file, file1, file2, file3, file4, file5, seoUrl, seoTitle, seoKeywords, seoDescription);
        return "redirect:/admin-pages";
    }
}
