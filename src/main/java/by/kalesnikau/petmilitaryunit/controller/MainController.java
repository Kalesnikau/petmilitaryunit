package by.kalesnikau.petmilitaryunit.controller;

import by.kalesnikau.petmilitaryunit.service.MainUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private MainUserService userService;

    @GetMapping("")
    public ModelAndView mainPage() {
        return new ModelAndView("index");
    }

    @GetMapping("/info")
    public ModelAndView infoPage() {
        return new ModelAndView("info");
    }

        @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }

    @GetMapping("/accessdenied")
    public String getAccessDenied() {
        return "accessdenied";
    }

    @GetMapping("/admininfo")
    public ModelAndView adminInfoPage() {
        Map map = Map.of(
                "users",userService.getAllUsers(),
                "roles",userService.getAllAuthorities());
        return new ModelAndView("admininfo", map);
    }
}
