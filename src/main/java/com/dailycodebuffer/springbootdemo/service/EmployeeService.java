package com.dailycodebuffer.springbootdemo.service;

import com.dailycodebuffer.springbootdemo.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    Employee Save(Employee employee);

    Employee getEmployeeById(String id);

    String deleteEmployeeById(String id);
}
