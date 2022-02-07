package com.harustation.backend.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Store")
@Getter
public class Store {
    @Id @GeneratedValue
    private Long store_idx;
    private String store_name;
    private String store_image;
    private String store_hashtag;



}
