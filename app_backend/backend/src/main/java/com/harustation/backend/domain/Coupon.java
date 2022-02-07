package com.harustation.backend.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Coupon")
@Getter
public class Coupon {
    @Id @GeneratedValue
    private Long coupon_idx;
    private String coupon_name;
    private String coupon_content;


}
