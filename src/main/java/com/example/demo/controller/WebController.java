package com.example.demo.controller;

import com.example.demo.UserRepo;
import com.example.demo.auth.User;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
//cart
//Emi


@Controller
public class WebController {


    public User get_user() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username = ((UserDetails) principal).getUsername();

        return userRepository.get_User(username);
    }
    //
    @Autowired
    UserRepo userRepository;

    //Brand begin -----------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping("brand")
    public ModelAndView list_brand() {
        List<Brand> brands = userRepository.get_all_brand();
        ModelAndView model = new ModelAndView("/brand/brand_list.jsp");
        model.addObject("brands", brands);
        model.addObject("user", get_user());
        return model;
    }

    @RequestMapping("brand/remove/{id}")
    public String remove_brand(@PathVariable int id) {
        userRepository.remove_brand(id);
        return "redirect:test2";
    }


    @RequestMapping("brand/add")
    public ModelAndView add_brand() {
        ModelAndView m = new ModelAndView("/brand/add.jsp");
        m.addObject("brand", new Brand());
        m.addObject("action", "add");
        m.addObject("user", get_user());
        return m;

    }

    @RequestMapping("brand/update/{id}")
    public String update_brand(@PathVariable int id, Model model) {
        Brand brand = userRepository.get_brand(id);
//        System.out.println(brand.getBrand_name());
        model.addAttribute("brand", brand);
        model.addAttribute("action", "update");
        model.addAttribute("user", get_user());
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
        ItemFilter f = new ItemFilter();
        List<Item> items = userRepository.get_all_item();
        ModelAndView model = new ModelAndView("/item/list.jsp");
        model.addObject("filter", f);
        model.addObject("items", items);
        model.addObject("user", get_user());
        model.addObject("brands", userRepository.get_all_brand());
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
        m.addObject("action", "add");
        m.addObject("user", get_user());

        return m;

    }



    @RequestMapping("item/remove/{id}")
    public String remove_item(@PathVariable int id, final RedirectAttributes redirectAttributes) {
        userRepository.remove_item(id);
        redirectAttributes.addFlashAttribute("message", "Product sucessfully deleted");
        return "redirect:/item";

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

    @RequestMapping(value = "/filteritem", method = RequestMethod.GET)
    public ModelAndView submit_item_filter(@Valid @ModelAttribute("filter") ItemFilter f,
                                           BindingResult result, ModelMap model2) {

//        if (result.hasErrors()) {
//            new ModelAndView("error.jsp");
//
//        }

        List<Item> items = userRepository.get_all_item_by_filter(f);
        ModelAndView model = new ModelAndView("/item/list.jsp");
        model.addObject("filter", f);
        model.addObject("items", items);
        model.addObject("user", get_user());
        model.addObject("brands", userRepository.get_all_brand());
        return model;
    }


    @RequestMapping(value = "/filteremp", method = RequestMethod.GET)
    public ModelAndView submit_emp_filter(@Valid @ModelAttribute("filter") EmpFilter f,
                                          BindingResult result, ModelMap model2) {

//        if (result.hasErrors()) {
//            new ModelAndView("error.jsp");
//
//        }

        List<Employee> e = userRepository.get_all_emp_by_filter(f);
        for (Employee x : e) {
            x.setP(userRepository.get_perosnal_info_by_id(x.getPerson_id()));
        }
//        System.out.println(f.getE().getSalary());
        ModelAndView model = new ModelAndView("/employee/list.jsp");
        model.addObject("filter", f);
        model.addObject("items", e);
        model.addObject("user", get_user());
        return model;
    }


    @RequestMapping(value = "item/{id}")
    public ModelAndView get_item(@PathVariable int id) {
        Item i = userRepository.get_item(id);

        return new ModelAndView("/item/detail.jsp", "item", i);

    }

    @RequestMapping(value = "item/add/cart/{id}")
    public String add_item_cart(@PathVariable int id, final RedirectAttributes redirectAttributes) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Customer c = userRepository.get_customer_by_username(username);
        Cart cart = new Cart();
        cart.setItem_id(id);
        cart.setCustomer_id(c.getCustomer_id());


        try {
            cart = userRepository.find_cart(cart);
        } catch (Exception e) {
        }
        cart.setQuantity(cart.getQuantity() + 1);


        if (cart.getQuantity() == 1)
            userRepository.add_cart(cart);
        else {
            userRepository.update_cart(cart);
        }
        redirectAttributes.addFlashAttribute("message", "item added to cart.");
        return "redirect:/item/" + cart.getItem_id();

    }


    @RequestMapping(value = "item/remove/cart/{id}")
    public String remove_item_cart(@PathVariable int id) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Customer c = userRepository.get_customer_by_username(username);
        Cart cart = new Cart();
        cart.setItem_id(id);
        cart.setCustomer_id(c.getCustomer_id());


        try {
            cart = userRepository.find_cart(cart);
        } catch (Exception e) {
        }
        cart.setQuantity(cart.getQuantity() - 1);


        if (cart.getQuantity() == 0)
            userRepository.remove_cart(cart);
        else {
            userRepository.update_cart(cart);
        }
        return "redirect:/item/" + cart.getItem_id();

    }

//Item End---------------------------------------------------------------------------------------------------------------------------------------
//   Exp Begin-----------------------------------------------------------------------------------------------------------------------------------

    @RequestMapping("exp")
    public ModelAndView list_exp() {
        List<Expenses> e = userRepository.get_all_Expenses();
        ModelAndView model = new ModelAndView("/expenses/list.jsp");
        model.addObject("items", e);
        model.addObject("user", get_user());
        return model;
    }


    @RequestMapping("exp/add")
    public ModelAndView add_exp() {
        ModelAndView m = new ModelAndView("/expenses/add.jsp");
        m.addObject("action", "add");
        m.addObject("exp", new Expenses());
        m.addObject("user", get_user());
        return m;

    }

    @RequestMapping("exp/remove/{id}")
    public String remove_exp(@PathVariable int id) {
        userRepository.remove_expenses(id);
        return "redirect:/exp";
    }

    @RequestMapping(value = "exp/add", method = RequestMethod.POST, params = "cancel")
    public String submit_exp() {
        return "redirect:/exp";
    }

    @RequestMapping(value = "exp/add", method = RequestMethod.POST, params = "submit")
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
        model.addAttribute("Action", "update");
        model.addAttribute("user", get_user());
        return "/expenses/add.jsp";

    }

    //Exp end------------------------------------------------------------------------------------------------------------------------------------------------
//Income_tax_Begin----------------------------------------------------------------------------------------------------------------------------------------

    @RequestMapping("tax")
    public ModelAndView list_tax() {
        List<Income_tax> e = userRepository.get_all_Income_tax();
        ModelAndView model = new ModelAndView("/tax/list.jsp");
        model.addObject("items", e);
        model.addObject("user", get_user());
        return model;
    }


    @RequestMapping("tax/add")
    public ModelAndView add_tax() {
        ModelAndView m = new ModelAndView("/tax/add.jsp");
        m.addObject("tax", new Income_tax());
        m.addObject("action", "add");
        m.addObject("user", get_user());
        return m;

    }

    @RequestMapping("tax/remove/{id}")
    public String remove_tax(@PathVariable int id) {
        userRepository.remove_Income_tax(id);
        return "redirect:/tax";
    }

    @RequestMapping(value = "tax/add", method = RequestMethod.POST, params = "cancel")
    public String submit_tax() {
        return "redirect:/tax";
    }

    @RequestMapping(value = "tax/add", method = RequestMethod.POST, params = "submit")
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
        model.addAttribute("action", "update");
        model.addAttribute("user", get_user());
        return "/tax/add.jsp";
    }
//Income Tax end-------------------------------------------------------------------------------------------------------------------------------------------------\
//Supplier Begin

    @RequestMapping("supplier")
    public ModelAndView list_supplier() {
        List<Supplier> e = userRepository.get_all_supplier();
        for (Supplier s : e) {
            s.setP(userRepository.get_perosnal_info_by_id(s.getPerson_id()));
        }
        ModelAndView model = new ModelAndView("/supplier/list.jsp");
        model.addObject("items", e);
        model.addObject("user", get_user());
        return model;
    }

    @RequestMapping("supplier/{id}")
    public String supplier_details(@PathVariable int id, Model m) {
        Supplier s = userRepository.get_supplier(id);
        s.setP(userRepository.get_perosnal_info_by_id(s.getPerson_id()));
        m.addAttribute("b", s);
        m.addAttribute("user", get_user());
//        List<Brand> brand=userRepository.get_all_brand_by_supplier(id);
//        m.addAttribute("brands",brand);
//        List<Item> item=userRepository.get_all_item_by_supplier(id);
//        m.addAttribute("items",item);
        return "/supplier/detail.jsp";
    }


    @RequestMapping("supplier/add")
    public ModelAndView add_supplier() {
        ModelAndView m = new ModelAndView("/supplier/add.jsp");
        m.addObject("person", new Personal_info());
        m.addObject("action", "add");
        m.addObject("user", get_user());
        return m;

    }


    @RequestMapping("supplier/remove/{id}")
    public String remove_supplier(@PathVariable int id) {
        userRepository.remove_supplier(id);
        return "redirect:/supplier";
    }


    @RequestMapping(value = "supplier/add", method = RequestMethod.POST, params = "cancel")
    public String submit_supplier_cancel() {
        return "redirect:/supplier";

    }

    @RequestMapping(value = "supplier/add", method = RequestMethod.POST, params = "submit")
    public String submit_supplier(@Valid @ModelAttribute("person") Personal_info p,
                                  BindingResult result, ModelMap model) {
        System.out.println(p.getDob());
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
        model.addAttribute("action", "update");
        model.addAttribute("user", get_user());
        return "/supplier/add.jsp";
    }
//Supplier End--------------------------------------------------------------------------------------------------------------------------------
//Employee begin-------------------------------------------------------------------------------------------------------------------------------

    @RequestMapping("employee")
    public ModelAndView list_employee() {
        List<Employee> e = userRepository.get_all_employee();
        for (Employee x : e) {
            x.setP(userRepository.get_perosnal_info_by_id(x.getPerson_id()));
        }
        ModelAndView model = new ModelAndView("/employee/list.jsp");
        model.addObject("items", e);
        model.addObject("user", get_user());
        model.addObject("filter", new EmpFilter());
        return model;
    }

    @RequestMapping("employee/{id}")
    public ModelAndView list_employee(@PathVariable int id) {
        Employee e = userRepository.get_employee(id);
        e.setP(userRepository.get_perosnal_info_by_id(e.getPerson_id()));
        ModelAndView model = new ModelAndView("/employee/detail.jsp");
        model.addObject("b", e);
        model.addObject("user", get_user());
        return model;
    }



    @RequestMapping("employee/add")
    public ModelAndView add_employee() {
        ModelAndView m = new ModelAndView("/employee/add.jsp");
        m.addObject("emp", new Employee());
        m.addObject("action", "add");
        m.addObject("user", get_user());
        return m;

    }

    @RequestMapping("employee/remove/{id}")
    public String remove_employee(@PathVariable int id) {
        userRepository.remove_employee(id);
        return "redirect:/employee";
    }

    @RequestMapping(value = "employee/add", method = RequestMethod.POST, params = "cancel")
    public String submit_employee_cancel() {
        return "redirect:/employee";
    }

    @RequestMapping(value = "employee/add", method = RequestMethod.POST, params = "submit")
    public String submit_employee(@Valid @ModelAttribute("emp") Employee e,
                                  BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error.jsp";
        }
        if (e.getEmployee_id() == 0) {
            userRepository.add_perosnal_info(e.getP());
            Personal_info p = userRepository.get_Person_by_email(e.getP().getEmail());
            e.setPerson_id(p.getPerson_id());
            System.out.println(p.getPerson_id());
            System.out.println(p.getLastname());
            userRepository.add_employee(e);
        } else {
            System.out.println(e.getP().getEmail());
            Personal_info p = e.getP();
            p.setPerson_id(e.getPerson_id());
            userRepository.update_personal_info(p);
            userRepository.update_employee(e);
        }

        return "redirect:/employee";
    }

    @RequestMapping("employee/update/{id}")
    public String update_employee(@PathVariable int id, Model model) {
        Employee s = userRepository.get_employee(id);
        s.setP(userRepository.get_perosnal_info_by_id(s.getPerson_id()));
//        System.out.println(brand.getBrand_name());
        model.addAttribute("emp", s);
        model.addAttribute("action", "update");
        model.addAttribute("user", get_user());
        return "/employee/add.jsp";
    }

    //Employee end------------------------------------------------------------------------------------------------------------------------------------------
//Cart item---------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping("cart")
    public String cart(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Customer c = userRepository.get_customer_by_username(username);
        double total = 0;
        List<Cart> cart = userRepository.get_cart_by_customer(c.getCustomer_id());
        for (Cart i : cart) {
            i.setI(userRepository.get_item(i.getItem_id()));
            total += i.getQuantity() * i.getI().getMrp() * (1 - i.getI().getDiscount() * 1.0 / 100);
        }
        model.addAttribute("items", cart);
        model.addAttribute("user", get_user());
        model.addAttribute("total", total);
        return "cart/list.jsp";
    }

    @RequestMapping(value = "cart/add/{id}")
    public String add_cart(@PathVariable int id, final RedirectAttributes redirectAttributes) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Customer c = userRepository.get_customer_by_username(username);
        Cart cart = new Cart();
        cart.setItem_id(id);
        cart.setCustomer_id(c.getCustomer_id());


        try {
            cart = userRepository.find_cart(cart);
        } catch (Exception e) {
        }
        cart.setQuantity(cart.getQuantity() + 1);


        if (cart.getQuantity() == 1) {
            userRepository.add_cart(cart);
            redirectAttributes.addFlashAttribute("message", "Item added to cart");
        }
        else {
            userRepository.update_cart(cart);
            redirectAttributes.addFlashAttribute("message", "Item quantity updated successfully");
        }


        return "redirect:/cart";

    }


    @RequestMapping(value = "cart/remove/{id}")
    public String remove_cart(@PathVariable int id, final RedirectAttributes redirectAttributes) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Customer c = userRepository.get_customer_by_username(username);
        Cart cart = new Cart();
        cart.setItem_id(id);
        cart.setCustomer_id(c.getCustomer_id());


        try {
            cart = userRepository.find_cart(cart);
        } catch (Exception e) {
        }
        cart.setQuantity(cart.getQuantity() - 1);


        if (cart.getQuantity() == 0) {
            userRepository.remove_cart(cart);
            redirectAttributes.addFlashAttribute("message2", "Item removed from cart");
        }
        else {
            userRepository.update_cart(cart);
            redirectAttributes.addFlashAttribute("message", "item quantity updated successfully");
        }
        return "redirect:/cart";

    }


    @RequestMapping(value = "cart/delete/{id}")
    public String delete_cart(@PathVariable int id, final RedirectAttributes redirectAttributes) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Customer c = userRepository.get_customer_by_username(username);
        Cart cart = new Cart();
        cart.setItem_id(id);
        cart.setCustomer_id(c.getCustomer_id());
        userRepository.remove_cart(cart);
        redirectAttributes.addFlashAttribute("message2", "Item removed from cart");
        return "redirect:/cart";

    }

    //Cart end--------------------------------------------------------------------------------------------------------------------------------
//Emi add---------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping("emi")
    public String list_emi(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Customer c = userRepository.get_customer_by_username(username);
        List<Emi> l = userRepository.get_all_Emi_by_customer(c.getCustomer_id());
        model.addAttribute("items", l);
        model.addAttribute("user", get_user());
        return "emi/list.jsp";
    }


    @RequestMapping(value = "emi/add/{id}/{time}")
    public String add_emi(@PathVariable int id, @PathVariable int time) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Customer c = userRepository.get_customer_by_username(username);
        Emi e = new Emi();
        Item i = userRepository.get_item(id);
        e.setItem_id(id);
        e.setPrincipal(i.getMrp() - i.getDiscount() * i.getMrp());
        e.setIntrest(10);
        e.setTot_fraction(time);
        e.setCustomer_id(c.getCustomer_id());
        userRepository.add_Emi(e);
        return "redirect:/emi";
    }

    //Checkout-----------------------------------------------------------------------------------------------------------------------------
    @RequestMapping("checkout")
    public ModelAndView checkout() {
        ModelAndView model = new ModelAndView("cart/checkout.jsp");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Customer c = userRepository.get_customer_by_username(username);
        double total = 0;
        List<Cart> cart = userRepository.get_cart_by_customer(c.getCustomer_id());
        for (Cart i : cart) {
            i.setI(userRepository.get_item(i.getItem_id()));
            total += i.getQuantity() * i.getI().getMrp() * (1 - i.getI().getDiscount() * 1.0 / 100);
        }
        List<Vouchers> l = userRepository.get_all_voucher(c.getCustomer_id());
        Map<Integer, String> bl = new HashMap<Integer, String>();
        bl.put(0, "NONE");
        for (Vouchers v : l) {
            if (v.getActive() == 1)
                bl.put(v.getVoucher_id(), "OFF" + v.getCredits());
        }
        model.addObject("items", cart);
        model.addObject("user", get_user());
        model.addObject("total", total);
        model.addObject("bl", bl);
        model.addObject("vc", new VoucherCheckout());
        return model;
    }

    @RequestMapping(value = "checkout", method = RequestMethod.POST, params = "cancel")
    public String checkout_cancel() {
        return "redirect:/cart";
    }

    @RequestMapping(value = "checkout", method = RequestMethod.POST, params = "submit")
    public String checkout_submit(@Valid @ModelAttribute("vc") VoucherCheckout vc,
                                  BindingResult result, final RedirectAttributes redirectAttributes) {
        int id = vc.getId();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Customer c = userRepository.get_customer_by_username(username);
        List<Cart> cart = userRepository.get_cart_by_customer(c.getCustomer_id());
        Vouchers v = new Vouchers();
        try {
            v = userRepository.get_voucher(id);
        } catch (Exception e) {
            v.setActive(0);
            v.setCustomerid(0);

        }

        if (v.getActive() == 0) {
            v = new Vouchers(0, 0);
        }
        Reciept r = new Reciept();
        int total = 0;

        for (Cart i : cart) {
            i.setI(userRepository.get_item(i.getItem_id()));
            total += i.getQuantity() * i.getI().getMrp() * (1 - i.getI().getDiscount() * 1.0 / 100);
        }
        r.setAmount(total);

        if (total > 100) {
            Vouchers v2 = new Vouchers();
            v2.setCustomerid(c.getCustomer_id());
            v2.setActive(1);
            v2.setCredits(total / 20);
            userRepository.add_voucher(v2);
        }
        r.setCustomer_id(c.getCustomer_id());
        r.setDiscount(v.getVoucher_id());
        r.setAmount_payed(Math.max(total - v.getCredits(), 0));
        r.setReceipt_id(userRepository.add_reciept(r));
        v.setActive(0);
        userRepository.update_voucher(v);

        for (Cart i : cart) {
            userRepository.add_ritem(i, r.getReceipt_id());
        }
        userRepository.clear_cart(c.getCustomer_id());
        return "redirect:/item";
    }
//Customer begin-------------------------------------------------------------------------------------------------------------------------------------------

    @RequestMapping("customer")
    public ModelAndView list_customer() {
        List<Customer> e = userRepository.get_all_customer();
        for (Customer s : e) {
            s.setP(userRepository.get_perosnal_info_by_id(s.getPerson_id()));
        }
        ModelAndView model = new ModelAndView("/customer/list.jsp");
        model.addObject("items", e);
        model.addObject("user", get_user());
        return model;
    }

    @RequestMapping("customer/{id}")
    public String customer_details(@PathVariable int id, Model m) {
        Customer s = userRepository.get_customer(id);
        s.setP(userRepository.get_perosnal_info_by_id(s.getPerson_id()));
        m.addAttribute("b", s);
        m.addAttribute("user", get_user());
//        List<Brand> brand=userRepository.get_all_brand_by_supplier(id);
//        m.addAttribute("brands",brand);
//        List<Item> item=userRepository.get_all_item_by_supplier(id);
//        m.addAttribute("items",item);
        return "/customer/detail.jsp";
    }


    @RequestMapping("customer/remove/{id}")
    public String remove_customer(@PathVariable int id) {
        userRepository.remove_customer(id);
        return "redirect:/supplier";
    }


    @RequestMapping("reciept")
    public ModelAndView get_reciept() {
        ModelAndView m = new ModelAndView("/rc/list.jsp");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Customer c = userRepository.get_customer_by_username(username);
        m.addObject("items", userRepository.get_reciept_by_customer(c.getCustomer_id()));
        return m;

    }

    @RequestMapping("reciept/{id}")
    public ModelAndView get_reciept_detail(@PathVariable int id) {
        ModelAndView m = new ModelAndView("/rc/detail.jsp");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Customer c = userRepository.get_customer_by_username(username);
        m.addObject("items", userRepository.get_rc_by_id(id));
        return m;

    }
}