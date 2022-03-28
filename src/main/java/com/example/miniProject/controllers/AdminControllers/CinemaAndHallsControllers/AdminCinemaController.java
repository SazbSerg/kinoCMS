package com.example.miniProject.controllers.AdminControllers.CinemaAndHallsControllers;

import com.example.miniProject.models.CinemaAndHallModels.Cinema;
import com.example.miniProject.models.CinemaAndHallModels.Hall;
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
import java.util.Optional;

@Controller
public class AdminCinemaController {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private HallRepository hallRepository;


    //Обработка страницы показа списка кинотеатров
    @GetMapping("/admin-cinema-list")
    public String getListOfCinema(Model model) {
        Iterable <Cinema> cinemas = cinemaRepository.findAll();
        model.addAttribute("cinema", cinemas);
        return "/Admin/CinemasAndHalls/admin-cinema-list";
    }



    //Обработка ссылки перехода на страницу создания кинотеатра
    @GetMapping("/admin-cinema-create")
    public String createCinemaGet() {
        return "/Admin/CinemasAndHalls/admin-cinema-create";
    }


    //Сохранение нового созданного кинотеатра
    @PostMapping("/admin-cinema-create")
    public String createCinemaPost(@RequestParam String cinemaTitle,
                                    @RequestParam boolean language,
                                    @RequestParam String description,
                                    @RequestParam String conditions,
                                    @RequestParam String hallPlan,
                                    @RequestParam String topBanner,
                                    @RequestParam String image1,
                                    @RequestParam String image2,
                                    @RequestParam String image3,
                                    @RequestParam String image4,
                                    @RequestParam String image5,
                                    @RequestParam String seoUrl,
                                    @RequestParam String seoTitle,
                                    @RequestParam String seoKeywords,
                                    @RequestParam String seoDescription) {
        Cinema cinema = new Cinema(cinemaTitle, language, description, conditions,
                hallPlan, topBanner, image1, image2, image3,
                image4, image5, seoUrl, seoTitle,
                seoKeywords, seoDescription);
        cinemaRepository.save(cinema);

        return "redirect:/admin-cinema-list";
    }

    //Удаление кинотеатра со списка кинотеатров
    @PostMapping("/admin-cinema-list/{id}/remove")
    public String removeCinema(@PathVariable(value = "id") long id){
        Cinema cinema = cinemaRepository.findById(id).orElseThrow();
        cinemaRepository.delete(cinema);
        return "redirect:/admin-cinema-list";
    }

    //Переход к редактированию кинотеатров с возможностью создания залов
    @GetMapping("/admin-cinema-card-options/{id}")
    public String cinemaCardEditGet(@PathVariable(value = "id") long id, Model model) {
        if (!cinemaRepository.existsById(id)) {
            return "redirect:/admin-cinema-list";}

        //Отображаем текущую модель кинотеатра со значениями в полях из базы
        Optional<Cinema> cinemas = cinemaRepository.findById(id);
        ArrayList<Cinema> res = new ArrayList<>();
        cinemas.ifPresent(res :: add);
        model.addAttribute("cinema", res);

        //Отображаем все залы текущего кинотеатра
        Iterable <Hall> halls = hallRepository.findAll();
        model.addAttribute("halls", halls);
        return "/Admin/CinemasAndHalls/admin-cinema-card-options";
    }



    //Сохранение результаов редактирования кинотеатра и переход на страницу списка кинотеатров
    @PostMapping("/admin-cinema-card-options/{id}")
    public String cinemaCardPost(@PathVariable(value = "id") long id, @RequestParam String cinemaTitle,
                                 @RequestParam boolean language,
                                 @RequestParam String description,
                                 @RequestParam String conditions,
                                 @RequestParam String hallPlan,
                                 @RequestParam String topBanner,
                                 @RequestParam String image1,
                                 @RequestParam String image2,
                                 @RequestParam String image3,
                                 @RequestParam String image4,
                                 @RequestParam String image5,
                                 @RequestParam String seoUrl,
                                 @RequestParam String seoTitle,
                                 @RequestParam String seoKeywords,
                                 @RequestParam String seoDescription){
        Cinema cinema = cinemaRepository.findById(id).orElseThrow();
        cinema.setCinemaTitle(cinemaTitle);
        cinema.setLanguage(language);
        cinema.setDescription(description);
        cinema.setConditions(conditions);
        cinema.setHallPlan(hallPlan);
        cinema.setTopBanner(topBanner);
        cinema.setImage1(image1);
        cinema.setImage2(image2);
        cinema.setImage3(image3);
        cinema.setImage4(image4);
        cinema.setImage5(image5);
        cinema.setSeoUrl(seoUrl);
        cinema.setSeoTitle(seoTitle);
        cinema.setSeoKeywords(seoKeywords);
        cinema.setSeoDescription(seoDescription);
        cinemaRepository.save(cinema);
        return "redirect:/admin-cinema-list";
    }


//  @GetMapping("/admin-hall-card/{id}")
//  public String hallCardCreate(@PathVariable(value = "id") long id, Model model) {
//      if (!cinemaRepository.existsById(id)) {
//          return "redirect: /parents-list";}
//      Optional<Hall> halls = hallRepository.findById(id);
//      Optional<Cinema> cinemas = cinemaRepository.findById(id);
//      ArrayList<Hall> res = new ArrayList<>();
//      ArrayList<Cinema> res2 = new ArrayList<>();
//      halls.ifPresent(res :: add);
//      cinemas.ifPresent(res2 :: add);
//      model.addAttribute("halls", res);
//      model.addAttribute("cinemas", res2);
//      return "/Admin/CinemasAndHalls/admin-hall-card";
//  }
}
