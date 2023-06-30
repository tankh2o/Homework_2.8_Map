package com.example.Homework_28;

import java.util.Map;

public interface EmployeeInterface {
    Map<String, Employee> findOutNumberEmployees();

    Employee addEmployee(String firstName, String lastName, Integer departmentId, Integer salaryEmployee) throws EmployeeNotFoundException;

    String removeEmployee(String firstName, String lastName, Integer departmentId, Integer salaryEmployee);

    Employee findEmployee(String firstName, String lastName, Integer departmentId, Integer salaryEmployee) throws EmployeeStorageIsFullException;
}
