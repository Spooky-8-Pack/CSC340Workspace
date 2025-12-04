package com.example.spartanthrift.Home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles landing page (index.flth) and general navigation
 */

@Controller
public class HomeController {
//makes blank redirect to home
//makes /home show the index page
      @GetMapping({"", "/"})
    public String redirectToHome(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String goToHome(){
        return "index";
    }

}
