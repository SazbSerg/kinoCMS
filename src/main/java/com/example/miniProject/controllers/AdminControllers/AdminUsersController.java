package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.User;
import com.example.miniProject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminUsersController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin-users")
    public String userMain(Model model) {
        Iterable <User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "/Admin/Users/admin-users";
    }

    @PostMapping("/admin-users/{id}/remove")
    public String userPostDelete(@PathVariable(value = "id") long id){
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
        return "redirect:/admin-users";
    }
}

