package com.springbootCRUDOperation.CRUD.service;

import com.springbootCRUDOperation.CRUD.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(long id);

    void deleteEmployeeById(long id);

    List<Employee> listAll();

    Employee get(long id);
}
