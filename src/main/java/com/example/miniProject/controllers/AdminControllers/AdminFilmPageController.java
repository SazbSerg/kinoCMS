package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.CafeBar;
import com.example.miniProject.models.Film;
import com.example.miniProject.repo.FilmRepository;
import com.example.miniProject.services.adminFilms.AdminFilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class AdminFilmPageController {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private AdminFilmsService adminFilmsService;

    @Value("${upload.path.film}")
    private String uploadPath;

    @GetMapping("/admin-film-page")
    public String films() {
        return "/Admin/Films/admin-film-page";
    }

    @PostMapping("/admin-film-page")
    public String filmPostAdd(@RequestParam String title, @RequestParam String description,
                              @RequestParam("mainScreen") MultipartFile file,
                              @RequestParam("screen1") MultipartFile file1,
                              @RequestParam("screen2") MultipartFile file2,
                              @RequestParam("screen3") MultipartFile file3,
                              @RequestParam("screen4") MultipartFile file4,
                              @RequestParam("screen5") MultipartFile file5,
                              @RequestParam String trailerUrl,
                              @RequestParam Boolean movieType2D, @RequestParam Boolean movieType3D,
                              @RequestParam Boolean movieTypeImax,
                              @RequestParam String seoUrl, @RequestParam String seoTitle, @RequestParam String seoKeywords,
                              @RequestParam String seoDescription,
                              @RequestParam boolean currentOrSoon,
                              @RequestParam boolean language) throws IOException {
        if ((file != null && !file.getOriginalFilename().isEmpty())||(file1 != null && !file1.getOriginalFilename().isEmpty())||
            (file2 != null && !file2.getOriginalFilename().isEmpty())||(file3 != null && !file3.getOriginalFilename().isEmpty())||
            (file4 != null && !file4.getOriginalFilename().isEmpty())||(file5 != null && !file5.getOriginalFilename().isEmpty())) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
        }

        Film film = new Film();
        film.setTitle(title);
        film.setDescription(description);
        film.setTrailerUrl(trailerUrl);
        film.setMovieType2D(movieType2D);
        film.setMovieType3D(movieType3D);
        film.setMovieTypeImax(movieTypeImax);
        film.setSeoUrl(seoUrl);
        film.setSeoTitle(seoTitle);
        film.setSeoKeywords(seoKeywords);
        film.setSeoDescription(seoDescription);
        film.setCurrentOrSoon(currentOrSoon);
        film.setLanguage(language);

        adminFilmsService.saveFile(film, file, file1, file2, file3, file4, file5);

        filmRepository.save(film);
        return "redirect:/admin-films";
    }
}
