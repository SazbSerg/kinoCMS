package com.example.miniProject.controllers.UserPagesControllers;
import com.example.miniProject.models.AdminPagesNewPage;
import com.example.miniProject.models.BackgroundBanner;
import com.example.miniProject.models.CinemaAndHallModels.Cinema;
import com.example.miniProject.models.CinemaAndHallModels.Hall;
import com.example.miniProject.models.Film;
import com.example.miniProject.models.MainPage;
import com.example.miniProject.repo.AdminPagesNewPageRepository;
import com.example.miniProject.repo.BackgroundBannerRepository;
import com.example.miniProject.repo.CinemaAndHallRepos.CinemaRepository;
import com.example.miniProject.repo.CinemaAndHallRepos.HallRepository;
import com.example.miniProject.repo.FilmRepository;
import com.example.miniProject.repo.MainPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TimeTableController {

    @Autowired
    AdminPagesNewPageRepository adminPagesNewPageRepository;

    @Autowired
    private BackgroundBannerRepository backgroundBannerRepository;

    @Autowired
    MainPageRepository mainPageRepository;

    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    HallRepository hallRepository;

    @GetMapping("/timetable")
    public String timetable(Model model) {
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

        Iterable<Cinema> cinemas = cinemaRepository.findAll();
        model.addAttribute("cinemas", cinemas);

        Iterable<Film> films = filmRepository.findAll();
        model.addAttribute("films", films);

        Iterable<Hall> halls = hallRepository.findAll();
        model.addAttribute("halls", halls);

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
        return "/Main/TimeTable/timetable";
    }
}
