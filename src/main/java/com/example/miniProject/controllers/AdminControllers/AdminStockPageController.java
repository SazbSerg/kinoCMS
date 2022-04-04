package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.Stock;
import com.example.miniProject.repo.StockRepository;
import com.example.miniProject.services.adminStocksServices.AdminStocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;

@Controller
public class AdminStockPageController {

    @Autowired
    private AdminStocksService adminStocksService;

    @GetMapping("/admin-stock-page")
    public String getStockCreatingPage() {
        return "/Admin/Stocks/admin-stock-page";
    }

    @PostMapping("/admin-stock-page")
    public String postNewStock(@RequestParam String title,
                              @RequestParam String description,
                              @RequestParam Date publicDate,
                              @RequestParam boolean language,
                              @RequestParam boolean status,
                              @RequestParam("mainImage") MultipartFile file,
                              @RequestParam("image1") MultipartFile file1,
                              @RequestParam("image2") MultipartFile file2,
                              @RequestParam("image3") MultipartFile file3,
                              @RequestParam("image4") MultipartFile file4,
                              @RequestParam("image5") MultipartFile file5,
                              @RequestParam String videoLink,
                              @RequestParam String seoUrl,
                              @RequestParam String seoTitle,
                              @RequestParam String seoKeywords,
                              @RequestParam String seoDescription) throws IOException {
        adminStocksService.saveStocksData(title, description, publicDate, language, status, file, file1, file2, file3, file4, file5, videoLink, seoUrl, seoTitle, seoKeywords, seoDescription);
        return "redirect:/admin-stocks";
    }
}
