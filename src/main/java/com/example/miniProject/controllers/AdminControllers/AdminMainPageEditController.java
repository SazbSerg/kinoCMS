package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.MainPage;
import com.example.miniProject.repo.MainPageRepository;
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
public class AdminMainPageEditController {

    @Autowired
    MainPageRepository mainPageRepository;

    @GetMapping("/admin-main-page-edit/{id}")
    public String mainPageEditGet(@PathVariable(value = "id") long id, Model model) {
        if (!mainPageRepository.existsById(id)) {
            return "redirect: /admin-pages";}
        Optional<MainPage> mainPage = mainPageRepository.findById(id);
        ArrayList<MainPage> res = new ArrayList<>();
        mainPage.ifPresent(res :: add);
        model.addAttribute("mainPages", res);
        return "/Admin/Pages/admin-main-page-edit";
    }

    @PostMapping("/admin-main-page-edit/{id}")
    public String mainPageEditPost(@PathVariable(value = "id") long id, @RequestParam String name,
                                   @RequestParam String phoneNumber1,
                                   @RequestParam String phoneNumber2,
                                   @RequestParam boolean language,
                                   @RequestParam boolean status,
                                   @RequestParam String seoText,
                                   @RequestParam String seoUrl,
                                   @RequestParam String seoTitle,
                                   @RequestParam String seoKeywords,
                                   @RequestParam String seoDescription, @RequestParam String creatingDate){
        MainPage mainPage = mainPageRepository.findById(id).orElseThrow();
        mainPage.setName(name);
        mainPage.setPhoneNumber1(phoneNumber1);
        mainPage.setPhoneNumber2(phoneNumber2);
        mainPage.setLanguage(language);
        mainPage.setStatus(status);
        mainPage.setSeoText(seoText);
        mainPage.setSeoUrl(seoUrl);
        mainPage.setSeoTitle(seoTitle);
        mainPage.setSeoKeywords(seoKeywords);
        mainPage.setSeoDescription(seoDescription);
        mainPage.setCreatingDate(creatingDate);
        mainPageRepository.save(mainPage);
        return "redirect:/admin-pages";
    }
}
