package by.kalesnikau.petmilitaryunit.controller;

import by.kalesnikau.petmilitaryunit.model.DonutEntity;
import by.kalesnikau.petmilitaryunit.service.DonutService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/donut")
public class DonutCuntroller {

    @Autowired
    DonutService donutService;

    @GetMapping("")
    public ModelAndView donateInfoPage(Model model) {
        model.addAttribute("donuts",donutService.getAll());
        model.addAttribute("donuttoupdate",new DonutEntity());
        model.addAttribute("donuttosave", new DonutEntity());
        return new ModelAndView("/donut/donateinfo");
    }

    @PostMapping("")
    public ModelAndView addDonut(@ModelAttribute("donuttosave") DonutEntity donut) {
        //donutService.add((DonutEntity) model.getAttribute("donuttosave"));
        donutService.add(donut);
        return new ModelAndView("redirect:/donut");}

    @DeleteMapping("/{id}")
    public ModelAndView deleteDonut(@PathVariable("id") long id) {
        donutService.deleteById(id);
        return new ModelAndView("redirect:/donut");
    }

    @PatchMapping("/{id}")
    public ModelAndView updateDonut(@PathVariable("id") long id, @ModelAttribute("donuttoupdate") DonutEntity donut) {
        donutService.update(id,donut);
        return new ModelAndView("redirect:/donut");
    }

}
