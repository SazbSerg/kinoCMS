package com.example.miniProject.controllers.UserPagesControllers;
import com.example.miniProject.models.AdminPagesNewPage;
import com.example.miniProject.models.BackgroundBanner;
import com.example.miniProject.models.CinemaAndHallModels.Hall;
import com.example.miniProject.models.MainPage;
import com.example.miniProject.repo.AdminPagesNewPageRepository;
import com.example.miniProject.repo.BackgroundBannerRepository;
import com.example.miniProject.repo.CinemaAndHallRepos.CinemaRepository;
import com.example.miniProject.repo.CinemaAndHallRepos.HallRepository;
import com.example.miniProject.repo.MainPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HallCardController {

    @Autowired
    private BackgroundBannerRepository backgroundBannerRepository;

    @Autowired
    MainPageRepository mainPageRepository;

    @Autowired
    HallRepository hallRepository;

    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    AdminPagesNewPageRepository adminPagesNewPageRepository;

    @GetMapping("/hall-card/{cinemaId}/{hallId}")
    public String hallCardUserGet(@PathVariable(value = "cinemaId") long idCinema, @PathVariable(value = "hallId") long idHall, Model model) {
        if (!cinemaRepository.existsById(idCinema)) {
            return "redirect:/hall-card/{cinemaId}";}
        Hall hall = hallRepository.findById(idHall).orElseThrow();
        model.addAttribute("hall", hall);

        Iterable<AdminPagesNewPage> adminPagesNewPages = adminPagesNewPageRepository.findAll();
        List<AdminPagesNewPage> currentadminPagesNewPages = new ArrayList<>();
        for (AdminPagesNewPage adminPagesNewPagesOn: adminPagesNewPages) {
            if (adminPagesNewPagesOn.isStatus()) {
                currentadminPagesNewPages.add(adminPagesNewPagesOn);
            }
        }

        model.addAttribute("newPages", currentadminPagesNewPages);

        Iterable<BackgroundBanner> backgroundBanners = backgroundBannerRepository.findAll();
        model.addAttribute("backgroundBanner", backgroundBanners);

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
        return "/Main/Cinemas/hall-card";
    }

    @GetMapping("/hall-card/{cinemaId}/main-user-page")
    public String hallCardRedirectToMainUserPage(){
        return "redirect:/main-user-page";
    }

    @GetMapping("/hall-card/{cinemaId}/poster")
    public String hallCardRedirectToPoster(){
        return "redirect:/poster";
    }

    @GetMapping("/hall-card/{cinemaId}/timetable")
    public String hallCardRedirectToTimetable(){
        return "redirect:/timetable";
    }

    @GetMapping("/hall-card/{cinemaId}/soon")
    public String hallCardRedirectToSoon(){
        return "redirect:/soon";
    }

    @GetMapping("/hall-card/{cinemaId}/cinemas")
    public String hallCardRedirectToCinemas(){
        return "redirect:/cinemas";
    }

    @GetMapping("/hall-card/{cinemaId}/stock")
    public String hallCardRedirectToStock(){
        return "redirect:/stock";
    }

    @GetMapping("/hall-card/{cinemaId}/news")
    public String hallCardRedirectToNews(){
        return "redirect:/news";
    }

    @GetMapping("/hall-card/{cinemaId}/ad")
    public String hallCardRedirectToAd(){
        return "redirect:/ad";
    }

    @GetMapping("/hall-card/{cinemaId}/cafe-bar")
    public String hallCardRedirectToCafeBar(){
        return "redirect:/cafe-bar";
    }

    @GetMapping("/hall-card/{cinemaId}/contacts")
    public String hallCardRedirectToContacts(){
        return "redirect:/contacts";
    }

    @GetMapping("/hall-card/{cinemaId}/vip-hall")
    public String hallCardRedirectToVipHall(){
        return "redirect:/vip-hall";
    }

    @GetMapping("/hall-card/{cinemaId}/mobile-apps")
    public String hallCardRedirectToMobileApps(){
        return "redirect:/mobile-apps";
    }
}
