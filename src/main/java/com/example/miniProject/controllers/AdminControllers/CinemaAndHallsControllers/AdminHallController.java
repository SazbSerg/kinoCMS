package com.example.miniProject.controllers.AdminControllers.CinemaAndHallsControllers;

import com.example.miniProject.models.CinemaAndHallModels.Cinema;
import com.example.miniProject.models.CinemaAndHallModels.Hall;
import com.example.miniProject.models.TestPackage.ChildClass;
import com.example.miniProject.models.TestPackage.ParentClass;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminHallController {
    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private AdminCinemaAndHallService adminCinemaAndHallService;


    //Переход на страницу создания нового зала с привязкой к id текущего кинотеатра
    @GetMapping("/admin-hall-card/{id}")
    public String getHallCardPage(@PathVariable(value = "id") long id) {
        return "/Admin/CinemasAndHalls/admin-hall-card";
    }


    //Сохранение созданного зала с переходом на страницу текущего кинотеатра по его id
    @PostMapping("/admin-hall-card/{id}")
    public String postHallCardPage(@PathVariable(value = "id") long id,
                                   @RequestParam String hallNumber,
                                   @RequestParam String description,
                                   @RequestParam("hallPlan") MultipartFile fileHallPlan,
                                   @RequestParam boolean language,
                                   @RequestParam("topImage") MultipartFile file,
                                   @RequestParam("image1") MultipartFile file1,
                                   @RequestParam("image2") MultipartFile file2,
                                   @RequestParam("image3") MultipartFile file3,
                                   @RequestParam("image4") MultipartFile file4,
                                   @RequestParam("image5") MultipartFile file5,
                                   @RequestParam String seoUrl,
                                   @RequestParam String seoTitle,
                                   @RequestParam String seoKeywords,
                                   @RequestParam String seoDescription,
                                   @RequestParam String localDate) throws IOException {
                adminCinemaAndHallService.saveHallData(id, hallNumber, description, fileHallPlan, language, file, file1, file2, file3, file4, file5, seoUrl, seoTitle, seoKeywords, seoDescription, localDate);
                return "redirect:/admin-cinema-card-options/{id}";
    }


    //Удаление выбранного зала текущего кинотеатра
    @PostMapping("/admin-cinema-card-options/{id_cinema}/{id_hall}/remove")
    public String hallDelete(@PathVariable(value = "id_cinema") long idCinema, @PathVariable(value = "id_hall") long idHall){
        if (!hallRepository.existsById(idHall)) {
            return "redirect:/admin-cinema-card-options/{id_cinema}";}
        Cinema cinema = cinemaRepository.findById(idCinema).orElseThrow();
        Hall hall = hallRepository.findById(idHall).orElseThrow();
        hallRepository.delete(hall);
        return "redirect:/admin-cinema-card-options/{id_cinema}";
    }

   //Редактирование зала
   @GetMapping("/admin-hall-card-edit/{id_cinema}/{id_hall}")
   public String hallCartEdit(@PathVariable(value = "id_cinema") long idCinema, @PathVariable(value = "id_hall") long idHall, Model model) {
       if (!cinemaRepository.existsById(idCinema)) {
           return "redirect:/admin-cinema-card-options/{id_cinema}";}
       Hall hall = hallRepository.findById(idHall).orElseThrow();
       model.addAttribute("halls", hall);
       return "/Admin/CinemasAndHalls/admin-hall-card-edit";
   }


   //Сохранение изменений редактирования зала
   @PostMapping("/admin-hall-card-edit/{id_cinema}/{id_hall}")
   public String hallCardEditPost(@PathVariable(value = "id_cinema") long idCinema,
                                  @PathVariable(value = "id_hall") long idHall,
                                  @RequestParam String hallNumber,
                                  @RequestParam String description,
                                  @RequestParam("hallPlan") MultipartFile fileHallPlan,
                                  @RequestParam boolean language,
                                  @RequestParam("topImage") MultipartFile file,
                                  @RequestParam("image1") MultipartFile file1,
                                  @RequestParam("image2") MultipartFile file2,
                                  @RequestParam("image3") MultipartFile file3,
                                  @RequestParam("image4") MultipartFile file4,
                                  @RequestParam("image5") MultipartFile file5,
                                  @RequestParam String seoUrl,
                                  @RequestParam String seoTitle,
                                  @RequestParam String seoKeywords,
                                  @RequestParam String seoDescription,
                                  @RequestParam String localDate) throws IOException {
       adminCinemaAndHallService.saveHallData(idCinema, idHall, hallNumber, description, fileHallPlan, language, file, file1, file2, file3, file4, file5, seoUrl, seoTitle, seoKeywords, seoDescription, localDate);
       return "redirect:/admin-cinema-card-options/{id_cinema}";
   }
}
