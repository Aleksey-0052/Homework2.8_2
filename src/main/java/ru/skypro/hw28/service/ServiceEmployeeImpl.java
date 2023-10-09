package ru.skypro.hw28.service;

import org.springframework.stereotype.Service;
import ru.skypro.hw28.exceptions.EmployeeAlreadyAddedException;
import ru.skypro.hw28.exceptions.EmployeeNotFoundException;
import ru.skypro.hw28.model.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceEmployeeImpl implements ServiceEmployee {

    private final Map<String, Employee> employees;

    public ServiceEmployeeImpl() {

        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);

        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Сотрудник с такими ФИО уже имеется");
        }

        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("Сотрудник с такими ФИО не найден");
        }

        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("Сотрудник с такими ФИО не найден");
        }

        return employee;
    }

    @Override
    public Collection<Employee> getEmployees() {

        return employees.values();
    }

}
