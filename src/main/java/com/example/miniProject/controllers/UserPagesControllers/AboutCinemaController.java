package com.example.miniProject.controllers.UserPagesControllers;
import com.example.miniProject.models.AboutCinema;
import com.example.miniProject.models.AdminPagesNewPage;
import com.example.miniProject.models.BackgroundBanner;
import com.example.miniProject.models.MainPage;
import com.example.miniProject.repo.AboutCinemaRepository;
import com.example.miniProject.repo.AdminPagesNewPageRepository;
import com.example.miniProject.repo.BackgroundBannerRepository;
import com.example.miniProject.repo.MainPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AboutCinemaController {

    @Autowired
    private BackgroundBannerRepository backgroundBannerRepository;

    @Autowired
    MainPageRepository mainPageRepository;

    @Autowired
    AboutCinemaRepository aboutCinemaRepository;

    @Autowired
    AdminPagesNewPageRepository adminPagesNewPageRepository;

    @GetMapping("/about-cinema")
    public String aboutCinemaUserGet(Model model) {
        Iterable<BackgroundBanner> backgroundBanners = backgroundBannerRepository.findAll();
        model.addAttribute("backgroundBanner", backgroundBanners);

        Iterable<AboutCinema> aboutCinemas = aboutCinemaRepository.findAll();
        model.addAttribute("aboutCinemas", aboutCinemas);

        Iterable<AdminPagesNewPage> adminPagesNewPages = adminPagesNewPageRepository.findAll();
        List<AdminPagesNewPage> currentadminPagesNewPages = new ArrayList<>();
        for (AdminPagesNewPage adminPagesNewPagesOn: adminPagesNewPages) {
            if (adminPagesNewPagesOn.isStatus()) {
                currentadminPagesNewPages.add(adminPagesNewPagesOn);
            }
        }
        model.addAttribute("newPages", currentadminPagesNewPages);

        Iterable<MainPage> mainPages = mainPageRepository.findAll();
        for (MainPage mainPageOn: mainPages) {
            if (mainPageOn.isStatus()) {
                model.addAttribute("mainPages", mainPages);
            } else {
                MainPage mainPage = new MainPage();
                model.addAttribute("mainPages", mainPage);
                mainPageRepository.delete(mainPage);
            }
        }
        return "/Main/AboutCinema/about-cinema";
    }
}
