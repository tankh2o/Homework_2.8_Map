package com.example.Homework_28;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentInterface departmentInterface;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public DepartmentController(DepartmentInterface departmentInterface) {
        this.departmentInterface = departmentInterface;
    }

    @GetMapping("/salary/max")
    public Employee findMaxSalaryAmongEmployee(@RequestParam("departmentId") Integer departmentId) {
        return departmentInterface.findMaxSalaryAmongEmployee(departmentId);
    }

    @GetMapping("/salary/min")
    public Employee findMinSalaryAmongEmployee(@RequestParam("departmentId") Integer departmentId) {
        return departmentInterface.findMinSalaryAmongEmployee(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> findOutNumberEmployees(
            @RequestParam(name = "departmentId", required = false) Integer departmentId) {
        return departmentInterface.findOutNumberEmployees(departmentId);
    }
}