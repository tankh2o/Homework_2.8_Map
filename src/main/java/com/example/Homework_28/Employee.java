package com.example.Homework_28;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private Integer departmentId;
    private Integer salaryEmployee;

    public static Employee createEmployee(String firstName, String lastName, Integer department, Integer salaryEmployee) {
        Employee employee = new Employee(firstName, lastName, department, salaryEmployee);
        employee.firstName = firstName;
        employee.lastName = lastName;
        employee.departmentId = department;
        employee.salaryEmployee = salaryEmployee;
        return employee;
    }

    public Employee(String firstName, String lastName, Integer department, Integer salaryEmployee) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = department;
        this.salaryEmployee = salaryEmployee;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public Integer getSalaryEmployee() {
        return salaryEmployee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salaryEmployee, salaryEmployee) == 0 && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(departmentId, employee.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departmentId, salaryEmployee);
    }

    @Override
    public String toString() {
        return ". Ф.И.О. работника: " + this.firstName + " " + this.lastName
                + ". Отдел: " + this.departmentId
                + ". Зарплата: " + this.salaryEmployee;
    }
}

