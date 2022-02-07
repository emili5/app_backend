package com.harustation.backend.domain;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Curation")
@Getter
public class Curation {
    @Id @GeneratedValue
    private Long curation_idx;
    private String curation_image;
    private String curation_title;
    private String curation_content;
    private String curation_tag;
}
