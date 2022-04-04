package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.Stock;
import com.example.miniProject.repo.StockRepository;
import com.example.miniProject.services.adminStocksServices.AdminStocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AdminStockPageEditController {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private AdminStocksService adminStocksService;

    @GetMapping("/admin-stock-page-edit/{id}")
    public String stockEdit(@PathVariable(value = "id") long id, Model model) {
        if (!stockRepository.existsById(id)) {
            return "redirect: /admin-stocks";}
        Optional<Stock> stocks = stockRepository.findById(id);
        ArrayList<Stock> res = new ArrayList<>();
        stocks.ifPresent(res :: add);
        model.addAttribute("stocks", res);
        return "/Admin/Stocks/admin-stock-page-edit";
    }

    @PostMapping("/admin-stock-page-edit/{id}")
    public String stockPostUpdate(@PathVariable(value = "id") long id,
                                  @RequestParam String title,
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
        adminStocksService.saveStocksData(id, title, description, publicDate, language, status, file, file1, file2, file3, file4, file5, videoLink, seoUrl, seoTitle, seoKeywords, seoDescription);
        return "redirect:/admin-stocks";
    }
}