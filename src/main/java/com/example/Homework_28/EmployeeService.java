package com.example.Homework_28;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService implements EmployeeInterface {
    public static Map<String, Employee> employees = new HashMap<String, Employee>(Map.of());

    public static final int MAX_SIZE = 5;

    @Override
    public Map<String, Employee> findOutNumberEmployees() {
        return employees;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, Integer departmentId, Integer salaryEmployee)
            throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName, departmentId, salaryEmployee);
        String employeeKey = getEmployeeKey(firstName, lastName);
        if (employees.containsKey(employeeKey)) {
            throw new EmployeeAlreadyAddedException("Данный сотрудник уже есть в базе данных.");
        }
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("Вы забыли прописать фамилию или имя сотрудника.");
        }
        if (employees.size() == MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирме.");
        }
        employees.put(employeeKey, employee);
        /*return "В базу данных добавлен новый сотрудник: " + employee.getFirstName() + " "
                + employee.getLastName() + " из отдела №" + employee.getDepartmentId()
                + " c заработной платой " + employee.getSalaryEmployee() + ".";*/
        return employees.get(employee);
    }

    private String getEmployeeKey(String firstName, String lastName) {
        return firstName + lastName;
    }

    @Override
    public String removeEmployee(String firstName, String lastName, Integer departmentId, Integer salaryEmployee) {
        Employee employee = new Employee(firstName, lastName, departmentId, salaryEmployee);
        if (!employees.containsKey(getEmployeeKey(firstName, lastName))) {
            throw new EmployeeNotFoundException("Такого сотрудника нет в базе данных.");
        }
        employees.remove(getEmployeeKey(firstName, lastName));
        return "Сотрудник " + firstName + " " + lastName + " удален из базы данных.";
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, Integer department, Integer salaryEmployee) throws EmployeeStorageIsFullException {
        if (!employees.containsKey(getEmployeeKey(firstName, lastName))) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
            /*final String employeeDescription =
                    "Имя и фамилия: " + employee.getLastName()
                            + " " + employee.getFirstName()
                            + ". Отдел: " + employee.getDepartmentId()
                            + " Заработная плата = " + employee.getSalaryEmployee();
            return employeeDescription;*/
        }
        return employees.get(getEmployeeKey(firstName, lastName));
    }
}
