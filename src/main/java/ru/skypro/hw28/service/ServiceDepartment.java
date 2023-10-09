package ru.skypro.hw28.service;

import ru.skypro.hw28.model.Employee;

import java.util.List;
import java.util.Map;

public interface ServiceDepartment {

    Employee findEmployeeWithMinSalaryByDepartment(int departmentId);
    Employee findEmployeeWithMaxSalaryByDepartment(int departmentId);
    int calculateTotalSalaryByDepartment(int departmentId);
    Map<Integer, List<Employee>> printEmployeesByDepartment(int departmentId);
    Map<Integer, List<Employee>> printAllEmployees();
}
