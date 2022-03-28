package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.Film;
import com.example.miniProject.repo.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminFilmPageController {

    @Autowired
    private FilmRepository filmRepository;

    @GetMapping("/admin-film-page")
    public String films() {
        return "/Admin/Films/admin-film-page";
    }

    @PostMapping("/admin-film-page")
    public String filmPostAdd(@RequestParam String title, @RequestParam String description, @RequestParam String mainScreen,
                              @RequestParam String screen1, @RequestParam String screen2,
                              @RequestParam String screen3, @RequestParam String screen4,
                              @RequestParam String screen5, @RequestParam String trailerUrl,
                              @RequestParam Boolean movieType2D, @RequestParam Boolean movieType3D,
                              @RequestParam Boolean movieTypeImax,
                              @RequestParam String seoUrl, @RequestParam String seoTitle, @RequestParam String seoKeywords,
                              @RequestParam String seoDescription,
                              @RequestParam boolean currentOrSoon){
        Film film = new Film(title, description, mainScreen, screen1, screen2, screen3, screen4, screen5, trailerUrl, movieType2D,
                movieType3D, movieTypeImax, seoUrl, seoTitle, seoKeywords, seoDescription, currentOrSoon);
        filmRepository.save(film);
        return "redirect:/admin-films";
    }
}
