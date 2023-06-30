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
        Map<String, Employee> employees = (Map<String, Employee>) employeeInterface.findOutNumberEmployees();
        return employees;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value = "departmentId") Integer departmentId,
            @RequestParam(value = "salaryEmployee") Integer salaryEmployee) {
        return employeeInterface.addEmployee(firstName, lastName, departmentId, salaryEmployee);
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value = "departmentId") Integer departmentId,
            @RequestParam(value = "salaryEmployee") Integer salaryEmployee) {
        return employeeInterface.removeEmployee(firstName, lastName, departmentId, salaryEmployee);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value = "departmentId") Integer departmentId,
            @RequestParam(value = "salaryEmployee") Integer salaryEmployee) {
        return employeeInterface.findEmployee(firstName, lastName, departmentId, salaryEmployee);
    }
}
