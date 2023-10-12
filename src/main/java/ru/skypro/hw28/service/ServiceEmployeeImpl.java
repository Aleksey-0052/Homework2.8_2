package ru.skypro.hw28.service;

import org.springframework.stereotype.Service;
import ru.skypro.hw28.exceptions.EmployeeAlreadyAddedException;
import ru.skypro.hw28.exceptions.EmployeeNotFoundException;
import ru.skypro.hw28.exceptions.EmployeeStorageIsFullException;
import ru.skypro.hw28.model.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceEmployeeImpl implements ServiceEmployee {

    private final Map<String, Employee> employees;

    private static final int MAX_EMPLOYEES = 10;

    public ServiceEmployeeImpl() {

        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);

        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Сотрудник с такими именем и фамилией уже существует");
        } else if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Лимит сотрудников превышен");
        }

        employees.put(employee.getFullName(),employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("Сотрудник с такими ФИО не найден");
        }

        employees.remove(employee.getFullName());
        return  employees.get(employee.getFullName());     // В этом случае будет выведен сотрудник со всеми свойствами

        // Можно указать return employee;  // В этом случае salary и departmentId выведутся с нулевыми значениями
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("Сотрудник с такими ФИО не найден");
        }

        return employees.get(employee.getFullName());  // В этом случае будет выведен сотрудник со всеми свойствами

        // Можно указать return employee;  // В этом случае salary и departmentId выведутся с нулевыми значениями
    }

    @Override
    public Collection<Employee> findAll() {           // наименование метода findAll значения не имеет; можно назвать по другому

        return employees.values();
    }

}
