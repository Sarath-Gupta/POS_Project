package com.increff.pos.dao;

import com.increff.pos.pojo.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public class OrdersDao extends AbstractDao<Orders> {

}