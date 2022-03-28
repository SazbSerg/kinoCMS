package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.Stock;
import com.example.miniProject.repo.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminStocksController {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping("/admin-stocks")
    public String stockPage(Model model) {
        Iterable <Stock> stocks = stockRepository.findAll();
        model.addAttribute("stocks", stocks);
        return "/Admin/Stocks/admin-stocks";
    }

    @PostMapping("/admin-stocks/{id}/remove")
    public String stockPostDelete(@PathVariable(value = "id") long id, Model model){
        Stock stock = stockRepository.findById(id).orElseThrow();
        stockRepository.delete(stock);
        return "redirect:/admin-stocks";
    }
}
