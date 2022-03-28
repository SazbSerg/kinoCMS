package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.*;
import com.example.miniProject.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPagesController {

    @Autowired
    MainPageRepository mainPageRepository;

    @Autowired
    AboutCinemaRepository aboutCinemaRepository;

    @Autowired
    CafeBarRepository cafeBarRepository;

    @Autowired
    VipHallRepositiry vipHallRepositiry;

    @Autowired
    AdRepository adRepository;

    @Autowired
    ChildrenRoomRepository childrenRoomRepository;

    @Autowired
    ContactsRepository contactsRepository;

    @Autowired
    ContactsListAdditionalRepository contactsListAdditionalRepository;

    @Autowired
    AdminContactsPageStatusRepositopy adminContactsPageStatusRepository;

    @Autowired
    private AdminPagesNewPageRepository adminPagesNewPageRepository;

    @GetMapping("/admin-pages")
    public String getAdminPages(Model model) {
        Iterable<MainPage> mainPages = mainPageRepository.findAll();
        Iterable<AboutCinema> aboutCinemas = aboutCinemaRepository.findAll();
        Iterable<CafeBar> cafeBars = cafeBarRepository.findAll();
        Iterable<VipHall> vipHalls = vipHallRepositiry.findAll();
        Iterable<Ad> ads = adRepository.findAll();
        Iterable<ChildrenRoom> childrenRooms = childrenRoomRepository.findAll();
        Iterable<Contacts> contacts = contactsRepository.findAll();
        Iterable<ContactsListAdditionalData> contactsListAdditionalData = contactsListAdditionalRepository.findAll();
        Iterable<AdminContactsPageStatus> adminContactsPageStatuses = adminContactsPageStatusRepository.findAll();
        Iterable<AdminPagesNewPage> adminPagesNewPages = adminPagesNewPageRepository.findAll();
        model.addAttribute("mainPage", mainPages);
        model.addAttribute("aboutCinema", aboutCinemas);
        model.addAttribute("cafeBars", cafeBars);
        model.addAttribute("vipHall", vipHalls);
        model.addAttribute("ad", ads);
        model.addAttribute("childrenRoom", childrenRooms);
        model.addAttribute("contact", contacts);
        model.addAttribute("contactsListAdditionalData", contactsListAdditionalData);
        model.addAttribute("contactsPageStatus", adminContactsPageStatuses);
        model.addAttribute("newPages", adminPagesNewPages);
        return "/Admin/Pages/admin-pages";
    }
}
