package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.AdminContactsPageStatus;
import com.example.miniProject.models.Contacts;
import com.example.miniProject.models.ContactsListAdditionalData;
import com.example.miniProject.repo.AdminContactsPageStatusRepositopy;
import com.example.miniProject.repo.ContactsListAdditionalRepository;
import com.example.miniProject.repo.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminContactsController {
    @Autowired
    private ContactsRepository contactsRepository;

    @Autowired
    private  ContactsListAdditionalRepository contactsListAdditionalRepository;

    @Autowired
    private AdminContactsPageStatusRepositopy adminContactsPageStatusRepositopy;

    @GetMapping("/admin-contacts")
    public String getContacts(Model model) {
        Iterable<Contacts> contacts = contactsRepository.findAll();
        Iterable<ContactsListAdditionalData> contactsListAdditionalData = contactsListAdditionalRepository.findAll();
        Iterable<AdminContactsPageStatus> adminContactsPageStatuses = adminContactsPageStatusRepositopy.findAll();
        model.addAttribute("contacts", contacts);
        model.addAttribute("contactsListAdditionalData", contactsListAdditionalData);
        model.addAttribute("contactsStatusPage", adminContactsPageStatuses);
        return "/Admin/Pages/admin-contacts";
    }

    @GetMapping("/admin-contacts/status-page/{id}")
    public String getStatusContactPage(@PathVariable(value = "id") long id, @RequestParam boolean status){
        AdminContactsPageStatus adminContactsPageStatus = adminContactsPageStatusRepositopy.findById(id).orElseThrow();
        adminContactsPageStatus.setStatus(status);
        adminContactsPageStatusRepositopy.save(adminContactsPageStatus);
        return "redirect:/admin-contacts";
    }

    @GetMapping("/admin-contacts/{id}")
    public String postContactsList(@PathVariable(value = "id") long id, @RequestParam String title,
                                   @RequestParam String adress,
                                   @RequestParam String coordinates,
                                   @RequestParam String logo,
                                   @RequestParam boolean status){
        Contacts contacts = contactsRepository.findById(id).orElseThrow();
        contacts.setTitle(title);
        contacts.setAdress(adress);
        contacts.setCoordinates(coordinates);
        contacts.setLogo(logo);
        contacts.setStatus(status);
        contactsRepository.save(contacts);
        return "redirect:/admin-contacts";
    }

    @PostMapping("/admin-contacts/{id}/remove")
    public String contectsPostDelete(@PathVariable(value = "id") long id, Model model){
        Contacts contacts = contactsRepository.findById(id).orElseThrow();
        contactsRepository.delete(contacts);
        return "redirect:/admin-contacts";
    }

    @PostMapping("/admin-contacts/seo/{id}")
    public String contactsAdditionalData(@PathVariable(value = "id") long id,
                                       @RequestParam String seoUrl,
                                       @RequestParam String seoTitle,
                                       @RequestParam String seoKeywords,
                                       @RequestParam String seoDescription) {
      if (!contactsListAdditionalRepository.existsById(id)) {
          return "/Admin/Pages/admin-contacts";
      }
      ContactsListAdditionalData contactsListAdditionalData = contactsListAdditionalRepository.findById(id).orElseThrow();
      contactsListAdditionalData.setSeoUrl(seoUrl);
      contactsListAdditionalData.setSeoTitle(seoTitle);
      contactsListAdditionalData.setSeoKeywords(seoKeywords);
      contactsListAdditionalData.setSeoDescription(seoDescription);
      contactsListAdditionalRepository.save(contactsListAdditionalData);
      return "redirect:/admin-contacts";
  }

    @PostMapping("/admin-contacts/seo/{id}/remove")
    public String contectsSeoPostDelete(@PathVariable(value = "id") long id, Model model){
        ContactsListAdditionalData contactsListAdditionalData = contactsListAdditionalRepository.findById(id).orElseThrow();
        contactsListAdditionalRepository.delete(contactsListAdditionalData);
        return "redirect:/admin-contacts";
    }
}
