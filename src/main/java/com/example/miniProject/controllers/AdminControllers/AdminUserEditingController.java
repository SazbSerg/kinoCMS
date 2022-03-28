package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.User;
import com.example.miniProject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Date;

@Controller
public class AdminUserEditingController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin-user-editing")
    public String users() {
        return "/Admin/Users/admin-user-editing";
    }

    @PostMapping("/admin-user-editing")
        public String userPostAdd(@RequestParam String name, @RequestParam String surname,
                @RequestParam String nickname, @RequestParam String eMail,
                @RequestParam String adress, @RequestParam String password,
                @RequestParam String cardNumber, @RequestParam boolean language,
                @RequestParam boolean gender, @RequestParam String phoneNumber,
                @RequestParam Date date, @RequestParam String city, @RequestParam String localDate, @RequestParam boolean checkForMale){
            User user = new User(name, surname, nickname, eMail, adress, password, cardNumber, language, gender, phoneNumber,
                    date, city, localDate, checkForMale);
            userRepository.save(user);
            return "redirect:/admin-users";
        }
}



