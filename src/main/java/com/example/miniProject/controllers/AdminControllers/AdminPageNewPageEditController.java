package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.AdminPagesNewPage;
import com.example.miniProject.repo.AdminPagesNewPageRepository;
import com.example.miniProject.services.adminSomeNewPageServices.AdminSomeNewPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AdminPageNewPageEditController {
    @Autowired
    private AdminPagesNewPageRepository adminPagesNewPageRepository;

    @Autowired
    private AdminSomeNewPageService adminSomeNewPageService;


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
        adminSomeNewPageService.saveSomeNewPageData(id, title, description, publicDate, language, status, file, file1, file2, file3, file4, file5, seoUrl, seoTitle, seoKeywords, seoDescription);
        return "redirect:/admin-pages";
    }


    @PostMapping("/admin-pages-new-page-remove/{id}")
    public String postNewPageRemove(@PathVariable(value = "id") long id){
        AdminPagesNewPage adminPagesNewPage = adminPagesNewPageRepository.findById(id).orElseThrow();
        adminPagesNewPageRepository.delete(adminPagesNewPage);
        return "redirect:/admin-pages";
    }
}
