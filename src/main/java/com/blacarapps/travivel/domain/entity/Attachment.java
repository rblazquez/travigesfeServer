package com.blacarapps.travivel.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

import com.blacarapps.travivel.domain.ATTACHMENT_TYPE;

@Entity
@Data
public class Attachment implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Lob
    Property property;
	
    private String name;
	
    private String description;
	
	@Enumerated(EnumType.STRING)
	private ATTACHMENT_TYPE type;
	
	private String link;
}
