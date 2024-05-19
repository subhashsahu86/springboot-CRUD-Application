package com.subh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subh.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
	
	
	

}
