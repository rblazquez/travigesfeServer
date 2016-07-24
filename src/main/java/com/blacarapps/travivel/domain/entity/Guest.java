package com.blacarapps.travivel.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import lombok.Data;

import org.hibernate.validator.constraints.Email;

@Entity
@Data
public class Guest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    private String name;
    private String lastName;
	@Email private String email;
	private String phoneNo;
	@Min(0)	private Integer age;
	private String country;
}
