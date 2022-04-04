package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.News;
import com.example.miniProject.repo.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminNewsController {

    @Autowired
    private NewsRepository newsRepository;

    @GetMapping("/admin-news")
    public String newsPage(Model model) {
        Iterable <News> news = newsRepository.findAll();
        model.addAttribute("news", news);
        return "/Admin/News/admin-news";
    }

    @PostMapping("/admin-news/{id}/remove")
    public String newsPostDelete(@PathVariable(value = "id") long id, Model model){
        News news = newsRepository.findById(id).orElseThrow();
        newsRepository.delete(news);
        return "redirect:/admin-news";
    }
}
