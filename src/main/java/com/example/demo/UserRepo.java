package com.example.demo;

import com.example.demo.entity.Brand;
import com.example.demo.entity.Item;
import com.example.demo.entity.Supplier;
import com.example.rowmapper.BrandRowMapper;
import com.example.rowmapper.ItemRowMapper;
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


}
