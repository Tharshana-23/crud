package com.example.demo.model;


import javax.validation.constraints.NotBlank;
import javax.persistence.*;

@Entity
@Table(name="dog")
public class Dog {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Long id;
	
	@Column
	@NotBlank(message="Name is mandatory")
	private String name;
	
	@Column
	@NotBlank(message="Email is madatory")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	
	
}
