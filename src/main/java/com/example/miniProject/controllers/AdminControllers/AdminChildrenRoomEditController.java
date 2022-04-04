package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.ChildrenRoom;
import com.example.miniProject.repo.ChildrenRoomRepository;
import com.example.miniProject.services.adminChildrenRoomServices.AdminChildrenRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AdminChildrenRoomEditController {

    @Autowired
    ChildrenRoomRepository childrenRoomRepository;

    @Autowired
    AdminChildrenRoomService adminChildrenRoomService;

    @GetMapping("/admin-children-room-edit/{id}")
    public String getChildrenRoomEdit(@PathVariable(value = "id") long id, Model model) {
        if (!childrenRoomRepository.existsById(id)) {
            return "redirect: /admin-pages";}
        Optional<ChildrenRoom> childrenRoom = childrenRoomRepository.findById(id);
        ArrayList<ChildrenRoom> res = new ArrayList<>();
        childrenRoom.ifPresent(res :: add);
        model.addAttribute("childrenRooms", res);
        return "/Admin/Pages/admin-children-room-edit";
    }

    @PostMapping("/admin-children-room-edit/{id}")
    public String postChildrenRoomEdit(@PathVariable(value = "id") long id,
                                       @RequestParam String title,
                                       @RequestParam String description,
                                       @RequestParam String publicDate,
                                       @RequestParam boolean language,
                                       @RequestParam boolean status,
                                       @RequestParam("mainImage") MultipartFile file,
                                       @RequestParam("image1") MultipartFile file1,
                                       @RequestParam("image2") MultipartFile file2,
                                       @RequestParam("image3") MultipartFile file3,
                                       @RequestParam("image4") MultipartFile file4,
                                       @RequestParam("image5") MultipartFile file5,
                                       @RequestParam String seoUrl,
                                       @RequestParam String seoTitle,
                                       @RequestParam String seoKeywords,
                                       @RequestParam String seoDescription) throws IOException {
        adminChildrenRoomService.saveChildrenRoomData(id, title, description, publicDate, language, status, file, file1, file2, file3, file4, file5, seoUrl, seoTitle, seoKeywords, seoDescription);
        return "redirect:/admin-pages";
    }
}
