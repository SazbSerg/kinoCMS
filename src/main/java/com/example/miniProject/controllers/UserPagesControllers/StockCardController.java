package com.example.miniProject.controllers.UserPagesControllers;
import com.example.miniProject.models.AdminPagesNewPage;
import com.example.miniProject.models.BackgroundBanner;
import com.example.miniProject.models.MainPage;
import com.example.miniProject.models.Stock;
import com.example.miniProject.repo.AdminPagesNewPageRepository;
import com.example.miniProject.repo.BackgroundBannerRepository;
import com.example.miniProject.repo.MainPageRepository;
import com.example.miniProject.repo.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class StockCardController {

    @Autowired
    private BackgroundBannerRepository backgroundBannerRepository;

    @Autowired
    MainPageRepository mainPageRepository;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    AdminPagesNewPageRepository adminPagesNewPageRepository;

    @GetMapping("/stock-card/{id}")
    public String stockCardUserGet(@PathVariable(value = "id") long id, Model model) {
        if (!stockRepository.existsById(id)) {
            return "redirect: /stock";}
        Optional<Stock> stock = stockRepository.findById(id);
        ArrayList<Stock> res = new ArrayList<>();
        stock.ifPresent(res :: add);
        model.addAttribute("stock", res);

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
        return "/Main/Stock/stock-card";
    }

    @GetMapping("/stock-card/main-user-page")
    public String hallCardRedirectToMainUserPage(){
        return "redirect:/main-user-page";
    }

    @GetMapping("/stock-card/poster")
    public String hallCardRedirectToPoster(){
        return "redirect:/poster";
    }

    @GetMapping("/stock-card/timetable")
    public String hallCardRedirectToTimetable(){
        return "redirect:/timetable";
    }

    @GetMapping("/stock-card/soon")
    public String hallCardRedirectToSoon(){
        return "redirect:/soon";
    }

    @GetMapping("/stock-card/cinemas")
    public String hallCardRedirectToCinemas(){
        return "redirect:/cinemas";
    }

    @GetMapping("/stock-card/stock")
    public String hallCardRedirectToStock(){
        return "redirect:/stock";
    }

    @GetMapping("/stock-card/news")
    public String hallCardRedirectToNews(){
        return "redirect:/news";
    }

    @GetMapping("/stock-card/ad")
    public String hallCardRedirectToAd(){
        return "redirect:/ad";
    }

    @GetMapping("/stock-card/cafe-bar")
    public String hallCardRedirectToCafeBar(){
        return "redirect:/cafe-bar";
    }

    @GetMapping("/stock-card/contacts")
    public String hallCardRedirectToContacts(){
        return "redirect:/contacts";
    }

    @GetMapping("/stock-card/mobile-apps")
    public String mobileAppsFromStockCard(){
        return "redirect:/mobile-apps";
    }
}
