package ru.skypro.hw28.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.skypro.hw28.model.Employee;
import ru.skypro.hw28.service.ServiceDepartment;

import java.util.List;
import java.util.Map;

public class ControllerDepartment {

    private final ServiceDepartment serviceDepartment;
    @Autowired
    public ControllerDepartment(ServiceDepartment serviceDepartment) {

        this.serviceDepartment = serviceDepartment;
    }

    @GetMapping(path = "/min-salary")
    public Employee findEmployeeWithMinSalaryByDepartment(@RequestParam int departmentId) {
        return serviceDepartment.findEmployeeWithMinSalaryByDepartment(departmentId);
    }

    @GetMapping(path = "/max-salary")
    public Employee findEmployeeWithMaxSalaryByDepartment(@RequestParam int departmentId) {
        return serviceDepartment.findEmployeeWithMaxSalaryByDepartment(departmentId);
    }

    @GetMapping(path = "/sum-salary")
    public int calculateTotalSalaryByDepartment(@RequestParam int departmentId) {
        return serviceDepartment.calculateTotalSalaryByDepartment(departmentId);
    }

    @GetMapping(path = "/all", params = "departmentId")
    Map<Integer, List<Employee>> printEmployeesByDepartment(@RequestParam(value = "departmentId") int departmentId) {
        return serviceDepartment.printEmployeesByDepartment(departmentId);
    }

    @GetMapping("/all")
    Map<Integer, List<Employee>> printAllEmployees() {

        return serviceDepartment.printAllEmployees();
    }

}
