package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.Contacts;
import com.example.miniProject.repo.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminContactsCinemaController {

    @Autowired
    private ContactsRepository contactsRepository;

    @GetMapping("/admin-contacts-create-cinema")
    public String getContactsList() {
        return "/Admin/Pages/admin-contacts-create-cinema";
    }

    @PostMapping("/admin-contacts-create-cinema")
    public String postContacts(@RequestParam String title, @RequestParam String adress, @RequestParam String coordinates,
                               @RequestParam String logo, @RequestParam boolean status) {
        Contacts contacts = new Contacts(title, adress, coordinates, logo, status);
        contactsRepository.save(contacts);
        return "redirect:/admin-contacts";
      }
}
