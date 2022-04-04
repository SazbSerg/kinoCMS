package com.example.miniProject.controllers.UserPagesControllers;
import com.example.miniProject.models.AdminPagesNewPage;
import com.example.miniProject.models.BackgroundBanner;
import com.example.miniProject.models.CinemaAndHallModels.Cinema;
import com.example.miniProject.models.Film;
import com.example.miniProject.models.MainPage;
import com.example.miniProject.repo.AdminPagesNewPageRepository;
import com.example.miniProject.repo.BackgroundBannerRepository;
import com.example.miniProject.repo.CinemaAndHallRepos.CinemaRepository;
import com.example.miniProject.repo.FilmRepository;
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
public class MovieCardController {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private BackgroundBannerRepository backgroundBannerRepository;

    @Autowired
    MainPageRepository mainPageRepository;

    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    AdminPagesNewPageRepository adminPagesNewPageRepository;

    @GetMapping("/movie-card/{id}")
    public String movieCardUserGet(@PathVariable(value = "id") long id, Model model) {
        if (!filmRepository.existsById(id)) {
            return "redirect: /soon";}
        Optional<Film> films = filmRepository.findById(id);
        ArrayList<Film> res = new ArrayList<>();
        films.ifPresent(res :: add);
        model.addAttribute("films", res);

        Iterable<Cinema> cinemas = cinemaRepository.findAll();
        model.addAttribute("cinemas", cinemas);

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
        return "/Main/Poster/movie-card";
    }

    @GetMapping("/movie-card/main-user-page")
    public String movieCardRedirectToMainUserPage(){
        return "redirect:/main-user-page";
    }

    @GetMapping("/movie-card/poster")
    public String movieCardRedirectToPoster(){
        return "redirect:/poster";
    }

    @GetMapping("/movie-card/timetable")
    public String movieCardRedirectToTimetable(){
        return "redirect:/timetable";
    }

    @GetMapping("/movie-card/soon")
    public String movieCardRedirectToSoon(){
        return "redirect:/soon";
    }

    @GetMapping("/movie-card/cinemas")
    public String movieCardRedirectToCinemas(){
        return "redirect:/cinemas";
    }

    @GetMapping("/movie-card/stock")
    public String movieCardRedirectToStock(){
        return "redirect:/stock";
    }

    @GetMapping("/movie-card/news")
    public String movieCardRedirectToNews(){
        return "redirect:/news";
    }

    @GetMapping("/movie-card/ad")
    public String movieCardRedirectToAd(){
        return "redirect:/ad";
    }

    @GetMapping("/movie-card/cafe-bar")
    public String movieCardRedirectToCafeBar(){
        return "redirect:/cafe-bar";
    }

    @GetMapping("/movie-card/contacts")
    public String movieCardRedirectToContacts(){
        return "redirect:/contacts";
    }

    @GetMapping("/movie-card/vip-hall")
    public String movieCardRedirectToVipHall(){
        return "redirect:/vip-hall";
    }

    @GetMapping("/movie-card/mobile-apps")
    public String movieCardRedirectToMobileApps(){
        return "redirect:/mobile-apps";
    }

    @GetMapping("/movie-card/client-section")
    public String movieCardRedirectToClientSection(){
        return "redirect:/client-section";
    }

    @GetMapping("/movie-card/about-cinema")
    public String movieCardRedirectToAboutCinema(){
        return "redirect:/about-cinema";
    }

    @GetMapping("/movie-card/children-room")
    public String movieCardRedirectToChildrenRomm(){
        return "redirect:/children-room";
    }

    @GetMapping("/movie-card/admin-statistics")
    public String movieCardRedirectToAdminPanel(){
        return "redirect:/admin-statistics";
    }
}
