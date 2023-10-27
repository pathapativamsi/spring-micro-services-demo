package com.dailycodebuffer.springbootdemo.service;

import com.dailycodebuffer.springbootdemo.error.EmployeeNotFoundException;
import com.dailycodebuffer.springbootdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<Employee>();

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public Employee Save(Employee employee) {
        if(employee.getEmployeeId() == null){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee getEmployeeById(String id) {

        return employees
                .stream()
                .filter(employee -> employee.getEmployeeId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(()-> new EmployeeNotFoundException("Employee not found with id: "+id));
    }

    @Override
    public String deleteEmployeeById(String id) {
        Employee emp = employees
                .stream()
                .filter(employee -> employee.getEmployeeId().equalsIgnoreCase(id))
                .findFirst()
                .get();
        employees.remove(emp);
        return "employee deleted with id: "+id;
    }
}
