package com.example.demo.controller;

import com.example.demo.UserRepo;
import com.example.demo.auth.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebController {
//
@Autowired
UserRepo userRepository;

//
//@RequestMapping("aa")
//    public List<Item> get()
//{
//    return userRepository.get_all_item_by_supplier(1);
//}
@RequestMapping("test2")
public List<User> get() {
    return userRepository.get_all_Users();
}
}
