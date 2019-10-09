package com.example.demo.controller;

import com.example.demo.UserRepo;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Urls
///brand
///item
///exp
///tax
///supplier


@Controller
public class WebController {
    //
    @Autowired
    UserRepo userRepository;

    //Brand begin -----------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping("brand")
    public ModelAndView list_brand() {
        List<Brand> brands = userRepository.get_all_brand();
        ModelAndView model = new ModelAndView("/brand/brand_list.jsp");
        model.addObject("brands", brands);
        return model;
    }

    @RequestMapping("brand/remove/{id}")
    public String remove_brand(@PathVariable int id) {
        userRepository.remove_brand(id);
        return "redirect:test2";
    }


    @RequestMapping("brand/add")
    public ModelAndView add_brand() {
        return new ModelAndView("/brand/add.jsp", "brand", new Brand());

    }

    @RequestMapping("brand/update/{id}")
    public String update_brand(@PathVariable int id, Model model) {
        Brand brand = userRepository.get_brand(id);
//        System.out.println(brand.getBrand_name());
        model.addAttribute("brand", brand);
        return "/brand/add.jsp";

    }


    @RequestMapping(value = "brand/save", method = RequestMethod.POST)
    public String submit_brand(@Valid @ModelAttribute("brand") Brand brand,
                               BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error.jsp";
        }

        System.out.println(brand.getBrand_id());

        if (brand.getBrand_id() == 0)
            userRepository.addBrand(brand);
        else
            userRepository.update_Brand(brand);
        return "redirect:/brand";
    }
//Brand End----------------------------------------------------------------------------------------------------------------------------------------------

//Item Begin---------------------------------------------------------------------------------------------------------------------------------------------

    @RequestMapping("item")
    public ModelAndView list_item() {
        List<Item> items = userRepository.get_all_item();
        ModelAndView model = new ModelAndView("/item/list.jsp");
        model.addObject("items", items);
        return model;
    }


    @RequestMapping("item/add")
    public ModelAndView add_item() {
        ModelAndView m = new ModelAndView("/item/add.jsp");
        Map<Integer, String> bl = new HashMap<Integer, String>();
        List<Brand> l = userRepository.get_all_brand();
        for (Brand b : l) {
            bl.put(b.getBrand_id(), b.getBrand_name());
        }
        m.addObject("item", new Item());
        m.addObject("bl", bl);
        return m;


    }

    @RequestMapping("item/remove/{id}")
    public String remove_item(@PathVariable int id) {
        userRepository.remove_item(id);
        return "redirect:";
    }

    @RequestMapping(value = "item/add", method = RequestMethod.POST)
    public String submit_item(@Valid @ModelAttribute("item") Item item,
                              BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error.jsp";
        }

        userRepository.addItem(item);
        return "redirect:/brand";
    }

    @RequestMapping(value = "item/{id}")
    public ModelAndView get_item(@PathVariable int id) {
        Item i = userRepository.get_item(id);

        return new ModelAndView("/item/detail.jsp", "item", i);

    }
//Item End---------------------------------------------------------------------------------------------------------------------------------------
//   Exp Begin-----------------------------------------------------------------------------------------------------------------------------------

    @RequestMapping("exp")
    public ModelAndView list_exp() {
        List<Expenses> e = userRepository.get_all_Expenses();
        ModelAndView model = new ModelAndView("/expenses/list.jsp");
        model.addObject("items", e);
        return model;
    }


    @RequestMapping("exp/add")
    public ModelAndView add_exp() {
        ModelAndView m = new ModelAndView("/expenses/add.jsp");
        m.addObject("exp", new Expenses());
        return m;

    }

    @RequestMapping("exp/remove/{id}")
    public String remove_exp(@PathVariable int id) {
        userRepository.remove_expenses(id);
        return "redirect:/exp";
    }

    @RequestMapping(value = "exp/add", method = RequestMethod.POST)
    public String submit_exp(@Valid @ModelAttribute("e") Expenses expenses,
                             BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error.jsp";
        }
        if (expenses.getExpenses_id() == 0)
            userRepository.addExpenses(expenses);
        else
            userRepository.update_Exenses(expenses);
        return "redirect:/exp";
    }

    @RequestMapping("exp/update/{id}")
    public String update_exp(@PathVariable int id, Model model) {
        Expenses exp = userRepository.get_Expence(id);
//        System.out.println(brand.getBrand_name());
        model.addAttribute("exp", exp);
        return "/expenses/add.jsp";

    }

    //Exp end------------------------------------------------------------------------------------------------------------------------------------------------
//Income_tax_Begin----------------------------------------------------------------------------------------------------------------------------------------

    @RequestMapping("tax")
    public ModelAndView list_tax() {
        List<Income_tax> e = userRepository.get_all_Income_tax();
        ModelAndView model = new ModelAndView("/tax/list.jsp");
        model.addObject("items", e);
        return model;
    }


    @RequestMapping("tax/add")
    public ModelAndView add_tax() {
        ModelAndView m = new ModelAndView("/tax/add.jsp");
        m.addObject("tax", new Income_tax());
        return m;

    }

    @RequestMapping("tax/remove/{id}")
    public String remove_tax(@PathVariable int id) {
        userRepository.remove_Income_tax(id);
        return "redirect:/tax";
    }

    @RequestMapping(value = "tax/add", method = RequestMethod.POST)
    public String submit_tax(@Valid @ModelAttribute("tax") Income_tax i,
                             BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error.jsp";
        }
        if (i.getIncome_tax_id() == 0)
            userRepository.add_Income_Tax(i);
        else
            userRepository.update_Tax(i);
        return "redirect:/tax";
    }

    @RequestMapping("tax/update/{id}")
    public String update_tax(@PathVariable int id, Model model) {
        Income_tax i = userRepository.get_Income_tax(id);
//        System.out.println(brand.getBrand_name());
        model.addAttribute("tax", i);
        return "/tax/add.jsp";

    }
//Income Tax end-------------------------------------------------------------------------------------------------------------------------------------------------\
//Supplier Begin

    @RequestMapping("supplier")
    public ModelAndView list_supplier() {
        List<Personal_info> e = userRepository.get_all_supplier();
        ModelAndView model = new ModelAndView("/supplier/list.jsp");
        model.addObject("items", e);
        return model;
    }


    @RequestMapping("supplier/add")
    public ModelAndView add_supplier() {
        ModelAndView m = new ModelAndView("/supplier/add.jsp");
        m.addObject("person", new Personal_info());
        return m;

    }

    @RequestMapping("supplier/remove/{id}")
    public String remove_supplier(@PathVariable int id) {
        userRepository.remove_supplier(id);
        return "redirect:/supplier";
    }

    @RequestMapping(value = "supplier/add", method = RequestMethod.POST)
    public String submit_supplier(@Valid @ModelAttribute("person") Personal_info p,
                                  BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error.jsp";
        }
        if (p.getPerson_id() == 0) {
            userRepository.add_perosnal_info(p);
            Supplier s = new Supplier();
            p = userRepository.get_Person_by_email(p.getEmail());
            s.setPerson_id(p.getPerson_id());
            System.out.println(s.getPerson_id());
            System.out.println(p.getLastname());
            userRepository.addSupplier(s);
        } else {
            userRepository.update_personal_info(p);
        }

        return "redirect:/supplier";
    }

    @RequestMapping("supplier/update/{id}")
    public String update_supplier(@PathVariable int id, Model model) {
        Supplier s = userRepository.get_supplier(id);
//        System.out.println(brand.getBrand_name());
        model.addAttribute("person", userRepository.get_perosnal_info_by_id(s.getPerson_id()));
        return "/supplier/add.jsp";
    }
//Supplier End--------------------------------------------------------------------------------------------------------------------------------
//Employee begin-------------------------------------------------------------------------------------------------------------------------------
}
