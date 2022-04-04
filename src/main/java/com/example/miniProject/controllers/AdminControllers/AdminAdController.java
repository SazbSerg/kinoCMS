package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.Ad;
import com.example.miniProject.repo.AdRepository;
import com.example.miniProject.services.adminAdServices.AdminAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class AdminAdController {

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private AdminAdService adminAdService;


    @GetMapping("/admin-ad")
    public String getAd() {
        return "/Admin/Pages/admin-ad";
    }

    @PostMapping("/admin-ad")
    public String postAd(@RequestParam String title,
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
        adminAdService.saveAdData(title, description, publicDate, language, status, file, file1, file2, file3, file4, file5, seoUrl, seoTitle, seoKeywords, seoDescription);
        return "redirect:/admin-pages";
    }
}
