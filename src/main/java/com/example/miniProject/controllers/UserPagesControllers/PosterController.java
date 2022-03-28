package com.example.miniProject.controllers.UserPagesControllers;
import com.example.miniProject.models.*;
import com.example.miniProject.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PosterController {
    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private MainPageRepository mainPageRepository;

    @Autowired
    private BackgroundBannerRepository backgroundBannerRepository;

    @Autowired
    private AdminPagesNewPageRepository adminPagesNewPageRepository;


    @GetMapping("/poster")
    public String getPoster(Model model) {
        Iterable<Film> films = filmRepository.findAll();
        ArrayList<Film> currentFilms = new ArrayList<>();
        for (Film allFilms: films) {
            if (allFilms.isCurrentOrSoon()){
                currentFilms.add(allFilms);
            }
        }
        model.addAttribute("currentFilms", currentFilms);

        Iterable<BackgroundBanner> backgroundBanners = backgroundBannerRepository.findAll();
        model.addAttribute("backgroundBanner", backgroundBanners);

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
        return "/Main/Poster/poster";
    }
}
