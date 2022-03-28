package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.User;
import com.example.miniProject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminStatisticsController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin-statistics")
    public String getStatistics(Model model) {
        model.addAttribute("usersCount", userRepository.count());
        Iterable<User> users = userRepository.findAll();
        int countMen = 0;
        int countWomen = 0;

        for (User us: users){
            if (us.isGender()){
                countMen++;
            } else {
                countWomen++;
            }
        }

        model.addAttribute("countMen", countMen);
        model.addAttribute("countWomen", countWomen);
        return "/Admin/admin-statistics";
    }
}
