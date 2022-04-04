package com.example.miniProject.controllers.AdminControllers.CinemaAndHallsControllers;

import com.example.miniProject.repo.CinemaAndHallRepos.CinemaRepository;
import com.example.miniProject.repo.CinemaAndHallRepos.HallRepository;
import com.example.miniProject.services.adminCinemaAndHallServices.AdminCinemaAndHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class AdminCinemaController {

    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private HallRepository hallRepository;
    @Autowired
    AdminCinemaAndHallService adminCinemaAndHallService;


    //Обработка страницы показа списка кинотеатров
    @GetMapping("/admin-cinema-list")
    public String getListOfCinema(Model model) {
        adminCinemaAndHallService.findAllCinemas(model);
        return "/Admin/CinemasAndHalls/admin-cinema-list";
    }


    //Обработка ссылки перехода на страницу создания кинотеатра
    @GetMapping("/admin-cinema-create")
    public String createNewCinemaGet() {
        return "/Admin/CinemasAndHalls/admin-cinema-create";
    }


    //Сохранение нового созданного кинотеатра
    @PostMapping("/admin-cinema-create")
    public String createNewCinemaPost(@RequestParam String cinemaTitle,
                                   @RequestParam boolean language,
                                   @RequestParam String description,
                                   @RequestParam String conditions,
                                   @RequestParam("hallPlan") MultipartFile fileLogo,
                                   @RequestParam("topBanner") MultipartFile file,
                                   @RequestParam("image1") MultipartFile file1,
                                   @RequestParam("image2") MultipartFile file2,
                                   @RequestParam("image3") MultipartFile file3,
                                   @RequestParam("image4") MultipartFile file4,
                                   @RequestParam("image5") MultipartFile file5,
                                   @RequestParam String seoUrl,
                                   @RequestParam String seoTitle,
                                   @RequestParam String seoKeywords,
                                   @RequestParam String seoDescription) throws IOException {
        adminCinemaAndHallService.saveCinemaData(cinemaTitle, language, description, conditions, fileLogo, file, file1, file2, file3, file4, file5, seoUrl, seoTitle, seoKeywords, seoDescription);
        return "redirect:/admin-cinema-list";
    }


    //Удаление кинотеатра со списка кинотеатров
    @PostMapping("/admin-cinema-list/{id}/remove")
    public String removeCinema(@PathVariable(value = "id") long id){
       adminCinemaAndHallService.removeCinema(id);
       return "redirect:/admin-cinema-list";
    }


    //Переход к редактированию кинотеатров с возможностью создания залов
    @GetMapping("/admin-cinema-card-options/{id}")
    public String cinemaCardEditGet(@PathVariable(value = "id") long id, Model model) {
        if (!cinemaRepository.existsById(id)) {
            return "redirect:/admin-cinema-list";
        }
        adminCinemaAndHallService.displayCinemaWithHalls(model, id);
        return "/Admin/CinemasAndHalls/admin-cinema-card-options";
    }



    //Сохранение результаов редактирования кинотеатра с переходом на страницу списка кинотеатров
    @PostMapping("/admin-cinema-card-options/{id}")
    public String cinemaCardPost(@PathVariable(value = "id") long id, @RequestParam String cinemaTitle,
                                 @RequestParam boolean language,
                                 @RequestParam String description,
                                 @RequestParam String conditions,
                                 @RequestParam("hallPlan") MultipartFile fileLogo,
                                 @RequestParam("topBanner") MultipartFile file,
                                 @RequestParam("image1") MultipartFile file1,
                                 @RequestParam("image2") MultipartFile file2,
                                 @RequestParam("image3") MultipartFile file3,
                                 @RequestParam("image4") MultipartFile file4,
                                 @RequestParam("image5") MultipartFile file5,
                                 @RequestParam String seoUrl,
                                 @RequestParam String seoTitle,
                                 @RequestParam String seoKeywords,
                                 @RequestParam String seoDescription) throws IOException {
        adminCinemaAndHallService.saveCinemaData(id, cinemaTitle, language, description, conditions, fileLogo, file, file1, file2, file3, file4, file5, seoUrl, seoTitle, seoKeywords, seoDescription);
        return "redirect:/admin-cinema-list";
    }
}
