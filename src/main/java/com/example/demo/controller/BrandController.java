package com.example.demo.controller;

import com.example.demo.UserRepo;
import com.example.demo.entity.Brand;
import com.example.demo.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("brand")
@Controller
public class BrandController {
    @Autowired
    UserRepo userRepository;

    @RequestMapping("{brand_id}")
    public ModelAndView list_item_by_brand(@PathVariable int brand_id) {

        List<Item> items = userRepository.get_all_item_by_brand(brand_id);
        ModelAndView model = new ModelAndView("/brand/brand_detail.jsp");
        Brand b = userRepository.get_brand(brand_id);
        model.addObject("brand", b);
        return model;
    }

    @RequestMapping("")
    public ModelAndView list_brand() {
        List<Brand> brands = userRepository.get_all_brand();
        ModelAndView model = new ModelAndView("/brand/brand_list.jsp");
        model.addObject("brands", brands);
        return model;
    }

    @RequestMapping("remove/{id}")
    public String remove_brand(@PathVariable int id) {
        userRepository.remove_brand(id);
        return "redirect:";
    }


    @RequestMapping("add")
    public ModelAndView add() {
        return new ModelAndView("/brand/brand_add.jsp", "brand", new Brand());

    }

    @RequestMapping("update/{id}")
    public ModelAndView update(@PathVariable int id) {
        Brand b = userRepository.get_brand(id);
        return new ModelAndView("/brand/brand_add.jsp", "brand", b);

    }

    @RequestMapping(value = "update/", method = RequestMethod.POST)
    public String update_submit(@Valid @ModelAttribute("brand") Brand brand,
                                BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error.jsp";
        }

        userRepository.update_Brand(brand);
        return "redirect:";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("brand") Brand brand,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error.jsp";
        }

        userRepository.addBrand(brand);
        return "redirect:/brand";
    }


}
