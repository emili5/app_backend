package com.harustation.backend.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Deliver_address")
@Getter
public class Deliver_address {
    @Id @GeneratedValue
    private Long User_user_idx;
    private String user_address1;
    private String user_address2;
    private String user_address3;

}
