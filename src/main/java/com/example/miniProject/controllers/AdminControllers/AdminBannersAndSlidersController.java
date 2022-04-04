package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.*;
import com.example.miniProject.repo.*;
import com.example.miniProject.services.adminBannersSliders.AdminBackgroundBannerService;
import com.example.miniProject.services.adminBannersSliders.AdminBannersSlidersService;
import com.example.miniProject.services.adminBannersSliders.AdminMainPageNewsStocksBannersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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

    @Value("${upload.path.main.page.top.banners}")
    private String uploadPath;

    @Value("${upload.path.background.banner}")
    private String uploadPath2;

    @Value("${upload.path.main.page.news.stocks.banners}")
    private String uploadPath3;

    @Autowired
    private AdminBannersSlidersService adminBannersSlidersService;

    @Autowired
    private AdminBackgroundBannerService adminBackgroundBannerService;

    @Autowired
    private AdminMainPageNewsStocksBannersService adminMainPageNewsStocksBannersService;

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


    @PostMapping("/admin-banners/background-banners/{id}")
    public String postBackgroundBannersList(@PathVariable(value = "id") long id,
                                            @RequestParam("backgroundBanner") MultipartFile backgroundBanner,
                                            @RequestParam boolean statusBackgroundBanner) throws IOException {
        if ((backgroundBanner != null && !backgroundBanner.getOriginalFilename().isEmpty())) {
            File uploadDir2 = new File(uploadPath2);

            if (!uploadDir2.exists()) {
                uploadDir2.mkdir();
            }
        }

        BackgroundBanner newBackgroundBanner = backgroundBannerRepository.findById(id).orElseThrow();
        if (statusBackgroundBanner) {
            newBackgroundBanner.setStatusBackgroundBanner(statusBackgroundBanner);
            adminBackgroundBannerService.saveFile(newBackgroundBanner, backgroundBanner);
        } else {
            newBackgroundBanner.setBackgroundBanner("");
            newBackgroundBanner.setStatusBackgroundBanner(statusBackgroundBanner);
        }
        backgroundBannerRepository.save(newBackgroundBanner);
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


    @PostMapping(value = "/admin-banners-and-sliders", params = {"mainNewStockBannerUrl", "mainNewStockBannerText" })
    //@PostMapping("/admin-banners-and-sliders")
    public String mainNewsStocksBannerFromModalPostAdd(@RequestParam("mainNewStockBannerImage") MultipartFile mainNewStockBannerImage,
                                                       @RequestParam String mainNewStockBannerUrl,
                                                       @RequestParam String mainNewStockBannerText) throws IOException {
        if ((mainNewStockBannerImage != null && !mainNewStockBannerImage.getOriginalFilename().isEmpty())) {
            File uploadDir3 = new File(uploadPath3);

            if (!uploadDir3.exists()) {
                uploadDir3.mkdir();
            }
        }
        MainNewsStocksBanners mainNewsStocksBanners = new MainNewsStocksBanners();
        mainNewsStocksBanners.setMainNewStockBannerText(mainNewStockBannerText);
        mainNewsStocksBanners.setMainNewStockBannerUrl(mainNewStockBannerUrl);
        adminMainPageNewsStocksBannersService.saveFile(mainNewsStocksBanners, mainNewStockBannerImage);
        mainNewsStocksBannersRepository.save(mainNewsStocksBanners);
        return "redirect:/admin-banners-and-sliders";
    }

  //  @PostMapping(value = "/admin-banners-and-sliders", params = {"bannerImage", "mainNewStockBannerImage" })
  //  public String defaultMainNewsStocksBannerFromModalPostAdd( @RequestParam("bannerImage") MultipartFile bannerImage
  //                                                      ) {
  //
  //      return "redirect:/admin-banners-and-sliders";
  //  }



 //  @PostMapping("/admin-banners-and-sliders")
 @PostMapping(value = "/admin-banners-and-sliders", params = { "bannerUrl", "bannerText" })
  public String bannerFromModalPostAdd(@RequestParam("bannerImage") MultipartFile bannerImage,
          @RequestParam String bannerUrl,
          @RequestParam String bannerText) throws IOException {

      if ((bannerImage != null && !bannerImage.getOriginalFilename().isEmpty())) {
          File uploadDir = new File(uploadPath);

          if (!uploadDir.exists()) {
              uploadDir.mkdir();
          }
      }

      BannersSliders bannersSliders = new BannersSliders();
      bannersSliders.setBannerUrl(bannerUrl);
      bannersSliders.setBannerText(bannerText);
      adminBannersSlidersService.saveFile(bannersSliders, bannerImage);
      bannersSlidersRepository.save(bannersSliders);
      return "redirect:/admin-banners-and-sliders";
  }



 //   @PostMapping("/admin-banners/main-news-stocks-banners/{id}")
 //   public String mainNewsStocksBannerFromModalPostAdd(@PathVariable(value = "id") long id,
 //                                                      @RequestParam("mainNewStockBannerImage") MultipartFile mainNewStockBannerImage,
 //                                                      @RequestParam String mainNewStockBannerUrl,
 //                                                      @RequestParam String mainNewStockBannerText) throws IOException {
 //       if ((mainNewStockBannerImage != null && !mainNewStockBannerImage.getOriginalFilename().isEmpty())) {
 //           File uploadDir3 = new File(uploadPath3);
 //
 //           if (!uploadDir3.exists()) {
 //               uploadDir3.mkdir();
 //           }
 //       }
 //       MainNewsStocksBanners mainNewsStocksBanners = mainNewsStocksBannersRepository.findById(id).orElseThrow();
 //       //MainNewsStocksBanners mainNewsStocksBanners = new MainNewsStocksBanners();
 //       //mainNewsStocksBanners.setId(id);
 //       mainNewsStocksBanners.setMainNewStockBannerText(mainNewStockBannerText);
 //       mainNewsStocksBanners.setMainNewStockBannerUrl(mainNewStockBannerUrl);
 //       adminMainPageNewsStocksBannersService.saveFile(mainNewsStocksBanners, mainNewStockBannerImage);
 //       mainNewsStocksBannersRepository.save(mainNewsStocksBanners);
 //       return "redirect:/admin-banners-and-sliders";
 //   }



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
}