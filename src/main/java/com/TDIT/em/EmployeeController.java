package com.TDIT.em;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.readEmployee();
    }

    @PostMapping("/employees")
    public String addEmployee(@RequestBody Employee employee){
        System.out.println(employee.toString());
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public boolean deleteEmployeeById(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/employees/{id}")
    public Employee findEmployeeById(@PathVariable Long id){
       return employeeService.findEmployeeById(id);
    }

    @PutMapping("/employees/{id}")
    public String updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }
}
