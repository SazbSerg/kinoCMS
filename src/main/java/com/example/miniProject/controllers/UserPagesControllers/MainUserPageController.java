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
public class MainUserPageController {

    @Autowired
    BannersSlidersRepository bannersSlidersRepository;

    @Autowired
    private BackgroundBannerRepository backgroundBannerRepository;

    @Autowired
    private MainTopBannersOptionsRepository mainTopBannersOptionsRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    MainPageRepository mainPageRepository;

    @Autowired
    MainNewsStocksBannersRepository mainNewsStocksBannersRepository;

    @Autowired
    MainNewsStocksBannersOptionsRepository mainNewsStocksBannersOptionsRepository;

    @Autowired
    AdminPagesNewPageRepository adminPagesNewPageRepository;

    @Autowired
    AdRepository adRepository;

    @GetMapping("/main-user-page")
    public String getMainUserPage(Model model) {
        Iterable<Film> films = filmRepository.findAll();
        ArrayList<Film> currentFilms = new ArrayList<>();
        ArrayList<Film> soonFilms = new ArrayList<>();
        for (Film allFilms: films) {
            if (allFilms.isCurrentOrSoon()){
                currentFilms.add(allFilms);
            } else {
                soonFilms.add(allFilms);
            }
        }
        model.addAttribute("currentFilms", currentFilms);
        model.addAttribute("soonFilms", soonFilms);

        Iterable<BackgroundBanner> backgroundBanners = backgroundBannerRepository.findAll();
        Iterable<BannersSliders> bannersSliders = bannersSlidersRepository.findAll();
        Iterable<MainTopBannersOptions> mainTopBannersOptions = mainTopBannersOptionsRepository.findAll();

        Iterable<MainNewsStocksBanners> mainNewsStocksBanners = mainNewsStocksBannersRepository.findAll();
        Iterable<MainNewsStocksBannersOptions> mainNewsStocksBannersOptions = mainNewsStocksBannersOptionsRepository.findAll();

        Iterable<AdminPagesNewPage> adminPagesNewPages = adminPagesNewPageRepository.findAll();
        List<AdminPagesNewPage> currentadminPagesNewPages = new ArrayList<>();
        for (AdminPagesNewPage adminPagesNewPagesOn: adminPagesNewPages) {
            if (adminPagesNewPagesOn.isStatus()) {
                currentadminPagesNewPages.add(adminPagesNewPagesOn);
            }
        }
        model.addAttribute("newPages", currentadminPagesNewPages);
        model.addAttribute("backgroundBanner", backgroundBanners);
        model.addAttribute("banners", bannersSliders);
        model.addAttribute("topBannerOptions", mainTopBannersOptions);
        model.addAttribute("mainNewsStocksBanners", mainNewsStocksBanners);
        model.addAttribute("mainNewsStocksBannersOptions", mainNewsStocksBannersOptions);

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
        return "/Main/main-user-page";
    }
}
