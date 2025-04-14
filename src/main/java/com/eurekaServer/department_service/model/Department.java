package com.eurekaServer.department_service.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private Long id;
    private String name;
    private List<Employee> employees= new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "employees=" + employees +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department() {
    }
}
