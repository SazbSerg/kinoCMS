package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.Stock;
import com.example.miniProject.repo.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AdminStockPageEditController {

    @Autowired
    private StockRepository stockRepository;

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
    public String stockPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String description,
                                 @RequestParam Date publicDate,
                                 @RequestParam boolean language, @RequestParam boolean status,
                                 @RequestParam String mainImage, @RequestParam String image1, @RequestParam String image2,
                                 @RequestParam String image3, @RequestParam String image4, @RequestParam String image5,
                                 @RequestParam String videoLink, @RequestParam String seoUrl, @RequestParam String seoTitle,
                                 @RequestParam String seoKeywords, @RequestParam String seoDescription){
        Stock stock = stockRepository.findById(id).orElseThrow();
        stock.setTitle(title);
        stock.setDescription(description);
        stock.setPublicDate(publicDate);
        stock.setLanguage(language);
        stock.setStatus(status);
        stock.setMainImage(mainImage);
        stock.setImage1(image1);
        stock.setImage2(image2);
        stock.setImage3(image3);
        stock.setImage4(image4);
        stock.setImage5(image5);
        stock.setVideoLink(videoLink);
        stock.setSeoUrl(seoUrl);
        stock.setSeoTitle(seoTitle);
        stock.setSeoKeywords(seoKeywords);
        stock.setSeoDescription(seoDescription);
        stockRepository.save(stock);
        return "redirect:/admin-stocks";
    }
}