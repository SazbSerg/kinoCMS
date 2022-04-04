package com.example.miniProject.controllers.UserPagesControllers;
import com.example.miniProject.models.*;
import com.example.miniProject.repo.AdRepository;
import com.example.miniProject.repo.AdminPagesNewPageRepository;
import com.example.miniProject.repo.BackgroundBannerRepository;
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
public class SomeNewPageController {
    @Autowired
    private BackgroundBannerRepository backgroundBannerRepository;

    @Autowired
    MainPageRepository mainPageRepository;

    @Autowired
    AdminPagesNewPageRepository adminPagesNewPageRepository;

    @GetMapping("/some-new-page/{id}")
    public String adUserGet(@PathVariable(value = "id") long id, Model model) {
        if (!adminPagesNewPageRepository.existsById(id)) {
            return "redirect: /main-user-page";}
        Optional<AdminPagesNewPage> adminPagesNewPage = adminPagesNewPageRepository.findById(id);
        ArrayList<AdminPagesNewPage> res = new ArrayList<>();
        adminPagesNewPage.ifPresent(res :: add);
        model.addAttribute("adminPagesNewPages", res);

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
        return "/Main/AboutCinema/some-new-page";
    }

    @GetMapping("/some-new-page/main-user-page")
    public String someNewPageRedirectToMainUserPage(){
        return "redirect:/main-user-page";
    }

    @GetMapping("/some-new-page/about-cinema")
    public String someNewPageRedirectToAboutCinema(){
        return "redirect:/about-cinema";
    }

    @GetMapping("/some-new-page/client-section")
    public String someNewPageRedirectToClientSection(){
        return "redirect:/client-section";
    }

    @GetMapping("/some-new-page/poster")
    public String someNewPageRedirectToPoster(){
        return "redirect:/poster";
    }

    @GetMapping("/some-new-page/timetable")
    public String someNewPageRedirectToTimetable(){
        return "redirect:/timetable";
    }

    @GetMapping("/some-new-page/soon")
    public String someNewPageRedirectToSoon(){
        return "redirect:/soon";
    }

    @GetMapping("/some-new-page/cinemas")
    public String someNewPageRedirectToCinemas(){
        return "redirect:/cinemas";
    }

    @GetMapping("/some-new-page/stock")
    public String someNewPageRedirectToStock(){
        return "redirect:/stock";
    }

    @GetMapping("/some-new-page/news")
    public String someNewPageRedirectToNews(){
        return "redirect:/news";
    }

    @GetMapping("/some-new-page/ad")
    public String someNewPageRedirectToAd(){
        return "redirect:/ad";
    }

    @GetMapping("/some-new-page/cafe-bar")
    public String someNewPageRedirectToCafeBar(){
        return "redirect:/cafe-bar";
    }

    @GetMapping("/some-new-page/contacts")
    public String someNewPageRedirectToContacts(){
        return "redirect:/contacts";
    }

    @GetMapping("/some-new-page/vip-hall")
    public String someNewPageUserSideFromSomeNewPage(){
        return "redirect:/vip-hall";
    }

    @GetMapping("/some-new-page/mobile-apps")
    public String someNewPageFromSomeNewPage(){
        return "redirect:/mobile-apps";
    }
}
