package by.kalesnikau.petmilitaryunit.controller;

import by.kalesnikau.petmilitaryunit.model.AuthorityEntity;
import by.kalesnikau.petmilitaryunit.model.UserEntity;
import by.kalesnikau.petmilitaryunit.service.MainUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private MainUserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @ModelAttribute("user")
    public UserEntity userRegistrationDto() {
        return new UserEntity();
    }

    @GetMapping("")
    public ModelAndView registrationPage() {
        return new ModelAndView("registration");
    }

    @PostMapping("")
    public ModelAndView registerUser(@ModelAttribute("user") @Valid UserEntity user, BindingResult bindingResult, Model model) {
        /*MainUserRoleEntity temp = userRole.getById(1L);
        temp.setPermissions(Set.of(userPermission.getById(1L)));
        user.setRole(temp);*/
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //realize ROLE
        user.setAuthorities(Set.of(userService.getAllAuthorities().get(0)));
        userService.registerUser(user);
        return new ModelAndView("redirect:/registration?success");
    }


}
