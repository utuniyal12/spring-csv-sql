package com.example.springcsvtodbdemo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springcsvtodbdemo.entity.Person;

@Repository
public interface MyRepository extends JpaRepository<Person,String>{
	
	

}
