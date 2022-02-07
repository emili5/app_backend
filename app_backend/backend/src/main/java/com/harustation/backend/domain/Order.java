package com.harustation.backend.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="Order(주문/결제)")
@Getter
public class Order {
    @Id @GeneratedValue
    private Long order_idx;
    private Timestamp order_date;
    private String receive_name;
    private String receive_phone;
    private String receive_email;
    private String address1;
    private String address2;
    private String address3;
    private String refund_bank;
    private String refund_account;
    private String refund_name;
    private int use_coupon;
    private int use_point;
    private String payment;

}
