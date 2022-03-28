package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.Film;
import com.example.miniProject.repo.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;

@Controller
public class AdminFilmsController {

    @Autowired
    private FilmRepository filmRepository;

    @GetMapping("/admin-films")
    public String filmsMain(Model model) {
        Iterable <Film> films = filmRepository.findAll();
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
        return "/Admin/Films/admin-films";
    }
}
