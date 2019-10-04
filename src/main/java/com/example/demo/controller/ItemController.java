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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("item")
@Controller
public class ItemController {
    @Autowired
    UserRepo userRepository;

    @RequestMapping("")
    public ModelAndView list_item() {
        List<Item> items = userRepository.get_all_item();
        ModelAndView model = new ModelAndView("/item/item_list.jsp");
        model.addObject("items", items);
        return model;
    }


    @RequestMapping("add")
    public ModelAndView add() {
        ModelAndView m = new ModelAndView("/item/item_add.jsp");
        Map<Integer, String> bl = new HashMap<Integer, String>();
        List<Brand> l = userRepository.get_all_brand();
        for (Brand b : l) {
            bl.put(b.getBrand_id(), b.getBrand_name());
        }
        m.addObject("item", new Item());
        m.addObject("bl", bl);
        return m;


    }

    @RequestMapping("remove/{id}")
    public String remove_item(@PathVariable int id) {
        userRepository.remove_item(id);
        return "redirect:";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("item") Item item,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error.jsp";
        }

        userRepository.addItem(item);
        return "redirect:";
    }

    @RequestMapping(value = "/{id}")
    public ModelAndView get_item(@PathVariable int id) {
        Item i = userRepository.get_item(id);

        return new ModelAndView("/item/item_detail.jsp", "item", i);

    }

}
