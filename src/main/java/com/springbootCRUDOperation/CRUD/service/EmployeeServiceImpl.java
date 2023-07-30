package com.springbootCRUDOperation.CRUD.service;

import com.springbootCRUDOperation.CRUD.model.Employee;
import com.springbootCRUDOperation.CRUD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        // TODO Auto-generated method stub
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Employee not found for id ::" + id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    /* public Employee get(long id){
           return employeeRepository.findById(id).get();
           8/
     */
    @Override
    public Employee get(long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.orElse(null);
    }

}

