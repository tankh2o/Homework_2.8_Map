package com.example.Homework_28;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeInterface employeeInterface;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public EmployeeController(EmployeeInterface employeeInterface) {
        this.employeeInterface = employeeInterface;
    }

    @GetMapping(path = "/find/out")
    public Map<String, Employee> findOutNumberEmployees() {
        return (Map<String, Employee>) employeeInterface.findOutNumberEmployees();
    }

    @GetMapping(path = "/add")
    public String addEmployee(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value = "department") int department,
            @RequestParam(value = "salaryEmployee") double salaryEmployee) {
        return employeeInterface.addEmployee(firstName, lastName, department, .salaryEmployee);
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value = "department") int department,
            @RequestParam(value = "salaryEmployee") double salaryEmployee) {
        return employeeInterface.removeEmployee(firstName, lastName, department, salaryEmployee);
    }

    @GetMapping(path = "/find")
    public String findEmployee(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value = "department") int department,
            @RequestParam(value = "salaryEmployee") double salaryEmployee) {
        return employeeInterface.findEmployee(firstName, lastName, department, salaryEmployee);
    }
}
