package com.maweis.facade;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by peter on 12/14/13.
 */

@Controller
public class WelcomeController {

    @RequestMapping("home")
    public String loadHomePage(Model m){
        m.addAttribute("name", "Maven");
        return "home";
    }
}
