package com.example.Homework_28;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private int department;
    private double salaryEmployee;

    public static Employee createEmployee(String firstName, String lastName, int department, int salaryEmployee) {
        Employee employee = new Employee(firstName, lastName, department, salaryEmployee);
        employee.firstName = firstName;
        employee.lastName = lastName;
        employee.department = department;
        employee.salaryEmployee = salaryEmployee;
        return employee;
    }

    public Employee(String firstName, String lastName, int department, int salaryEmployee) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salaryEmployee = salaryEmployee;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalaryEmployee() {
        return salaryEmployee;
    }

    public void setSalaryEmployee(double salaryEmployee) {
        this.salaryEmployee = salaryEmployee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return ". Ф.И.О. работника: " + this.firstName + " " + this.lastName
                + ". Отдел: " + this.department
                + ". Зарплата: " + this.salaryEmployee;
    }
}

