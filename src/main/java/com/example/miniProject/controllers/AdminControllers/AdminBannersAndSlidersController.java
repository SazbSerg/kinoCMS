package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.*;
import com.example.miniProject.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminBannersAndSlidersController {

    @Autowired
    private BannersSlidersRepository bannersSlidersRepository;

    @Autowired
    private MainTopBannersOptionsRepository mainTopBannersOptionsRepository;

    @Autowired
    private BackgroundBannerRepository backgroundBannerRepository;

    @Autowired
    private MainNewsStocksBannersRepository mainNewsStocksBannersRepository;

    @Autowired
    private MainNewsStocksBannersOptionsRepository mainNewsStocksBannersOptionsRepository;


  @GetMapping("/admin-banners-and-sliders")
  public String getAllOffBannersAndOptionsMainTopBanners(Model model) {
      Iterable<BannersSliders> bannersSliders = bannersSlidersRepository.findAll();
      Iterable<MainTopBannersOptions> mainTopBannersOptions = mainTopBannersOptionsRepository.findAll();
      Iterable<BackgroundBanner> backgroundBanners = backgroundBannerRepository.findAll();
      Iterable<MainNewsStocksBanners> mainNewsStocksBanners = mainNewsStocksBannersRepository.findAll();
      Iterable<MainNewsStocksBannersOptions> mainNewsStocksBannersOptions = mainNewsStocksBannersOptionsRepository.findAll();
      model.addAttribute("banners", bannersSliders);
      model.addAttribute("mainTopBannersOptions", mainTopBannersOptions);
      model.addAttribute("backgroundBanners", backgroundBanners);
      model.addAttribute("mainNewsStockBanners", mainNewsStocksBanners);
      model.addAttribute("mainNewsStocksBannersOptions", mainNewsStocksBannersOptions);
      return "Admin/Banners/admin-banners-and-sliders";
  }

    @GetMapping("/admin-banners-and-sliders/{id}")
    public String postBannersList(@PathVariable(value = "id") long id,
    @RequestParam String bannerImage,
    @RequestParam String bannerUrl,
    @RequestParam String bannerText){
        BannersSliders bannersSliders = bannersSlidersRepository.findById(id).orElseThrow();
        bannersSliders.setBannerImage(bannerImage);
        bannersSliders.setBannerUrl(bannerUrl);
        bannersSliders.setBannerText(bannerText);
        bannersSlidersRepository.save(bannersSliders);
        return "redirect:/admin-banners-and-sliders";
    }

    @GetMapping("/admin-banners/main-news-stocks-banners/{id}")
    public String postMainNewsStocksBannersList(@PathVariable(value = "id") long id,
    @RequestParam String mainNewStockBannerImage,
    @RequestParam String mainNewStockBannerUrl,
    @RequestParam String mainNewStockBannerText){
        MainNewsStocksBanners mainNewsStocksBanners = mainNewsStocksBannersRepository.findById(id).orElseThrow();
        mainNewsStocksBanners.setMainNewStockBannerImage(mainNewStockBannerImage);
        mainNewsStocksBanners.setMainNewStockBannerUrl(mainNewStockBannerUrl);
        mainNewsStocksBanners.setMainNewStockBannerText(mainNewStockBannerText);
        mainNewsStocksBannersRepository.save(mainNewsStocksBanners);
        return "redirect:/admin-banners-and-sliders";
    }

    @GetMapping("/admin-banners/background-banners/{id}")
    public String postBackgroundBannersList(@PathVariable(value = "id") long id,
    @RequestParam String backgroundBanner,
    @RequestParam boolean statusBackgroundBanner){
        BackgroundBanner newbackgroundBanner = backgroundBannerRepository.findById(id).orElseThrow();
        newbackgroundBanner.setBackgroundBanner(backgroundBanner);
        newbackgroundBanner.setStatusBackgroundBanner(statusBackgroundBanner);
        backgroundBannerRepository.save(newbackgroundBanner);
        return "redirect:/admin-banners-and-sliders";
    }

    @GetMapping("/admin-banners/options/{id}")
    public String returnOptionsOfMainTopBanners(@PathVariable(value = "id") long id,
    @RequestParam String rotationSpeed,
    @RequestParam boolean status){
        if (!mainTopBannersOptionsRepository.existsById(id)) {
            return "Admin/Banners/admin-banners-and-sliders";
        }
        MainTopBannersOptions mainTopBannersOptions = mainTopBannersOptionsRepository.findById(id).orElseThrow();
        mainTopBannersOptions.setRotationSpeed(rotationSpeed);
        mainTopBannersOptions.setStatus(status);
        mainTopBannersOptionsRepository.save(mainTopBannersOptions);
        return "redirect:/admin-banners-and-sliders";
    }

    @GetMapping("/admin-banners/main-news-banners-stocks-options/{id}")
    public String returnOptionsOfMainNewsStocksBanners(@PathVariable(value = "id") long id,
    @RequestParam String rotationSpeedOfMainNewsStocksBanners,
    @RequestParam boolean statusOfMainNewsStocksBanners){
        if (!mainNewsStocksBannersOptionsRepository.existsById(id)) {
            return "Admin/Banners/admin-banners-and-sliders";
        }
        MainNewsStocksBannersOptions mainNewsStocksBannersOptions = mainNewsStocksBannersOptionsRepository.findById(id).orElseThrow();
        mainNewsStocksBannersOptions.setRotationSpeedOfMainNewsStocksBanners(rotationSpeedOfMainNewsStocksBanners);
        mainNewsStocksBannersOptions.setStatusOfMainNewsStocksBanners(statusOfMainNewsStocksBanners);
        mainNewsStocksBannersOptionsRepository.save(mainNewsStocksBannersOptions);
        return "redirect:/admin-banners-and-sliders";
    }

    @PostMapping("/admin-banners-and-sliders")
    public String bannerFromModalPostAdd(@RequestParam String bannerImage,
            @RequestParam String bannerUrl,
            @RequestParam String bannerText)
    {
        BannersSliders bannersSliders = new BannersSliders(bannerImage,
                bannerUrl,
                bannerText);
        bannersSlidersRepository.save(bannersSliders);
        return "redirect:/admin-banners-and-sliders";
    }

    @PostMapping(value = "/admin-banners-and-sliders", params = { "mainNewStockBannerImage", "mainNewStockBannerUrl", "mainNewStockBannerText" })
    public String mainNewsStocksBannerFromModalPostAdd(@RequestParam String mainNewStockBannerImage,
            @RequestParam String mainNewStockBannerUrl,
            @RequestParam String mainNewStockBannerText)
    {
        MainNewsStocksBanners mainNewsStocksBanners = new MainNewsStocksBanners(
                mainNewStockBannerImage,
                mainNewStockBannerUrl,
                mainNewStockBannerText);
        mainNewsStocksBannersRepository.save(mainNewsStocksBanners);
        return "redirect:/admin-banners-and-sliders";
    }

    @PostMapping("/admin-banners-and-sliders/{id}/remove")
    public String bannerPostDelete(@PathVariable(value = "id") long id){
        BannersSliders bannersSliders = bannersSlidersRepository.findById(id).orElseThrow();
        bannersSlidersRepository.delete(bannersSliders);
        return "redirect:/admin-banners-and-sliders";
    }

    @PostMapping("/admin-banners/main-news-stocks-banners/{id}/remove")
    public String mainNewsStocksBannersPostDelete(@PathVariable(value = "id") long id){
        MainNewsStocksBanners mainNewsStocksBanners = mainNewsStocksBannersRepository.findById(id).orElseThrow();
        mainNewsStocksBannersRepository.delete(mainNewsStocksBanners);
        return "redirect:/admin-banners-and-sliders";
    }

    @PostMapping("/admin-banners/background-banners/{id}/remove")
    public String backgroundBannerPostDelete(@PathVariable(value = "id") long id){
        BackgroundBanner backgroundBanner = backgroundBannerRepository.findById(id).orElseThrow();
        boolean backgroundBannerStatusOld = backgroundBanner.isStatusBackgroundBanner();
        BackgroundBanner backgroundBanner1 = new BackgroundBanner(backgroundBannerStatusOld);
        backgroundBannerRepository.save(backgroundBanner1);
        backgroundBannerRepository.delete(backgroundBanner);
        return "redirect:/admin-banners-and-sliders";
    }
}