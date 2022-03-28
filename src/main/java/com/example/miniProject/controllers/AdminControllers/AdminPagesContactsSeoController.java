package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.ContactsListAdditionalData;
import com.example.miniProject.repo.ContactsListAdditionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminPagesContactsSeoController {
    @Autowired
    ContactsListAdditionalRepository contactsListAdditionalRepository;

    @GetMapping("/admin-contacts-create-seo")
    public String getContactsSEO() {
        return "/Admin/Pages/admin-contacts-create-seo";
    }

    @PostMapping("/admin-contacts-create-seo")
    public String contactsAdditionalData(@RequestParam String name,
                                         @RequestParam String publicDate,
                                         @RequestParam String seoUrl,
                                         @RequestParam String seoTitle,
                                         @RequestParam String seoKeywords,
                                         @RequestParam String seoDescription) {
        ContactsListAdditionalData contactsListAdditionalData = new ContactsListAdditionalData(name, publicDate,
                seoUrl, seoTitle, seoKeywords, seoDescription);
        contactsListAdditionalRepository.save(contactsListAdditionalData);
        return "redirect:/admin-contacts";
    }
}
