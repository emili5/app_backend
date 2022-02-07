package com.harustation.backend.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name="Order_refund")
public class Order_refund {
    @Id @GeneratedValue
    private Long refund_idx;
    private String refund_available;
    private String refund_account;
    private String refund_reason;

}
