package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    Userrepo userRepo;

    @RequestMapping("add")
    public ModelAndView add() {
        return new ModelAndView("reg.jsp", "user", new User());

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("user") User user,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("name", user.getUsername());
        model.addAttribute("pass", user.getPassword());


        userRepo.addUser(user);

        return "userview.jsp";
    }

    @RequestMapping("/")
    public String home(Model model, final RedirectAttributes redirectAttributes) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            String username = ((UserDetails) principal).getUsername();
            model.addAttribute("username", username);

        redirectAttributes.addFlashAttribute("message", "Welcome " + username);
        return "redirect:/item";
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login.jsp";
    }

    @RequestMapping("/logout-success")
    public String logoutPage() {
        return "logout.jsp";
    }
}
