package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.AdminPagesNewPage;
import com.example.miniProject.repo.AdminPagesNewPageRepository;
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
public class AdminPageNewPageEditController {
    @Autowired
    private AdminPagesNewPageRepository adminPagesNewPageRepository;

    @GetMapping("/admin-pages-new-page-edit/{id}")
    public String getNewPageEdit(@PathVariable(value = "id") long id, Model model) {
        if (!adminPagesNewPageRepository.existsById(id)) {
            return "redirect: /admin-pages";}
        Optional<AdminPagesNewPage> adminPagesNewPage = adminPagesNewPageRepository.findById(id);
        ArrayList<AdminPagesNewPage> res = new ArrayList<>();
        adminPagesNewPage.ifPresent(res :: add);
        model.addAttribute("newPages", res);
        return "/Admin/Pages/admin-pages-new-page-edit";
    }

    @PostMapping("/admin-pages-new-page-edit/{id}")
    public String postNewPageEdit(@PathVariable(value = "id") long id,
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
        AdminPagesNewPage adminPagesNewPage = adminPagesNewPageRepository.findById(id).orElseThrow();
        adminPagesNewPage.setTitle(title);
        adminPagesNewPage.setDescription(description);
        adminPagesNewPage.setPublicDate(publicDate);
        adminPagesNewPage.setLanguage(language);
        adminPagesNewPage.setStatus(status);
        adminPagesNewPage.setMainImage(mainImage);
        adminPagesNewPage.setImage1(image1);
        adminPagesNewPage.setImage2(image2);
        adminPagesNewPage.setImage3(image3);
        adminPagesNewPage.setImage4(image4);
        adminPagesNewPage.setImage5(image5);
        adminPagesNewPage.setSeoUrl(seoUrl);
        adminPagesNewPage.setSeoTitle(seoTitle);
        adminPagesNewPage.setSeoKeywords(seoKeywords);
        adminPagesNewPage.setSeoDescription(seoDescription);
        adminPagesNewPageRepository.save(adminPagesNewPage);
        return "redirect:/admin-pages";
    }

    @PostMapping("/admin-pages-new-page-remove/{id}")
    public String postNewPageRemove(@PathVariable(value = "id") long id){
        AdminPagesNewPage adminPagesNewPage = adminPagesNewPageRepository.findById(id).orElseThrow();
        adminPagesNewPageRepository.delete(adminPagesNewPage);
        return "redirect:/admin-pages";
    }
}
