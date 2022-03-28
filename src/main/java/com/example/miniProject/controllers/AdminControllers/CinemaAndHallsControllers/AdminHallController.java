package com.example.miniProject.controllers.AdminControllers.CinemaAndHallsControllers;

import com.example.miniProject.models.CinemaAndHallModels.Cinema;
import com.example.miniProject.models.CinemaAndHallModels.Hall;
import com.example.miniProject.models.TestPackage.ChildClass;
import com.example.miniProject.models.TestPackage.ParentClass;
import com.example.miniProject.repo.CinemaAndHallRepos.CinemaRepository;
import com.example.miniProject.repo.CinemaAndHallRepos.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminHallController {
    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private HallRepository hallRepository;


    //Переход на страницу создания нового зала с привязкой к id текущего кинотеатра
    @GetMapping("/admin-hall-card/{id}")
    public String getHallCardPage(@PathVariable(value = "id") long id) {
        return "/Admin/CinemasAndHalls/admin-hall-card";
    }


    //Сохранение изменеий созданного зала с переходом на страницу текущего кинотеатра по его id
    @PostMapping("/admin-hall-card/{id}")
    public String postHallCardPage(@PathVariable(value = "id") long id, @RequestParam String hallNumber, @RequestParam String description, @RequestParam String hallPlan,
                              @RequestParam boolean language,
                              @RequestParam String topImage, @RequestParam String image1, @RequestParam String image2,
                              @RequestParam String image3, @RequestParam String image4, @RequestParam String image5,
                              @RequestParam String seoUrl, @RequestParam String seoTitle,
                              @RequestParam String seoKeywords, @RequestParam String seoDescription, @RequestParam String localDate){
        Cinema cinema = cinemaRepository.findById(id).orElseThrow();
        List<Hall> halls = cinema.getHalls();
        halls.add(new Hall(hallNumber, description, hallPlan, language, topImage, image1, image2, image3, image4, image5,
                seoUrl, seoTitle, seoKeywords, seoDescription, localDate));
        cinema.setHalls(halls);
        cinemaRepository.save(cinema);
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
       model.addAttribute("hall", hall);
       return "/Admin/CinemasAndHalls/admin-hall-card-edit";
   }


   //Сохранение изменений редактирования зала
   @PostMapping("/admin-hall-card-edit/{id_cinema}/{id_hall}")
   public String hallCardEditPost(@PathVariable(value = "id_cinema") long idCinema, @PathVariable(value = "id_hall") long idHall,
                                  @RequestParam String hallNumber, @RequestParam String description, @RequestParam String hallPlan,
                                  @RequestParam boolean language,
                                  @RequestParam String topImage, @RequestParam String image1, @RequestParam String image2,
                                  @RequestParam String image3, @RequestParam String image4, @RequestParam String image5,
                                  @RequestParam String seoUrl, @RequestParam String seoTitle,
                                  @RequestParam String seoKeywords, @RequestParam String seoDescription, @RequestParam String localDate){
       Hall hall = hallRepository.findById(idHall).orElseThrow();
       hall.setHallNumber(hallNumber);
       hall.setDescription(description);
       hall.setHallPlan(hallPlan);
       hall.setLanguage(language);
       hall.setTopImage(topImage);
       hall.setImage1(image1);
       hall.setImage2(image2);
       hall.setImage3(image3);
       hall.setImage4(image4);
       hall.setImage5(image5);
       hall.setSeoUrl(seoUrl);
       hall.setSeoTitle(seoTitle);
       hall.setSeoKeywords(seoKeywords);
       hall.setSeoDescription(seoDescription);
       hall.setLocalDate(localDate);
       hallRepository.save(hall);
       return "redirect:/admin-cinema-card-options/{id_cinema}";
   }
}
