package com.example.miniProject.controllers.UserPagesControllers;
import com.example.miniProject.models.AdminPagesNewPage;
import com.example.miniProject.models.BackgroundBanner;
import com.example.miniProject.models.CinemaAndHallModels.Cinema;
import com.example.miniProject.models.MainPage;
import com.example.miniProject.repo.AdminPagesNewPageRepository;
import com.example.miniProject.repo.BackgroundBannerRepository;
import com.example.miniProject.repo.CinemaAndHallRepos.CinemaRepository;
import com.example.miniProject.repo.MainPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CinemaCardController {
    @Autowired
    private BackgroundBannerRepository backgroundBannerRepository;

    @Autowired
    MainPageRepository mainPageRepository;

    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    AdminPagesNewPageRepository adminPagesNewPageRepository;

    @GetMapping("/cinema-card/{id}")
    public String cinemaCardUserGet(@PathVariable(value = "id") long id, Model model) {
        if (!cinemaRepository.existsById(id)) {
            return "redirect: /cinemas";}
        Optional<Cinema> cinema = cinemaRepository.findById(id);
        ArrayList<Cinema> res = new ArrayList<>();
        cinema.ifPresent(res :: add);
        model.addAttribute("cinemas", res);

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
        return "/Main/Cinemas/cinema-card";
    }

    @GetMapping("/cinema-card/main-user-page")
    public String cinemaCardRedirectToMainUserPage(){
        return "redirect:/main-user-page";
    }

    @GetMapping("/cinema-card/poster")
    public String cinemaCardRedirectToPoster(){
        return "redirect:/poster";
    }

    @GetMapping("/cinema-card/timetable")
    public String cinemaCardRedirectToTimetable(){
        return "redirect:/timetable";
    }

    @GetMapping("/cinema-card/soon")
    public String cinemaCardRedirectToSoon(){
        return "redirect:/soon";
    }

    @GetMapping("/cinema-card/cinemas")
    public String cinemaCardRedirectToCinemas(){
        return "redirect:/cinemas";
    }

    @GetMapping("/cinema-card/stock")
    public String cinemaCardRedirectToStock(){
        return "redirect:/stock";
    }

    @GetMapping("/cinema-card/news")
    public String cinemaCardRedirectToNews(){
        return "redirect:/news";
    }

    @GetMapping("/cinema-card/about-cinema")
    public String cinemaCardRedirectToAboutCinema(){
        return "redirect:/about-cinema";
    }

    @GetMapping("/cinema-card/ad")
    public String cinemaCardRedirectToAd(){
        return "redirect:/ad";
    }

    @GetMapping("/cinema-card/cafe-bar")
    public String cinemaCardRedirectToCafeBar(){
        return "redirect:/cafe-bar";
    }

    @GetMapping("/cinema-card/contacts")
    public String cinemaCardRedirectToContacts(){
        return "redirect:/contacts";
    }

    @GetMapping("/cinema-card/children-room")
    public String cinemaCardRedirectToChildrenRomm(){
        return "redirect:/children-room";
    }

    @GetMapping("/cinema-card/vip-hall")
    public String cinemaCardRedirectToVipHall(){
        return "redirect:/vip-hall";
    }

    @GetMapping("/cinema-card/some-new-page")
    public String cinemaCardRedirectToSomeNewPageUserSide(){
        return "redirect:/some-new-page";
    }

    @GetMapping("/cinema-card/mobile-apps")
    public String mobileAppsFromCinemaCard(){
        return "redirect:/mobile-apps";
    }

    @GetMapping("/cinema-card/admin-statistics")
    public String cinemaCardRedirectToAdminPanel(){
        return "redirect:/admin-statistics";
    }

    @GetMapping("/cinema-card/client-section")
    public String cinemaCardRedirectToClientSection(){
        return "redirect:/client-section";
    }
}
