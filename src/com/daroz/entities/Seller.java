package com.daroz.entities;

import java.util.Date;

public class Seller {

    private int id;
    private double baseSalary;
    private Date birthDate;
    private int departmentId;
    private String email;
    private String name;

    public Seller(double baseSalary, Date birthDate, int departmentId, String email, String name) {
        this.baseSalary = baseSalary;
        this.birthDate = birthDate;
        this.departmentId = departmentId;
        this.email = email;
        this.name = name;
    }

    public Seller(int id, double baseSalary, Date birthDate, int departmentId, String email, String name) {
        this.baseSalary = baseSalary;
        this.birthDate = birthDate;
        this.departmentId = departmentId;
        this.email = email;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", baseSalary=" + baseSalary +
                ", birthDate=" + birthDate +
                ", departmentId=" + departmentId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
