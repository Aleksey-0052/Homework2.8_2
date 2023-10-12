package ru.skypro.hw28.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.hw28.model.Employee;
import ru.skypro.hw28.service.ServiceEmployee;

import java.util.Collection;

@RestController
@RequestMapping("/employees")
public class ControllerEmployee {

@Autowired
    private final ServiceEmployee serviceEmployee;

    public ControllerEmployee(ServiceEmployee serviceEmployee) {

        this.serviceEmployee = serviceEmployee;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName,     // Наименование метода значения не имеет
                        @RequestParam int salary, @RequestParam int departmentId) {
        return serviceEmployee.addEmployee(firstName, lastName, salary, departmentId);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {     // Наименование метода значения не имеет
        return serviceEmployee.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {  // Наименование метода значения не имеет
        return serviceEmployee.findEmployee(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> findAll() {        //    Наименование метода значения не имеет

        return serviceEmployee.findAll();
    }
}
