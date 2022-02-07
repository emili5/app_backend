package com.harustation.backend.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name="Preference")
public class Preference {
    //preference entity DB 수정 필요
    @Id @GeneratedValue
    private Long preference_idx;
    private Long folder_name;
}
