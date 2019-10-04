package com.example.demo;

import com.example.demo.auth.User;
import com.example.demo.entity.*;
import com.example.rowmapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;


    // we are autowiring jdbc template,
    // using the properties we have configured spring automatically
    // detects and creates jdbc template using the configuration


    public String findCustomerNameById(Long id) {

        String sql = "SELECT NAME FROM CUSTOMER WHERE ID = ?";

        return jdbcTemplate.queryForObject(
                sql, new Object[]{id}, String.class);

    }

    //--------------------------------------item-----------------------
    public List<Item> get_all_item() {
        String sql = "select * from item";
        return jdbcTemplate.query(sql, new ItemRowMapper());

    }

    public void addItem(Item item) {
        String sql = "insert into item(brand_id,category,cost_price,imgurl,mrp,name,qt_avail,rating,sold_qt,voucher_credit,discount) values(?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, item.getBrand_id(), item.getCategory(), item.getCost_price(), item.getImgurl(), item.getMrp(), item.getName(),
                item.getQt_avail(), item.getRating(), item.getSold_qt(), item.getVoucher_credit(), item.getDiscount());
    }

    public Item get_item(int id) {
        String sql = "Select * from item where item_id=" + id;
        return jdbcTemplate.queryForObject(sql, new ItemRowMapper());

    }

    public List<Item> get_all_item_by_brand(int brand_id) {
        String sql = "select * from item where brand_id=" + brand_id;
        return jdbcTemplate.query(sql, new ItemRowMapper());
    }


    public void remove_item(int id) {
        String sql = "delete from item where item_id=" + id;
        jdbcTemplate.update(sql);
    }

    //------------------------------------brand-------------------------
    public Brand get_brand(int brand_id) {
        String sql = "select * from brand where brand_id=" + brand_id;
        return jdbcTemplate.queryForObject(sql, new BrandRowMapper());
    }

    public List<Brand> get_all_brand() {
        String sql = "select * from brand";
        return jdbcTemplate.query(sql, new BrandRowMapper());
    }

    public void addBrand(Brand brand) {
        String sql = "insert into brand(brand_name,logo) values(?,?)";
        jdbcTemplate.update(sql, brand.getBrand_name(), brand.getLogo());
    }

    public void remove_brand(int brand_id) {
        String sql = "delete from brand where brand_id=" + brand_id;
        jdbcTemplate.update(sql);
    }


    public void update_Brand(Brand brand) {
        String sql = "update  brand set brand_name=?,logo=? where brand_id=?";
        jdbcTemplate.update(sql, brand.getBrand_name(), brand.getLogo(), brand.getBrand_id());
    }

    //-----------------------------------------------supplier-------------------------
    public Brand get_supplier(int id) {
        String sql = "select * from supplier where supplier_id=" + id;
        return jdbcTemplate.queryForObject(sql, new BrandRowMapper());
    }

    public List<Brand> get_all_brand_by_supplier(int id) {
        String sql = "select * from brand where brand_id in(select brand_id from item where item_id in (select item_id from supplier_item where supplier_id=" + id + "))";
        return jdbcTemplate.query(sql, new BrandRowMapper());

    }

    public List<Item> get_all_item_by_supplier(int id) {

        String sql = "select * from item where item_id in(select item_id from supplier_item where supplier_id=" + id + ")";
        return jdbcTemplate.query(sql, new ItemRowMapper());

    }

    public void addSupplier(Supplier s) {
        String sql = "insert into supplier values(?,?)";
        jdbcTemplate.update(sql, s.getSupplier_id(), s.getPerson_id());
    }

    public void remove_supplier(int id) {
        String sql = "delete from supplier where supplier_id=" + id;
        jdbcTemplate.update(sql);
    }

    //------------------------------------------------------Expenses-------------------
    public void addExpenses(Expenses exp) {
        String sql = "insert into expenses(amount,description,type) values(?,?,?)";
        jdbcTemplate.update(sql, exp.getAmount(), exp.getDescription(), exp.getType());
    }

    public List<Expenses> get_all_Expenses() {
        String sql = "select * from expenses";
        return jdbcTemplate.query(sql, new ExpensesRowMapper());
    }

    public void remove_expenses(int id) {
        String sql = "delete from expenses where expenses_id=?";
        jdbcTemplate.update(sql, id);
    }

    //-----------------------------------------------------Personal_info--------------------------
    public void add_perosnal_info(Personal_info p) {
        String sql = "insert into personal_info(gender,address,adharno,dob,email,firstname,lastname,phoneno,zipcode) values(?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, p.getGender(), p.getAddress(), p.getAdharno(), p.getDob(), p.getEmail(), p.getFirstname(), p.getLastname(), p.getPhoneno(), p.getZipcode());
    }

    public Personal_info get_perosnal_info_by_id(int id) {
        String sql = "select * from personal_info where person_id=" + id;
        return jdbcTemplate.queryForObject(sql, new Personal_infoRowMapper());
    }

    public void remove_personal_info(int id) {
        String sql = "delete from personal_info where person_id=?";
        jdbcTemplate.update(sql, id);
    }

    //--------------------------------------------------Employee------------------------------------
    public void add_employee(Employee e) {
        String sql = "insert into employee(balance,person_id,salary,username) values(?,?,?,?)";
        jdbcTemplate.update(sql, e.getBalance(), e.getPerson_id(), e.getSalary(), e.getUsername());
    }

    public List<Employee> get_all_employee() {
        String sql = "select * from employee";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    public Employee get_employee(int id) {
        String sql = "select * from employee where employee_id=" + id;
        return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper());

    }

    public void remove_employee(int id) {
        String sql = "delete from employee where employee_id=" + id;
        jdbcTemplate.update(sql);
    }

    //----------------------------------------------Customer---------------------------------------
    public void add_Customer(Customer c) {
        String sql = "insert into customer(person_id,username) values(?,?)";
        jdbcTemplate.update(sql, c.getPerson_id(), c.getUsername());
    }

    public Customer get_customer(int id) {
        String sql = "select * from customer where customer_id=" + id;
        return jdbcTemplate.queryForObject(sql, new CustomerRowMapper());
    }

    public List<Customer> get_all_customer() {
        String sql = "select *  from customer";
        return jdbcTemplate.query(sql, new CustomerRowMapper());
    }

    public void remove_customer(int id) {
        String sql = "delete from customer where customer_id=" + id;
        jdbcTemplate.update(sql);
    }

    //----------------------------------------Emi-------------------------------------------------------
    public void add_Emi(Emi e) {
        String sql = "insert into emi(intrest,customer_id,item_id,paid_fraction,pending,tot_fraction) values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql, e.getIntrest(), e.getCustomer_id(), e.getItem_id(), e.getPaid_fraction(), e.getPending(), e.getTot_fraction());
    }

    public Emi get_Emi(int id) {
        String sql = "select * from emi where emi_id=" + id;
        return jdbcTemplate.queryForObject(sql, new EMIRowMapper());
    }

    public List<Emi> get_all_Emi() {
        String sql = "select *  from emi ";
        return jdbcTemplate.query(sql, new EMIRowMapper());
    }

    public List<Emi> get_all_Emi_by_customer(int id) {
        String sql = "select *  from emi where customer_id=" + id;
        return jdbcTemplate.query(sql, new EMIRowMapper());
    }

    public List<Emi> get_all_Emi_by_Item(int id) {
        String sql = "select *  from emi  where item_id=" + id;
        return jdbcTemplate.query(sql, new EMIRowMapper());
    }

    public void remove_emi(int id) {
        String sql = "delete from emi where emi_id=" + id;
        jdbcTemplate.update(sql);
    }

    //-----------------------------------------------------------feedback--------------------------------------
    public void add_Feedback(Feedback f) {
        String sql = "insert into feedback(customer_id,description,item_id,rating) values(?,?,?,?)";
        jdbcTemplate.update(sql, f.getCustomer_id(), f.getDescription(), f.getItem_id(), f.getRating());
    }

    public Feedback get_Feedback(int id) {
        String sql = "select * from feedback where feedback_id=" + id;
        return jdbcTemplate.queryForObject(sql, new FeedbackRowMapper());
    }

    public List<Feedback> get_all_Feedback() {
        String sql = "select *  from feedback ";
        return jdbcTemplate.query(sql, new FeedbackRowMapper());
    }

    public List<Feedback> get_all_Feedback_by_customer(int id) {
        String sql = "select *  from feedback where customer_id=" + id;
        return jdbcTemplate.query(sql, new FeedbackRowMapper());
    }

    public List<Feedback> get_all_Feedback_by_Item(int id) {
        String sql = "select *  from feedback  where item_id=" + id;
        return jdbcTemplate.query(sql, new FeedbackRowMapper());
    }

    public void remove_feedback(int id) {
        String sql = "delete from feedback where feedback_id=" + id;
        jdbcTemplate.update(sql);
    }

    //--------------------------------------------------------income_tax-----------------------
    public void add_Income_Tax(Income_tax i) {
        String sql = "insert into income_tax(amount,penality) values(?,?)";
        jdbcTemplate.update(sql, i.getAmount(), i.getPenality());
    }

    public Income_tax get_Income_tax(int id) {
        String sql = "select * from income_tax where income_tax_id=" + id;
        return jdbcTemplate.queryForObject(sql, new IncomeTaxRowMapper());
    }

    public List<Income_tax> get_all_Income_tax() {
        String sql = "select *  from income_tax ";
        return jdbcTemplate.query(sql, new IncomeTaxRowMapper());
    }

    public void remove_Income_tax(int id) {
        String sql = "delete from income_tax where income_tax_id=" + id;
        jdbcTemplate.update(sql);
    }

    //------------------------------------------------invoice-------------------------------------
    public void add_Invoice(Invoice i) {
        String sql = "insert into invoice(amount,supplierid) values(?,?)";
        jdbcTemplate.update(sql, i.getAmount(), i.getSupplierid());
    }

    public Invoice get_Invoice(int id) {
        String sql = "select * from invoice where invoice_id=" + id;
        return jdbcTemplate.queryForObject(sql, new InvoiceRowMapper());
    }

    public List<Invoice> get_all_Invoice() {
        String sql = "select *  from invoice ";
        return jdbcTemplate.query(sql, new InvoiceRowMapper());
    }

    public void remove_Invoice(int id) {
        String sql = "delete from invoice where invoice_id=" + id;
        jdbcTemplate.update(sql);
    }

    //-----------------------------------------User---------------------------------------------
    public void add_User(User u) {
        String sql = "insert into user(username,active,password,recovery_code,type) values(?,?,?,?,?)";
        jdbcTemplate.update(sql, u.getUsername(), u.getActive(), u.getPassword(), u.getRecovery_code(), u.getType());
    }

    public User get_User(String username) {
        String sql = "select * from user where username=" + username;
        return jdbcTemplate.queryForObject(sql, new UserRowMapper());
    }

    public List<User> get_all_Users() {
        String sql = "select *  from user ";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    public void remove_User(String username) {
        String sql = "delete from user where username=?";
        jdbcTemplate.update(sql, username);
    }
}

