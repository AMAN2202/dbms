package com.example.demo.controller;

import com.example.demo.UserRepo;
import com.example.demo.entity.Expenses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ExpensesController {
    @Autowired
    UserRepo userRepository;

    @RequestMapping("exp/add")
    public ModelAndView add() {
        ModelAndView m = new ModelAndView("/expenses/expenses_add.jsp");
        m.addObject("e", new Expenses());
        return m;
    }

    @RequestMapping(value = "exp/add", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("e") Expenses exp,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error.jsp";
        }

        userRepository.addExpenses(exp);
        return "redirect:";
    }

    @RequestMapping("test")
    public String test() {

        return "error.jsp";
    }


}
