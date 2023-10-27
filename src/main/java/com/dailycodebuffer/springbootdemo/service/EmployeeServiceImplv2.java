package com.dailycodebuffer.springbootdemo.service;

import com.dailycodebuffer.springbootdemo.entity.EmployeeEntity;
import com.dailycodebuffer.springbootdemo.model.Employee;
import com.dailycodebuffer.springbootdemo.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImplv2 implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepo;

    @Override
    public List<Employee> getEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepo.findAll();

        return employeeEntities.stream()
                .map(empEntity -> {
                    Employee emp = new Employee();
                    BeanUtils.copyProperties(empEntity,emp);
                    return emp;
                }).collect(Collectors.toList());
    }

    @Override
    public Employee Save(Employee employee) {
        if(employee.getEmployeeId() == null){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        EmployeeEntity emp = new EmployeeEntity();
        BeanUtils.copyProperties(employee,emp);
        employeeRepo.save(emp);
        return employee;
    }

    @Override
    public Employee getEmployeeById(String id) {
        EmployeeEntity employeeEntity = employeeRepo.findById(id).get();
        Employee emp = new Employee();
        BeanUtils.copyProperties(employeeEntity,emp);
        return emp;
    }

    @Override
    public String deleteEmployeeById(String id) {
        employeeRepo.deleteById(id);
        return "Employee deleted";
    }
}
