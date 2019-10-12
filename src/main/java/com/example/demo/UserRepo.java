package com.example.demo;

import com.example.demo.auth.User;
import com.example.demo.entity.*;
import com.example.rowmapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
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
        String sql = "insert into item(brand_id,category,cost_price,imgurl,mrp,name,qt_avail,rating,sold_qt,discount,description) values(?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, item.getBrand_id(), item.getCategory(), item.getCost_price(), item.getImgurl(), item.getMrp(), item.getName(),
                item.getQt_avail(), item.getRating(), item.getSold_qt(), item.getDiscount(), item.getDescription());
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
    public List<Supplier> get_all_supplier() {
        String sql = "select * from supplier";
        return jdbcTemplate.query(sql, new SupplierRowMapper());
    }

    public Supplier get_supplier(int id) {
        String sql = "select * from supplier where supplier_id=" + id;
        return jdbcTemplate.queryForObject(sql, new SupplierRowMapper());
    }

    public List<Brand> get_all_brand_by_supplier(int id) {
        String sql = "select * from brand where brand_id in(select brand_id from item where item_id in (select item_id from supplier_item where supplier_id=" + id + "))";
        return jdbcTemplate.query(sql, new BrandRowMapper());

    }

    public List<Item> get_all_item_by_supplier(int id) {

        String sql = "select * from item where item_id in(select item_id from supplier_item where supplier_id=" + id + ")";
        return jdbcTemplate.query(sql, new ItemRowMapper());

    }

    public void update_supplier(Supplier s) {
        String sql = "update supplier set person_id=? where supplier_id=?";
        jdbcTemplate.update(sql, s.getPerson_id(), s.getSupplier_id());
    }

    public void addSupplier(Supplier s) {
        String sql = "insert into supplier(person_id) values(?)";
        jdbcTemplate.update(sql, s.getPerson_id());
    }

    public void remove_supplier(int id) {
        String sql = "delete from personal_info where person_id=" + id;
        jdbcTemplate.update(sql);
    }


    //------------------------------------------------------Expenses-------------------
    public Expenses get_Expence(int id) {
        String sql = "select * from expenses where expenses_id=" + id;
        return jdbcTemplate.queryForObject(sql, new ExpensesRowMapper());

    }

    public void addExpenses(Expenses exp) {
        String sql = "insert into expenses(amount,description,type) values(?,?,?)";
        jdbcTemplate.update(sql, exp.getAmount(), exp.getDescription(), exp.getType());
    }

    public void update_Exenses(Expenses exp) {
        String sql = "update expenses set amount=?,description=?,type=? where expenses_id=?";
        jdbcTemplate.update(sql, exp.getAmount(), exp.getDescription(), exp.getType(), exp.getExpenses_id());
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
    public void update_personal_info(Personal_info p) {
        String sql = "update  personal_info set gender=?,address=?,adharno=?,dob=?,email=?,firstname=?,lastname=?,phoneno=?,zipcode=? where person_id=?";
        jdbcTemplate.update(sql, p.getGender(), p.getAddress(), p.getAdharno(), p.getDob(), p.getEmail(), p.getFirstname(), p.getLastname(), p.getPhoneno(), p.getZipcode(), p.getPerson_id());


    }

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

    public void update_employee(Employee e) {
        String sql = "update  employee set balance=?,salary=? where employee_id=?";
        jdbcTemplate.update(sql, e.getBalance(), e.getSalary(), e.getEmployee_id());

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

    public Customer get_customer_by_username(String username) {
        String sql = "select * from customer where username='" + username + "'";
        System.out.println(sql);
        return jdbcTemplate.queryForObject(sql, new CustomerRowMapper());
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
        String sql = "insert into emi(intrest,customer_id,item_id,paid_fraction,pending,tot_fraction,principal) values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, e.getIntrest(), e.getCustomer_id(), e.getItem_id(), e.getPaid_fraction(), e.getPending(), e.getTot_fraction(), e.getPrincipal());
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

    public void update_Tax(Income_tax i) {
        String sql = "update income_tax set amount=?, penality=? where income_tax_id=?";

        jdbcTemplate.update(sql, i.getAmount(), i.getPenality(), i.getIncome_tax_id());
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
        String sql = "select * from user where username='" + username + "'";
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

    // -----------------------------------------Wages----------------------------------------------
    public void add_Wage(Wages w) {
        String sql = "insert into wages(amount,employee_id) values(?,?)";
        jdbcTemplate.update(sql, w.getAmount(), w.getEmployee_id());
    }

    public Wages get_Wages(int id) {
        String sql = "select * from wages where wage_id=" + id;
        return jdbcTemplate.queryForObject(sql, new WagesRowMapper());
    }

    public List<Wages> get_all_Wage_by_employee(int id) {
        String sql = "select *  from  wages where employee_id=" + id;
        return jdbcTemplate.query(sql, new WagesRowMapper());
    }


    public List<Wages> get_all_Wages() {
        String sql = "select *  from  wages ";
        return jdbcTemplate.query(sql, new WagesRowMapper());
    }

    public void remove_Wage(int id) {
        String sql = "delete from wages where wage_id=?";
        jdbcTemplate.update(sql, id);
    }

    public Personal_info get_Person_by_email(String e) {
        String sql = "select * from personal_info where email='" + e + "'";
        System.out.println(sql);
        return jdbcTemplate.queryForObject(sql, new Personal_infoRowMapper());
    }

    //Cart---------------------------------------------------------------------------
    public Cart find_cart(Cart cart) {
        String sql = "select * from cart where item_id=" + cart.getItem_id() + " and customer_id=" + cart.getCustomer_id();
        System.out.println(sql);
        return jdbcTemplate.queryForObject(sql, new CartRowMapper());
    }

    public void add_cart(Cart cart) {
        String sql = "insert into cart(item_id,quantity,customer_id) values(?,?,?)";
        jdbcTemplate.update(sql, cart.getItem_id(), cart.getQuantity(), cart.getCustomer_id());

    }

    public void update_cart(Cart cart) {
        String sql = "update cart set quantity=? where item_id=" + cart.getItem_id() + " and customer_id=" + cart.getCustomer_id();
        jdbcTemplate.update(sql, cart.getQuantity());

    }

    public void remove_cart(Cart cart) {
        String sql = "delete from cart where  item_id=" + cart.getItem_id() + " and customer_id=" + cart.getCustomer_id();
        jdbcTemplate.update(sql);

    }

    public List<Cart> get_cart_by_customer(int customer_id) {
        String sql = "select * from cart where customer_id=" + customer_id;
        System.out.println(sql);
        return jdbcTemplate.query(sql, new CartRowMapper());
    }

    public Vouchers get_voucher(int id) {
        String sql = "select * from voucher where voucher_id=" + id;
        return jdbcTemplate.queryForObject(sql, new VoucherrowMapper());
    }

    public long add_reciept(Reciept r) {
        String sql = "insert into reciept(amount,amount_payed,customer_id,discount) values(?,?,?,?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        // the name of the generated column (you can track more than one column)
        String id_column = "receipt_id";

        // the update method takes an implementation of PreparedStatementCreator which could be a lambda
        jdbcTemplate.update(con -> {
                    PreparedStatement ps = con.prepareStatement(sql, new String[]{id_column});
                    ps.setInt(1, r.getAmount());
                    ps.setInt(2, r.getAmount_payed());
                    ps.setInt(3, r.getCustomer_id());
                    ps.setInt(4, r.getDiscount());
                    return ps;
                }
                , keyHolder);

        // after the update executed we can now get the value of the generated ID
        return (long) keyHolder.getKey();


//        jdbcTemplate.update(sql,r.getAmount(),r.getAmount_payed(),r.getCustomer_id(),r.getDiscount());
    }

    public void update_voucher(Vouchers v) {
        String sql = "update voucher set active=? where voucher_id=?";
        jdbcTemplate.update(sql, v.getActive(), v.getVoucher_id());
    }

    public void add_ritem(Cart i, long receipt_id) {
        String sql = "insert into ritem(rid,item_id,mrp,discount,quantity) values(?,?,?,?,?)";
        jdbcTemplate.update(sql, receipt_id, i.getItem_id(), i.getI().getMrp(), i.getI().getDiscount(), i.getQuantity());
    }

    public void clear_cart(int customer_id) {
        String sql = "delete from cart where customer_id=" + customer_id;
        jdbcTemplate.update(sql);
    }

    public List<Vouchers> get_all_voucher(int customer_id) {

        String sql = "select * from voucher where customerid=" + customer_id;
        return jdbcTemplate.query(sql, new VoucherrowMapper());

    }

    public void add_voucher(Vouchers v2) {
        String sql = "insert into voucher(credits,customerid,active) values(?,?,?)";
        jdbcTemplate.update(sql, v2.getCredits(), v2.getCustomerid(), v2.getActive());
    }

    public List<Item> get_all_item_by_filter(ItemFilter f) {


        String sql = "select * from item where name like'%" + f.getName() + "%' and mrp between " + f.getMin_p() + " and " + f.getMax_p() + " and rating > " + f.getRating();
        if (f.getBrand_id() != 0)
            sql += " and brand_id=" + f.getBrand_id();
        sql += " and discount >=" + f.getDiscount();
        sql += " and qt_avail >=" + f.getQnt();
        sql += " and description like '%" + f.getName() + "%'";
        System.out.println(sql);
        return jdbcTemplate.query(sql, new ItemRowMapper());
    }

    public List<Employee> get_all_emp_by_filter(EmpFilter f) {
        String sql = "select * from employee where employee_id in(select a.employee_id  from (select * from employee  natural join personal_info where person_id >0";
        sql += " and salary >=" + f.getE().getSalary();
        sql += " and email like '" + f.getP().getEmail() + "%'";
        if (f.getP().getPhoneno() != "")
            sql += " and phoneno like '" + f.getP().getPhoneno() + "%'";
        if (f.getP().getFirstname() != "")
            sql += " and firstname like '" + f.getP().getFirstname() + "%'";
        if (f.getP().getLastname() != "")
            sql += " and lastname like '" + f.getP().getLastname() + "%'";
        if (f.getP().getZipcode() != "")
            sql += "and zipcode ='" + f.getP().getZipcode() + "'";
        if (f.getAge() != 0)
            sql += "and datediff(curDate(),dob)/365 >=" + f.getAge();

        sql += ")as a)";

        System.out.println(sql);
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    public List<Reciept> get_reciept_by_customer(int id) {
        String sql = "select * from reciept where customer_id=" + id;
        return jdbcTemplate.query(sql, new RcRowMapper());
    }

    public Reciept get_rc_by_id(int id) {
        String sql = "select * from reciept where receipt_id=" + id;
        return jdbcTemplate.queryForObject(sql, new RcRowMapper());
    }
}

