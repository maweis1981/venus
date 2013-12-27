package com.maweis.facade;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by peter on 12/14/13.
 */
@Controller
public class ImpressionController {

    @RequestMapping("imp")
    public String imp(Model m){
        return "imp";
    }

}
