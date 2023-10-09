package ru.skypro.hw28.service;

import ru.skypro.hw28.model.Employee;

import java.util.Collection;

public interface ServiceEmployee {

    Employee addEmployee(String firstName, String lastName, int salary, int departmentId);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> getEmployees();
}
