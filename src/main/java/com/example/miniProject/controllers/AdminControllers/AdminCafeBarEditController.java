package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.CafeBar;
import com.example.miniProject.repo.CafeBarRepository;
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
public class AdminCafeBarEditController {

    @Autowired
    CafeBarRepository cafeBarRepository;

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
        CafeBar cafeBar = cafeBarRepository.findById(id).orElseThrow();
        cafeBar.setTitle(title);
        cafeBar.setDescription(description);
        cafeBar.setPublicDate(publicDate);
        cafeBar.setLanguage(language);
        cafeBar.setStatus(status);
        cafeBar.setMainImage(mainImage);
        cafeBar.setImage1(image1);
        cafeBar.setImage2(image2);
        cafeBar.setImage3(image3);
        cafeBar.setImage4(image4);
        cafeBar.setImage5(image5);
        cafeBar.setSeoUrl(seoUrl);
        cafeBar.setSeoTitle(seoTitle);
        cafeBar.setSeoKeywords(seoKeywords);
        cafeBar.setSeoDescription(seoDescription);
        cafeBarRepository.save(cafeBar);
        return "redirect:/admin-pages";
    }
}

