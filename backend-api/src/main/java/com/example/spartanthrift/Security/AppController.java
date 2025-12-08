package com.example.spartanthrift.Security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    /**
     * Displays the index page
     * @return 
     * */
    @GetMapping("/index") // Landing page
    public String showIndexPage() {
        return "index"; // index.html
    }

}
