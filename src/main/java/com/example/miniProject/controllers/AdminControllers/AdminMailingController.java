package com.example.miniProject.controllers.AdminControllers;

import com.example.miniProject.mail.config.MyConstants;
import com.example.miniProject.models.*;
import com.example.miniProject.repo.SMSRepository;
import com.example.miniProject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminMailingController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    public JavaMailSender emailSender;

    @GetMapping("/admin-mailing")
    public String getMail() {
        return "/Admin/Mailing/admin-mailing";
    }

    @PostMapping("/admin-mailing")
    public String postMail(@RequestParam boolean choiceUserToSendEmail,
                           @RequestParam String textToSendEmail){
     //  if (!choiceUserToSendSms){
     //      return  "/Admin/Mailing/admin-mailing";
     //  }
      // Iterable<User> users = userRepository.findAll();
      // System.out.println("Начинаю рассылку для ВСЕХ пользователей.");
      // for(User selectedUsers: users){
      //     System.out.println("Ваше сообщение: " + textToSendSms + " отправлено по номеру телефона - " + selectedUsers.getPhoneNumber());
      // }
      // System.out.println("Рассылка сообщений для ВСЕХ пользователей успешно завершена!");


        Iterable<User> users = userRepository.findAll();
        SimpleMailMessage message = new SimpleMailMessage();
        if (choiceUserToSendEmail){
            System.out.println("Начинаю рассылку для ВСЕХ пользователей.");
       for(User selectedUsers: users){
           message.setTo(selectedUsers.geteMail());
           message.setText(textToSendEmail);
           this.emailSender.send(message);
       }} else {
            System.out.println("Начинаю рассылку для выбранных пользователей");
             for(User selectedUsers2: users){
                 if(selectedUsers2.isCheckForMail()) {
                     message.setTo(selectedUsers2.geteMail());
                     message.setText(textToSendEmail);
                     this.emailSender.send(message);

                     selectedUsers2.setCheckForMail(false);
                     userRepository.save(selectedUsers2);
                 }
             }
         }



        // SimpleMailMessage message = new SimpleMailMessage();
        // message.setTo(MyConstants.FRIEND_EMAIL);
        // message.setSubject("Test Simple Email");
        // message.setText(textToSendEmail);

          // Send Message!
      // this.emailSender.send(message);


        return "/Admin/Mailing/admin-mailing";

    }

 //  @Autowired
 //  SMSRepository smsRepository;
 //
 //  @RequestMapping(value="/admin-mailing", method= RequestMethod.POST, produces = "application/json", consumes="application/json")
 //  @ResponseBody
 //  public SmsModel postTestRequest(@RequestBody String json) {
 //      return smsRepository.save(new SmsModel(json));
 //  }
}
