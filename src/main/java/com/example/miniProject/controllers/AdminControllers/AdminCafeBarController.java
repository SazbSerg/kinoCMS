package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.CafeBar;
import com.example.miniProject.repo.CafeBarRepository;
import com.example.miniProject.services.adminCafeBar.AdminCafeBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class AdminCafeBarController {
    @Autowired
    CafeBarRepository cafeBarRepository;

    @Autowired
    AdminCafeBarService adminCafeBarService;

    @Value("${upload.path.cafe.bar}")
    private String uploadPath;

    @GetMapping("/admin-cafe-bar")
    public String getCafeBar() {
        return "/Admin/Pages/admin-cafe-bar";
    }

    @PostMapping("/admin-cafe-bar")
    public String postCafeBar(@RequestParam String title,
                              @RequestParam String description,
                              @RequestParam String publicDate,
                              @RequestParam boolean language,
                              @RequestParam boolean status,
                              @RequestParam("image1") MultipartFile file1,
                              @RequestParam("image2") MultipartFile file2,
                              @RequestParam("image3") MultipartFile file3,
                              @RequestParam("image4") MultipartFile file4,
                              @RequestParam("image5") MultipartFile file5,
                              @RequestParam String seoUrl, @RequestParam String seoTitle,
                              @RequestParam String seoKeywords, @RequestParam String seoDescription,
                              @RequestParam("file") MultipartFile file) throws IOException {

        if ((file != null && !file.getOriginalFilename().isEmpty())||(file1 != null && !file1.getOriginalFilename().isEmpty())||
            (file2 != null && !file2.getOriginalFilename().isEmpty())||(file3 != null && !file3.getOriginalFilename().isEmpty())||
            (file4 != null && !file4.getOriginalFilename().isEmpty())||(file5 != null && !file5.getOriginalFilename().isEmpty())) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
        }

        CafeBar cafeBar = new CafeBar();
        cafeBar.setTitle(title);
        cafeBar.setDescription(description);
        cafeBar.setPublicDate(publicDate);
        cafeBar.setLanguage(language);
        cafeBar.setStatus(status);
        cafeBar.setSeoUrl(seoUrl);
        cafeBar.setSeoTitle(seoTitle);
        cafeBar.setSeoKeywords(seoKeywords);
        cafeBar.setSeoDescription(seoDescription);

        adminCafeBarService.saveFile(cafeBar, file, file1, file2, file3, file4, file5);

        cafeBarRepository.save(cafeBar);
        return "redirect:/admin-pages";
    }
}

