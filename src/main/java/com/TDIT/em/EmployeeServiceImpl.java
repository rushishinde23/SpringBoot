package com.TDIT.em;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> readEmployee() {
        List<EmployeeEntity> employeesEntity=employeeRepository.findAll();
        System.out.println(employeesEntity.toString());
        List<Employee> employees=new ArrayList<>();
        //BeanUtils.copyProperties(employeesEntity,employees);
        for(EmployeeEntity employeeEntity: employeesEntity){
            Employee e=new Employee();
            e.setId(employeeEntity.getId());
            e.setName(employeeEntity.getName());
            e.setCity(employeeEntity.getCity());
            e.setEmail(employeeEntity.getEmail());
            employees.add(e);
        }
        System.out.println(employees.toString());
        return employees;
    }

    @Override
    public String createEmployee(Employee employee) {
        System.out.println(employee.toString());
        EmployeeEntity employeeEntity=new EmployeeEntity();
        BeanUtils.copyProperties(employee,employeeEntity);
        employeeRepository.save(employeeEntity);
        return "Employee added Successfully";
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity emp=employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return true;
    }

    @Override
    public Employee findEmployeeById(Long id) {
        EmployeeEntity employeeEntity=employeeRepository.findById(id).get();
        Employee employee=new Employee();
        employee.setId(id);
        employee.setName(employeeEntity.getName());
        employee.setCity(employeeEntity.getCity());
        employee.setEmail(employeeEntity.getEmail());

        return employee;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEntity employeeEntity=employeeRepository.findById(id).get();
        employeeEntity.setName(employee.getName());
        employeeEntity.setCity(employee.getCity());
        employeeEntity.setEmail(employee.getEmail());
        employeeRepository.save(employeeEntity);
        return "Employee updated successfully";
    }
}
