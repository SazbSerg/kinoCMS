package com.example.miniProject.controllers.AdminControllers;

import com.example.miniProject.models.CafeBar;
import com.example.miniProject.models.VipHall;
import com.example.miniProject.repo.VipHallRepositiry;
import com.example.miniProject.services.adminVipHallServices.AdminVipHallService;
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
import java.util.Optional;

@Controller
public class AdminVipHallEditController {

    @Autowired
    private VipHallRepositiry vipHallRepositiry;

    @Autowired
    private AdminVipHallService adminVipHallService;

    @GetMapping("/admin-vip-hall-edit/{id}")
    public String getVipHallEdit(@PathVariable(value = "id") long id, Model model) {
        if (!vipHallRepositiry.existsById(id)) {
            return "redirect: /admin-pages";}
        Optional<VipHall> vipHall = vipHallRepositiry.findById(id);
        ArrayList<VipHall> res = new ArrayList<>();
        vipHall.ifPresent(res :: add);
        model.addAttribute("vipHalls", res);
        return "/Admin/Pages/admin-vip-hall-edit";
    }

    @PostMapping("/admin-vip-hall-edit/{id}")
    public String postVipHallEdit(@PathVariable(value = "id") long id,
                                  @RequestParam String title,
                                  @RequestParam String description,
                                  @RequestParam String publicDate,
                                  @RequestParam boolean language,
                                  @RequestParam boolean status,
                                  @RequestParam("mainImage") MultipartFile file,
                                  @RequestParam("image1") MultipartFile file1,
                                  @RequestParam("image2") MultipartFile file2,
                                  @RequestParam("image3") MultipartFile file3,
                                  @RequestParam("image4") MultipartFile file4,
                                  @RequestParam("image5") MultipartFile file5,
                                  @RequestParam String seoUrl,
                                  @RequestParam String seoTitle,
                                  @RequestParam String seoKeywords,
                                  @RequestParam String seoDescription) throws IOException {
        adminVipHallService.saveVipHallData(id, title, description, publicDate, language, status, file, file1, file2, file3, file4, file5, seoUrl, seoTitle, seoKeywords, seoDescription);
        return "redirect:/admin-pages";
    }
}
