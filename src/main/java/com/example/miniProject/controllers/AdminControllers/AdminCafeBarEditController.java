package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.CafeBar;
import com.example.miniProject.repo.CafeBarRepository;
import com.example.miniProject.services.adminCafeBar.AdminCafeBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Controller
public class AdminCafeBarEditController {

    @Value("${upload.path.cafe.bar}")
    private String uploadPath;

    @Autowired
    CafeBarRepository cafeBarRepository;

    @Autowired
    AdminCafeBarService adminCafeBarService;

    @GetMapping("/admin-cafe-bar-edit/{id}")
    public String getCafeBarEdit(@PathVariable(value = "id") long id, Model model) {
            if (!cafeBarRepository.existsById(id)) {
                return "redirect: /admin-pages";}
            Optional<CafeBar> cafeBar = cafeBarRepository.findById(id);
            ArrayList<CafeBar> res = new ArrayList<>();
            cafeBar.ifPresent(res :: add);
            model.addAttribute("cafeBars", res);
        return "/Admin/Pages/admin-cafe-bar-edit";
    }

    @PostMapping("/admin-cafe-bar-edit/{id}")
    public String postCafeBarEdit(@PathVariable(value = "id") long id,
                                  @RequestParam String title,
                                  @RequestParam String description,
                                  @RequestParam String publicDate,
                                  @RequestParam boolean language,
                                  @RequestParam boolean status,
                                  @RequestParam("image1") MultipartFile file1,
                                  @RequestParam("image2") MultipartFile file2,
                                  @RequestParam("image3") MultipartFile file3,
                                  @RequestParam("image4") MultipartFile file4,
                                  @RequestParam("image5") MultipartFile file5,
                                  @RequestParam String seoUrl,
                                  @RequestParam String seoTitle,
                                  @RequestParam String seoKeywords,
                                  @RequestParam String seoDescription,
                                  @RequestParam("file") MultipartFile file) throws IOException {
        CafeBar cafeBar = cafeBarRepository.findById(id).orElseThrow();
   //   //
   //   //  if (file != null && !file.getOriginalFilename().isEmpty()) {
   //   //      File uploadDir = new File(uploadPath);
   //   //
   //   //      if (!uploadDir.exists()) {
   //   //          uploadDir.mkdir();
   //   //      }

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


    @GetMapping("/admin-cafe-bar-edit/admin-pages")
    public String cafeBarRedirectToAdminPages(){
        return "redirect:/admin-pages";
    }
    @GetMapping("/admin-cafe-bar-edit/admin-statistics")
    public String cafeBarRedirectToAdminStatistics(){
        return "redirect:/admin-statistics";
    }
    @GetMapping("/admin-cafe-bar-edit/admin-banners")
    public String cafeBarRedirectToAdminBanners(){
        return "redirect:/admin-banners";
    }
    @GetMapping("/admin-cafe-bar-edit/admin-films")
    public String cafeBarRedirectToFilms(){
        return "redirect:/admin-films";
    }
    @GetMapping("/admin-cafe-bar-edit/admin-film-page")
    public String cafeBarRedirectToFilmPage(){
        return "redirect:/admin-film-page";
    }
    @GetMapping("/admin-cafe-bar-edit/admin-cinemas")
    public String cafeBarRedirectToCinemas(){
        return "redirect:/admin-cinemas";
    }
    @GetMapping("/admin-cafe-bar-edit/admin-cinema-card")
    public String cafeBarRedirectToCinema(){
        return "redirect:/admin-cinema-card";
    }
    @GetMapping("/admin-cafe-bar-edit/admin-news")
    public String cafeBarRedirectToNews(){
        return "redirect:/admin-news";
    }
    @GetMapping("/admin-cafe-bar-edit/admin-news-page")
    public String cafeBarRedirectToNewsPage(){
        return "redirect:/admin-news-page";
    }
    @GetMapping("/admin-cafe-bar-edit/admin-stocks")
    public String cafeBarRedirectToStocks(){
        return "redirect:/admin-stocks";
    }
    @GetMapping("/admin-cafe-bar-edit/admin-stock-page")
    public String cafeBarRedirectToStock(){
        return "redirect:/admin-stock-page";
    }
    @GetMapping("/admin-cafe-bar-edit/admin-main-page")
    public String cafeBarRedirectToMainPage(){
        return "redirect:/admin-main-page";
    }
    @GetMapping("/admin-cafe-bar-edit/admin-about-cinema")
    public String cafeBarRedirectToAboutCinema(){
        return "redirect:/admin-about-cinema";
    }
    @GetMapping("/admin-cafe-bar-edit/admin-cafe-bar")
    public String cafeBarRedirectToCafeBar(){
        return "redirect:/admin-cafe-bar";
    }
    @GetMapping("/admin-cafe-bar-edit/admin-vip-hall")
    public String cafeBarRedirectToVipHall(){
        return "redirect:/admin-vip-hall";
    }
    @GetMapping("/admin-cafe-bar-edit/admin-ad")
    public String cafeBarRedirectToAd(){
        return "redirect:/admin-ad";
    }
    @GetMapping("/admin-cafe-bar-edit/admin-children-room")
    public String cafeBarRedirectToChildrenRoom(){
        return "redirect:/admin-children-room";
    }
    @GetMapping("/admin-cafe-bar-edit/admin-contacts")
    public String cafeBarRedirectToContacts(){
        return "redirect:/admin-contacts";
    }
    @GetMapping("/admin-cafe-bar-edit/admin-users")
    public String cafeBarRedirectToUsers(){
        return "redirect:/admin-users";
    }
    @GetMapping("/admin-cafe-bar-edit/admin-user-editing")
    public String cafeBarRedirectToUser(){
        return "redirect:/admin-user-editing";
    }
    @GetMapping("/admin-cafe-bar-edit/admin-mailing")
    public String cafeBarRedirectToMailing(){
        return "redirect:/admin-mailing";
    }
    @GetMapping("/admin-cafe-bar-edit/admin-mailing-user-choice")
    public String cafeBarRedirectToMailingUserChoice(){
        return "redirect:/admin-mailing-user-choice";
    }
}

