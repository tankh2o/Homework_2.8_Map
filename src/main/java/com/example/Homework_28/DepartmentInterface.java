package com.example.Homework_28;

import java.util.List;
import java.util.Map;

public interface DepartmentInterface {
    Employee findMaxSalaryAmongEmployee(Integer departmentId);

    Employee findMinSalaryAmongEmployee(Integer departmentId);

    Map<Integer, List<Employee>> findOutNumberEmployees(Integer departmentId);
}
