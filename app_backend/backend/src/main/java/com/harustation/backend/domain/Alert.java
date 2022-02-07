package com.harustation.backend.domain;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Alert")
@Getter
public class Alert {
    @Id @GeneratedValue
    private Long alert_idx;
    private String alert_push;
    private String alert_sms;
    private String alert_email;

}
