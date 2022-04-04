package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.Contacts;
import com.example.miniProject.repo.ContactsRepository;
import com.example.miniProject.services.AdminContactsServises.AdminContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class AdminContactsCinemaController {

    @Autowired
    private ContactsRepository contactsRepository;

    @Autowired
    private AdminContactsService adminContactsService;

    @GetMapping("/admin-contacts-create-cinema")
    public String getContactsList() {
        return "/Admin/Pages/admin-contacts-create-cinema";
    }

    @PostMapping("/admin-contacts-create-cinema")
    public String postContacts(@RequestParam String title,
                               @RequestParam String adress,
                               @RequestParam String coordinates,
                               @RequestParam("logo") MultipartFile logo,
                               @RequestParam boolean status) throws IOException {
        adminContactsService.saveContactsData(title, adress, coordinates, logo, status);
        return "redirect:/admin-contacts";
      }
}
