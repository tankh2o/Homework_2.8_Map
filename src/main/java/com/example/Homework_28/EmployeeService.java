package com.example.Homework_28;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService implements EmployeeInterface {
    public static Map<String, Employee> employees = new HashMap<>(Map.of());

    public static final int MAX_SIZE = 5;

    @Override
    public String addEmployee(String firstName, String lastName, int department, int salaryEmployee)
            throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName, department, salaryEmployee);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Данный сотрудник уже есть в базе данных.");
        }
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("Вы забыли прописать фамилию или имя сотрудника.");
        }
        if (employees.size() == MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирме.");
        }
        employees.put(employee.getFullName(), employee);
        return "В базу данных добавлен новый сотрудник: " + employee.getFirstName() + " " + employee.getLastName();
    }

    @Override
    public String removeEmployee(String firstName, String lastName, int department, int salaryEmployee) {
        Employee employee = new Employee(firstName, lastName, department, salaryEmployee);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("Такого сотрудника нет в базе данных.");
        }
        employees.remove(employee.getFullName());
        return "Сотрудник " + firstName + " " + lastName + " удален из базы данных.";
    }

    @Override
    public String findEmployee(String firstName, String lastName, int department, int salaryEmployee) throws EmployeeStorageIsFullException {
        Employee employee = new Employee(firstName, lastName, department, salaryEmployee);
        if (employees.containsKey(employee.getFullName())) {
            final String employeeDescription =
                    "Имя и фамилия: " + employee.getLastName()
                            + " " + employee.getFirstName();
            return employeeDescription;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public void sumSalaryInMonth() {
        int sumSalary = 0;
        for (Employee inMonth : employees) {
            sumSalary += inMonth.getSalaryEmployee();
        }
        System.out.println("Сумма затрат на выплату зарплаты сотрудникам в месяц: " + sumSalary);
    }

    @Override
    public void findMaxSalaryAmongEmployee() {
        double maxSalary = employees[0].getSalaryEmployee();
        for (Employee max : employees) {
            if (maxSalary < max.getSalaryEmployee()) {
                maxSalary = max.getSalaryEmployee();
            }
        }
        System.out.println("Максимальная зарплата среди сотрудников: " + maxSalary);
    }

    @Override
    public void findMinSalaryAmongEmployee() {
        double minSalary = employees[0].getSalaryEmployee();
        for (Employee min : employees) {
            if (minSalary > min.getSalaryEmployee()) {
                minSalary = min.getSalaryEmployee();
            }
        }
        System.out.println("Минимальная зарплата среди сотрудников: " + minSalary);
    }

    @Override
    public void findAverageValueSalaries() {
        int sumSalary = 0;
        for (Employee value : employees.size()) {
            sumSalary += value.getSalaryEmployee();
        }
        sumSalary = sumSalary / employees.size();
        System.out.println("Среднее значение зарплат: " + sumSalary);
    }

    @Override
    public Collection<Employee> findOutNumberEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public void printFullNameAllEmployees() {
        String fullName = new String();
        for (Employee employeeName : employees) {
            fullName += employeeName.getFullName();
        }
        System.out.println("Список сотрудников:");
        printFullName();
    }
    public static void printFullName() {
        int n = 1;
        while (n < employees.size()) {
            for (int i = 0; i < employees.size(); i++) {
                System.out.println(n + ". " + employees[i].getFullName());
                n++;
            }
        }
    }

}
