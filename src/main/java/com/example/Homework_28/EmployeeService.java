package com.example.Homework_28;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService implements EmployeeInterface {
    /*1. Перенести проект с EmployeeBook на Map в качестве хранилища
            сотрудников, реализовав методы добавления, удаления и поиска.

    2. Продумать контракт для ключей, чтобы сотрудник с одним ФИО
            существовал только в одном экземпляре, корректно добавлялся и удалялся.

    3. Избавиться от циклов в методах по поиску сотрудника, заменив на методы Map.

    4. Переработать все методы по работе с хранилищем на работу с методами Map.

    Задание может быть выполнено по-разному. Главное, чтобы были выполнены критерии.
            Если какой-то информации в задании не хватает, действуйте на свое усмотрение.*/
    public static Map<String, Employee> employees = new HashMap<>(Map.of());

    public static final int MAX_SIZE = 5;

    @Override
    public Map<String, Employee> findOutNumberEmployees() {
        return employees;
    }

    @Override
    public String findEmployees(String firstName, String lastName) throws EmployeeStorageIsFullException {
        Employee employee = new Employee(firstName, lastName);
        String employeeKey = getEmployeeKey(firstName, lastName);
        if (employees.containsKey(employeeKey)) {
            final String employeeDescription =
                    "Имя и фамилия: " + employee.getLastName()
                            + " " + employee.getFirstName();
            return employeeDescription;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public String addEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        //if (employees.containsKey(employee.getFirstName() + employee.getLastName())) {
        if (employees.containsKey(firstName + lastName)) {
            throw new EmployeeAlreadyAddedException("Данный сотрудник уже есть в базе данных.");
        }
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("Вы забыли прописать фамилию или имя сотрудника.");
        }
        if (employees.size() == MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирме.");
        }
        employees.put(employee.getFirstName() + employee.getLastName(), new Employee(firstName, lastName));
        return "В базу данных добавлен новый сотрудник: " + employee.getFirstName() + " " + employee.getLastName();
    }

    @Override
    public String removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        String employeeKey = getEmployeeKey(firstName, lastName);
        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет в базе данных.");
        }
        employees.remove(employee);
        return "Сотрудник " + firstName + " " + lastName + " удален из базы данных.";
    }

    public String getEmployeeKey(String firstName, String lastName) {
        return firstName + lastName;
    }
}
