package com.example.miniProject.controllers.AdminControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminContactsListAdditionalController {

  @GetMapping("/admin-contacts-list-additional")
  public String getContactsListAdditional(Model model) {
      return "admin-contacts-create-cinema";
  }
}
