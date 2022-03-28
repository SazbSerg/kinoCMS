package com.example.miniProject.controllers.AdminControllers;

import com.example.miniProject.models.User;
import com.example.miniProject.repo.UserRepository;
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
public class AdminUserChoiceController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin-user-choice/{id}")
    public String userEdit(@PathVariable(value = "id") long id, Model model) {
        if (!userRepository.existsById(id)) {
            return "redirect: /admin-users";}
        Optional<User> users = userRepository.findById(id);
        ArrayList<User> res = new ArrayList<>();
        users.ifPresent(res :: add);
        model.addAttribute("users", res);
        return "/Admin/Users/admin-user-choice";
    }

    @PostMapping("/admin-user-choice/{id}")
    public String userPostUpdate(@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String surname,
                                 @RequestParam String nickname, @RequestParam String eMail,
                                 @RequestParam String adress, @RequestParam String password,
                                 @RequestParam String cardNumber, @RequestParam boolean language,
                                 @RequestParam boolean gender, @RequestParam String phoneNumber,
                                 @RequestParam Date date, @RequestParam String city, @RequestParam String localDate,
                                 @RequestParam boolean checkForMale){
        User user = userRepository.findById(id).orElseThrow();
        user.setName(name);
        user.setSurname(surname);
        user.setNickname(nickname);
        user.seteMail(eMail);
        user.setAdress(adress);
        user.setPassword(password);
        user.setCardNumber(cardNumber);
        user.setLanguage(language);
        user.setGender(gender);
        user.setPhoneNumber(phoneNumber);
        user.setDate(date);
        user.setCity(city);
        user.setLocalDate(localDate);
        user.setCheckForMail(checkForMale);
        userRepository.save(user);
        return "redirect:/admin-users";
    }
}
