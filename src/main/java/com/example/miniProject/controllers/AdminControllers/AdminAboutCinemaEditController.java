package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.AboutCinema;
import com.example.miniProject.repo.AboutCinemaRepository;
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
public class AdminAboutCinemaEditController {

    @Autowired
    AboutCinemaRepository aboutCinemaRepository;

    @GetMapping("/admin-about-cinema-edit/{id}")
    public String aboutCinemaEditGet(@PathVariable(value = "id") long id, Model model) {
        if (!aboutCinemaRepository.existsById(id)) {
            return "redirect: /admin-pages";}
        Optional<AboutCinema> aboutCinema = aboutCinemaRepository.findById(id);
        ArrayList<AboutCinema> res = new ArrayList<>();
        aboutCinema.ifPresent(res :: add);
        model.addAttribute("aboutCinemas", res);
        return "/Admin/Pages/admin-about-cinema-edit";
    }

    @PostMapping("/admin-about-cinema-edit/{id}")
    public String mainPageEditPost(@PathVariable(value = "id") long id,
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
        AboutCinema aboutCinema = aboutCinemaRepository.findById(id).orElseThrow();
        aboutCinema.setTitle(title);
        aboutCinema.setDescription(description);
        aboutCinema.setPublicDate(publicDate);
        aboutCinema.setLanguage(language);
        aboutCinema.setStatus(status);
        aboutCinema.setMainImage(mainImage);
        aboutCinema.setImage1(image1);
        aboutCinema.setImage2(image2);
        aboutCinema.setImage3(image3);
        aboutCinema.setImage4(image4);
        aboutCinema.setImage5(image5);
        aboutCinema.setSeoUrl(seoUrl);
        aboutCinema.setSeoTitle(seoTitle);
        aboutCinema.setSeoKeywords(seoKeywords);
        aboutCinema.setSeoDescription(seoDescription);
        aboutCinemaRepository.save(aboutCinema);
        return "redirect:/admin-pages";
    }
}
