package ru.skypro.hw28.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.skypro.hw28.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ServiceDepartmentImpl implements ServiceDepartment {

    private final ServiceEmployee serviceEmployee;
    @Autowired
    public ServiceDepartmentImpl(ServiceEmployee serviceEmployee) {
        
        this.serviceEmployee = serviceEmployee;
    }
    @Override
    public Employee findEmployeeWithMinSalaryByDepartment(int departmentId) {
        return serviceEmployee.getEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new NoSuchElementException("Employee not found"));
    }
    @Override
    public Employee findEmployeeWithMaxSalaryByDepartment(int departmentId) {
        return serviceEmployee.getEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new NoSuchElementException("Employee not found"));
    }
    @Override
    public int calculateTotalSalaryByDepartment(int departmentId) {
        return serviceEmployee.getEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .mapToInt(Employee::getSalary)
                .sum();
    }
    @Override
    public Map<Integer, List<Employee>> printEmployeesByDepartment(int departmentId) {
        return serviceEmployee.getEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
    @Override
    public Map<Integer, List<Employee>> printAllEmployees() {
        return serviceEmployee.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }

}
