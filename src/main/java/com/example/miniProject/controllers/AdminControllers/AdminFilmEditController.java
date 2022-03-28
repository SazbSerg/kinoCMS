package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.Film;
import com.example.miniProject.repo.FilmRepository;
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
public class AdminFilmEditController {
    @Autowired
    private FilmRepository filmRepository;

    @GetMapping("/admin-film-edit/{id}")
    public String filmEdit(@PathVariable(value = "id") long id, Model model) {
        if (!filmRepository.existsById(id)) {
            return "redirect: /admin-films";}
        Optional<Film> films = filmRepository.findById(id);
        ArrayList<Film> res = new ArrayList<>();
        films.ifPresent(res :: add);
        model.addAttribute("films", res);
        return "/Admin/Films/admin-film-edit";
    }

    @PostMapping("/admin-film-edit/{id}")
    public String filmPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String description,
                                 @RequestParam String mainScreen, @RequestParam String screen1,
                                 @RequestParam String screen2, @RequestParam String screen3,
                                 @RequestParam String screen4, @RequestParam String screen5,
                                 @RequestParam String trailerUrl,  @RequestParam Boolean movieType2D,
                                 @RequestParam Boolean movieType3D, @RequestParam Boolean movieTypeImax,
                                 @RequestParam String seoUrl, @RequestParam String seoTitle,
                                 @RequestParam String seoKeywords, @RequestParam String seoDescription){
        Film film = filmRepository.findById(id).orElseThrow();
        film.setTitle(title);
        film.setDescription(description);
        film.setMainScreen(mainScreen);
        film.setScreen1(screen1);
        film.setScreen2(screen2);
        film.setScreen3(screen3);
        film.setScreen4(screen4);
        film.setScreen5(screen5);
        film.setTrailerUrl(trailerUrl);
        film.setMovieType2D(movieType2D);
        film.setMovieType3D(movieType3D);
        film.setMovieTypeImax(movieTypeImax);
        film.setSeoUrl(seoUrl);
        film.setSeoTitle(seoTitle);
        film.setSeoKeywords(seoKeywords);
        film.setSeoDescription(seoDescription);
        filmRepository.save(film);
        return "redirect:/admin-films";
    }

    @PostMapping("/admin-film-edit/{id}/remove")
    public String filmPostDelete(@PathVariable(value = "id") long id, Model model){
        Film film = filmRepository.findById(id).orElseThrow();
        filmRepository.delete(film);
        return "redirect:/admin-films";
    }
}
