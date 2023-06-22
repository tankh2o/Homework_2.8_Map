package com.example.Homework_28;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;

    private String num;

    public static Employee createEmployee(String firstName, String lastName, String num) {
        Employee employee = new Employee(firstName, lastName);
        employee.firstName = firstName;
        employee.lastName = lastName;
        employee.num = num;
        return employee;
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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
        return "Сотрудник: " +
                "Фамилия - " + firstName + '\'' +
                ", Имя - " + lastName;
    }
}

