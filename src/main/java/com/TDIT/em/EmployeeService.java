package com.TDIT.em;

import java.util.List;

public interface EmployeeService {
     List<Employee> readEmployee();
     String createEmployee(Employee employee);
     boolean deleteEmployee(Long id);
     Employee findEmployeeById(Long id);
     String updateEmployee(Long id, Employee employee);
}
