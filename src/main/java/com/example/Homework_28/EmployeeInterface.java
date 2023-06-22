package com.example.Homework_28;

import java.util.Map;

public interface EmployeeInterface {
    Map<String, Employee> findOutNumberEmployees();

    String findEmployees(String firstName, String lastName) throws EmployeeStorageIsFullException;

    String addEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    String removeEmployee(String firstName, String lastName);
}
