package com.example.Homework_28;

import java.util.Collection;

public interface EmployeeInterface {
    Collection<Employee> findOutNumberEmployees();

    String addEmployee(String firstName, String lastName, int department, int salaryEmployee) throws EmployeeNotFoundException;

    String removeEmployee(String firstName, String lastName, int department, int salaryEmployee);

    String findEmployee(String firstName, String lastName, int department, int salaryEmployee) throws EmployeeStorageIsFullException;

    void sumSalaryInMonth();

    void findMaxSalaryAmongEmployee();

    void findMinSalaryAmongEmployee();
    void findAverageValueSalaries();
    void printFullNameAllEmployees();

}
