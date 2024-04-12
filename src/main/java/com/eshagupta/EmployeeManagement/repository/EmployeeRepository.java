package com.eshagupta.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshagupta.EmployeeManagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
