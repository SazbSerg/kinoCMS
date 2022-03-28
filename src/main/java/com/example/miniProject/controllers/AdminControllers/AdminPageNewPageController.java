package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.AdminPagesNewPage;
import com.example.miniProject.repo.AdminPagesNewPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminPageNewPageController {

    @Autowired
    private AdminPagesNewPageRepository adminPagesNewPageRepository;

    @GetMapping("/admin-pages-new-page")
    public String getNewPage(Model model) {

        return "/Admin/Pages/admin-pages-new-page";
    }

    @PostMapping("/admin-pages-new-page")
    public String postNewPage(@RequestParam String title, @RequestParam String description, @RequestParam String publicDate,
                              @RequestParam boolean language, @RequestParam boolean status,
                              @RequestParam String mainImage, @RequestParam String image1, @RequestParam String image2,
                              @RequestParam String image3, @RequestParam String image4, @RequestParam String image5,
                              @RequestParam String seoUrl, @RequestParam String seoTitle,
                              @RequestParam String seoKeywords, @RequestParam String seoDescription){
        AdminPagesNewPage adminPagesNewPage = new AdminPagesNewPage(title, description, publicDate, language, status, mainImage, image1, image2, image3, image4, image5,
                seoUrl, seoTitle, seoKeywords, seoDescription);
        adminPagesNewPageRepository.save(adminPagesNewPage);
        return "redirect:/admin-pages";
    }
}
