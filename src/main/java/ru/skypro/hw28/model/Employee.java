package ru.skypro.hw28.model;

import java.util.Objects;

public class Employee {

    private String firstName;
    private String lastName;
    private int salary;
    private int departmentId;

    public Employee(String firstName, String lastName, int salary, int departmentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentId = departmentId;

    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public int getSalary() {

        return salary;
    }

    public int getDepartmentId() {

        return departmentId;
    }

    public String getFullName() {

        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;   //  Приводим obj к типу моего класса
        // Теперь сравниваем поля объектов
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName)
                && Objects.equals(departmentId, employee.departmentId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName, departmentId);
    }

    //@Override
    //public String toString() {
        //return "Employee{" +
                //"firstName='" + firstName + '\'' +
                //", lastName='" + lastName + '\'' +
                //", salary=" + salary +
                //", departmentId=" + departmentId +
                //'}';
    //}

}
