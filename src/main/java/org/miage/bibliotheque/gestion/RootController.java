package org.miage.bibliotheque.gestion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class RootController {
    @GetMapping
    public String homePage() {
        return "index";
    }
}
