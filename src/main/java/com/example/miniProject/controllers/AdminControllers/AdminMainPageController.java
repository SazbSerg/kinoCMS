package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.MainPage;
import com.example.miniProject.repo.MainPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminMainPageController {

    @Autowired
    MainPageRepository mainPageRepository;

    @GetMapping("/admin-main-page")
    public String mainPageView() {
        return "/Admin/Pages/admin-main-page";
    }

    @PostMapping("/admin-main-page")
    public String postMainPage(@RequestParam String name, @RequestParam String phoneNumber1, @RequestParam String phoneNumber2,
                               @RequestParam boolean language, @RequestParam boolean status,
                               @RequestParam String seoText, @RequestParam String seoUrl, @RequestParam String seoTitle,
                               @RequestParam String seoKeywords, @RequestParam String seoDescription, @RequestParam String creatingDate){
        MainPage mainPage = new MainPage(name, phoneNumber1, phoneNumber2, language, status, seoText,
                 seoUrl, seoTitle, seoKeywords, seoDescription, creatingDate);
        mainPageRepository.save(mainPage);
        return "redirect:/admin-pages";
    }
}
