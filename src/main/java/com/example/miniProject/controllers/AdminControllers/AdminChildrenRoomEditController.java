package com.example.miniProject.controllers.AdminControllers;
import com.example.miniProject.models.ChildrenRoom;
import com.example.miniProject.repo.ChildrenRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AdminChildrenRoomEditController {

    @Autowired
    ChildrenRoomRepository childrenRoomRepository;

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
                                       @RequestParam String mainImage,
                                       @RequestParam String image1,
                                       @RequestParam String image2,
                                       @RequestParam String image3,
                                       @RequestParam String image4,
                                       @RequestParam String image5,
                                       @RequestParam String seoUrl,
                                       @RequestParam String seoTitle,
                                       @RequestParam String seoKeywords,
                                       @RequestParam String seoDescription){
        ChildrenRoom childrenRoom = childrenRoomRepository.findById(id).orElseThrow();
        childrenRoom.setTitle(title);
        childrenRoom.setDescription(description);
        childrenRoom.setPublicDate(publicDate);
        childrenRoom.setLanguage(language);
        childrenRoom.setStatus(status);
        childrenRoom.setMainImage(mainImage);
        childrenRoom.setImage1(image1);
        childrenRoom.setImage2(image2);
        childrenRoom.setImage3(image3);
        childrenRoom.setImage4(image4);
        childrenRoom.setImage5(image5);
        childrenRoom.setSeoUrl(seoUrl);
        childrenRoom.setSeoTitle(seoTitle);
        childrenRoom.setSeoKeywords(seoKeywords);
        childrenRoom.setSeoDescription(seoDescription);
        childrenRoomRepository.save(childrenRoom);
        return "redirect:/admin-pages";
    }
}
