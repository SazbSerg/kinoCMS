package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.services.adminNewsService.AdminNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;

@Controller
public class AdminNewsPageController {

    @Autowired
    private AdminNewsService adminNewsService;


    @GetMapping("/admin-news-page")
    public String getNews() {
        return "/Admin/News/admin-news-page";
    }


    @PostMapping("/admin-news-page")
    public String postNews(@RequestParam String title,
                           @RequestParam String description,
                           @RequestParam Date publicDate,
                           @RequestParam boolean language,
                           @RequestParam boolean status,
                           @RequestParam("mainImage") MultipartFile file,
                           @RequestParam("image1") MultipartFile file1,
                           @RequestParam("image2") MultipartFile file2,
                           @RequestParam("image3") MultipartFile file3,
                           @RequestParam("image4") MultipartFile file4,
                           @RequestParam("image5") MultipartFile file5,
                           @RequestParam String videoLink,
                           @RequestParam String seoUrl,
                           @RequestParam String seoTitle,
                           @RequestParam String seoKeywords,
                           @RequestParam String seoDescription) throws IOException {
        adminNewsService.saveNewsData(title, description, publicDate, language, status, file, file1, file2, file3, file4, file5, videoLink, seoUrl, seoTitle, seoKeywords, seoDescription);
        return "redirect:/admin-news";
    }
}
