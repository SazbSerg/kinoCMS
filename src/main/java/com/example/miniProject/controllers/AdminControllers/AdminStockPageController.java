package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.Stock;
import com.example.miniProject.repo.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Date;

@Controller
public class AdminStockPageController {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping("/admin-stock-page")
    public String stockPage() {
        return "/Admin/Stocks/admin-stock-page";
    }

    @PostMapping("/admin-stock-page")
    public String newsPostAdd(@RequestParam String title, @RequestParam String description, @RequestParam Date publicDate,
                              @RequestParam boolean language, @RequestParam boolean status,
                              @RequestParam String mainImage, @RequestParam String image1, @RequestParam String image2,
                              @RequestParam String image3, @RequestParam String image4, @RequestParam String image5,
                              @RequestParam String videoLink, @RequestParam String seoUrl, @RequestParam String seoTitle,
                              @RequestParam String seoKeywords, @RequestParam String seoDescription){
        Stock stock = new Stock(title, description, publicDate, language, status, mainImage, image1, image2, image3, image4, image5,
                videoLink, seoUrl, seoTitle, seoKeywords, seoDescription);
        stockRepository.save(stock);
        return "redirect:/admin-stocks";
    }
}
