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

    /**
     * Displays the log-in in
     * @return
     */
    @GetMapping("/log-in")
    public String showLoginPage() {
        return "log-in";
    }

}
  