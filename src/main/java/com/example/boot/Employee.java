package com.example.boot;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "employee")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
    private String empName;
    private Integer salary;
    private Date joinDate;
    @ManyToOne
    @JoinColumn(name = "dept_Id")
    private Dept dept;

    @Builder
    public Employee(String empName, Integer salary, Date joinDate, Dept dept) {
        this.empName = empName;
        this.salary = salary;
        this.joinDate = joinDate;
        this.dept = dept;
    }
}