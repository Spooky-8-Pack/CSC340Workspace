package com.example.spartanthrift.Home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles landing page (index.flth) and general navigation
 */

@Controller
public class HomeController {

    /**
     * Displays the index page
     * @return
     */
    @GetMapping("/") // Landing page is at the root
    public String showIndexPage() {
        return "index"; // index-flth
    }

}
