package com.example.Homework_28;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements DepartmentInterface {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMaxSalaryAmongEmployee(Integer departmentId) {
        return employeeService.findOutNumberEmployees().values().stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .max(Comparator.comparingInt(Employee::getSalaryEmployee))
                .orElse(null);
    }

    @Override
    public Employee findMinSalaryAmongEmployee(Integer departmentId) {
        return employeeService.findOutNumberEmployees().values().stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .min(Comparator.comparingInt(Employee::getSalaryEmployee))
                .orElse(null);
    }

    @Override
    public Map<Integer, List<Employee>> findOutNumberEmployees(Integer departmentId) {
        return employeeService.findOutNumberEmployees().values().stream()
                .filter(employee -> departmentId == null || employee.getDepartmentId().equals(departmentId))
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
