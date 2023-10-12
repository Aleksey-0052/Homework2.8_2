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
        return serviceEmployee.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))   // для каждого сотрудника вызываем метод getSalary
                .orElseThrow(() -> new NoSuchElementException("Employee not found"));
    }
    @Override
    public Employee findEmployeeWithMaxSalaryByDepartment(int departmentId) {
        return serviceEmployee.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new NoSuchElementException("Employee not found"));
    }

    // Comparator работает так:
    // возвращает -1 (int), если больше правый объект (тот объект, с которым сравниваем текущий объект)
    // возвращает 0, если объекты равны
    // возвращает 1, если больше левый объект
    // comparator проходит по всем объектам
    // если -1, объект уходит налево
    // если 1, объект уходит направо


    @Override
    public int calculateTotalSalaryByDepartment(int departmentId) {
        return serviceEmployee.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .mapToInt(Employee::getSalary)
                .sum();
    }
    @Override
    public Map<Integer, List<Employee>> printEmployeesByDepartment(int departmentId) {
        return serviceEmployee.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
    @Override
    public Map<Integer, List<Employee>> printAllEmployees() {
        return serviceEmployee.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }

}
