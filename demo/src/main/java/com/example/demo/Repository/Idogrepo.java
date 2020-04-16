package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Dog;

public interface Idogrepo  extends JpaRepository<Dog,Long>{

	
}
