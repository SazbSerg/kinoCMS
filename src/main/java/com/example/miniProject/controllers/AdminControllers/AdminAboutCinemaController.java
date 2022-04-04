package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.AboutCinema;
import com.example.miniProject.repo.AboutCinemaRepository;
import com.example.miniProject.services.adminAboutCinemaServices.AdminAboutCinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class AdminAboutCinemaController {

    @Autowired
    AdminAboutCinemaService adminAboutCinemaService;

    @GetMapping("/admin-about-cinema")
    public String getDataAboutCinema() {
        return "/Admin/Pages/admin-about-cinema";
    }

    @PostMapping("/admin-about-cinema")
    public String postDataAboutCinema(@RequestParam String title,
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
       adminAboutCinemaService.saveAboutCinemasData(title, description, publicDate, language, status, file, file1, file2, file3, file4, file5, seoUrl, seoTitle, seoKeywords, seoDescription);
        return "redirect:/admin-pages";
    }
}
