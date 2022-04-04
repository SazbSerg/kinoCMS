package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.SmsModel;
import com.example.miniProject.models.User;
import com.example.miniProject.repo.SMSRepository;
import com.example.miniProject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AdminMailingUserChoiceController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    SMSRepository smsRepository;


    @GetMapping("/admin-mailing-user-choice")
    public String getMailingUser(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "/Admin/Mailing/admin-mailing-user-choice";
    }


    @PostMapping("/admin-mailing-user-choice")
    public String postMailUserChoice() {

        return "redirect:/admin-mailing";
    }


    @RequestMapping(value="/admin-mailing-user-choice", method= RequestMethod.POST, produces = "application/json", consumes="application/json")
    @ResponseBody
    public void postTestRequest(@RequestBody Long json) {
        User user = userRepository.findById(json).orElseThrow();
        if (user.isCheckForMail()){
        user.setCheckForMail(false);
        } else {
        user.setCheckForMail(true);
        }
        userRepository.save(user);
    }
}









//if (choiceUserToSend){
//Iterable<User> users = userRepository.findAll();
// Iterable<SmsModel> smsModel = smsRepository.findAll();
// List<SmsModel> smsModels = smsRepository.findAll();
//String textForSending = smsModels.get(0).getSms();
// System.out.println("Начинаю рассылку для выбранных пользователей...");
// System.out.println(textForSending);
//  for(User selectedUsers: users){
//   selectedUsers.setCheckForMail(choiceUserToSend);
//  selectedUsers.isCheckForMail(choiceUserToSend);
//   if (selectedUsers.isCheckForMail()){
//System.out.println("Ваше сообщение: " + textForSending + " отправлено выбранным пользователям - " + selectedUsers.getPhoneNumber());
//       System.out.println(selectedUsers.isCheckForMail());
//  }
// }
//   System.out.println("Рассылка сообщений для ВЫБРАННЫХ пользователей выполнена успешно!");
//  smsRepository.deleteAll();
//  return "/Admin/Mailing/admin-mailing";

// if (choiceUserToSend) {
//     Iterable<User> users = userRepository.findAll();
//     System.out.println(users.toString());
// }