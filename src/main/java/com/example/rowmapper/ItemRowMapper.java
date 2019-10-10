package com.example.rowmapper;

import com.example.demo.entity.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRowMapper implements RowMapper<Item> {
    public Item mapRow(ResultSet rs, int rn) throws SQLException {
        Item i = new Item();
        i.setItem_id(rs.getInt("item_id"));
        i.setName(rs.getString("name"));
        i.setQt_avail(rs.getInt("qt_avail"));
        i.setRating(rs.getInt("rating"));
        i.setSold_qt(rs.getInt("sold_qt"));
        i.setCost_price(rs.getInt("cost_price"));
        i.setMrp(rs.getInt("mrp"));
        i.setBrand_id(rs.getInt("brand_id"));
        i.setDiscount(rs.getInt("discount"));
        i.setCategory(rs.getString("category"));
        i.setImgurl(rs.getString("imgurl"));
        i.setDescription(rs.getString("description"));
        return i;
    }
}
