package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.SmsModel;
import com.example.miniProject.models.User;
import com.example.miniProject.repo.SMSRepository;
import com.example.miniProject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class AdminMailingUserChoiceController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    SMSRepository smsRepository;

    @GetMapping("/admin-mailing-user-choice")
    public String getMailingUser(Model model) {
        Iterable <User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "/Admin/Mailing/admin-mailing-user-choice";
    }

    @PostMapping("/admin-mailing-user-choice")
    public String postMailUserChoice(@RequestParam boolean choiceUserToSend){
        if (!choiceUserToSend){
            return  "/Admin/Mailing/admin-mailing";
        }
        Iterable<User> users = userRepository.findAll();
        // Iterable<SmsModel> smsModel = smsRepository.findAll();
        List<SmsModel> smsModels = smsRepository.findAll();
        String textForSending = smsModels.get(0).getSms();
        System.out.println("Начинаю рассылку для выбранных пользователей...");
        System.out.println(textForSending);
        for(User selectedUsers: users){
            selectedUsers.setCheckForMail(choiceUserToSend);
          //  selectedUsers.isCheckForMail(choiceUserToSend);
            if (selectedUsers.isCheckForMail()){
                //System.out.println("Ваше сообщение: " + textForSending + " отправлено выбранным пользователям - " + selectedUsers.getPhoneNumber());
                System.out.println(selectedUsers.isCheckForMail());
            }
        }
        System.out.println("Рассылка сообщений для ВЫБРАННЫХ пользователей выполнена успешно!");
        smsRepository.deleteAll();
        return "/Admin/Mailing/admin-mailing";
    }
}
