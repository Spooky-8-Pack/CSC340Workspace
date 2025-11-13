package com.example.spartanthrift;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({"", "/"})
    public String redirectToHome(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String goToHome(){
        return "index";
    }

}
    

