package com.harustation.backend.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "User")
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_idx;
    private String user_name;
    private String user_email;
    private String user_phone;
    private Date user_birthday;
    private String user_testresult;
    private int user_point;
    private Date user_create;
    private int user_logout;
    private String user_ordered;
}
