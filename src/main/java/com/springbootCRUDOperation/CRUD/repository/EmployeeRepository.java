package com.springbootCRUDOperation.CRUD.repository;

import com.springbootCRUDOperation.CRUD.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
