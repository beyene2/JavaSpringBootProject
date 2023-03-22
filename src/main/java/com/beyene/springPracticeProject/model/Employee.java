package com.beyene.springPracticeProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empid;
    private String fullname;
    private String gender;
    private int age;
    private double salary;

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(int empid, String fullname, String gender, int age, double salary) {
        super();
        this.empid = empid;
        this.fullname = fullname;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
    }

    public Employee() {
        super();
    }

    public Employee(String fullname, String gender, int age, double salary) {
        super();
        this.fullname = fullname;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
    }


}
