package com.afterAll.dao;

import com.afterAll.entity.Order;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
@Data
public class OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 添加单个
     *
     * @param order
     */
    public void add(Order order) {
        String insertSql = "insert into t_order value(?,?,?)";
        Object[] args = {order.getId(), order.getName(), order.getTime()};
        int update = jdbcTemplate.update(insertSql, args);
        System.out.println("insert: " + update);
    }

    /**
     * 更新单个
     *
     * @param order
     */
    public void update(Order order) {
        String updateSql = "update t_order set name=?,time=? where id=?";
        Object[] args = {order.getName(), order.getTime(), order.getId()};
        int update = jdbcTemplate.update(updateSql, args);
        System.out.println("update: " + update);
    }

    /**
     * 删除单个
     *
     * @param order
     */
    public void delete(Order order) {
        String deleteSql = "delete from t_order where id=?";
        Object[] args = {order.getId()};
        int update = jdbcTemplate.update(deleteSql, args);
        System.out.println("delete: " + update);
    }

    /**
     * 查询单个
     *
     * @param id
     */
    public void findOrderInfo(int id) {
        String querySql = "select * from t_order where id=?";
        Object[] args = {id};
        Order order = jdbcTemplate.queryForObject(querySql, new BeanPropertyRowMapper<>(Order.class), args);
        System.out.println(order);
    }

    /**
     * 查询所有
     */
    public void findAllOrder() {
        String queryAllSql = "select * from t_order";
        List<Order> orders = jdbcTemplate.query(queryAllSql, new BeanPropertyRowMapper<>(Order.class));
        System.out.println(orders.size());
    }

    public void batchAddOrder(List<Object[]> args) {
        String insertSql = "insert into t_order values(?,?,?)";
        int[] res = jdbcTemplate.batchUpdate(insertSql, args);
        System.out.println(Arrays.toString(res));
    }

    public void batchAddOrderObj(List<Order> orders) {
        List<Object[]> args = new ArrayList<>();
        for (Order order : orders) {
            Object[] arg = {order.getId(), order.getName(), order.getTime()};
            args.add(arg);
        }
        batchAddOrder(args);
    }

    public void batchUpdateOrder(List<Object[]> args) {
        String updateSql = "update t_order set name=?,time=? where id=?";
        int[] res = jdbcTemplate.batchUpdate(updateSql, args);
        System.out.println(Arrays.toString(res));
    }

    public void batchUpdateOrderObj(List<Order> orders) {
        List<Object[]> args = new ArrayList<>();
        for (Order order : orders) {
            Object[] arg = {order.getName(), order.getTime(), order.getId()};
            args.add(arg);
        }
        batchUpdateOrder(args);
    }

    public void batchDeleteOrder(List<Object[]> args) {
        String deleteSql = "delete from t_order where id=?";
        int[] res = jdbcTemplate.batchUpdate(deleteSql, args);
        System.out.println(Arrays.toString(res));
    }

    public void batchDeleteOrderObj(List<Order> orders) {
        List<Object[]> args = new ArrayList<>();
        for (Order order : orders) {
            Object[] arg = {order.getId()};
            args.add(arg);
        }
        batchDeleteOrder(args);
    }

}
