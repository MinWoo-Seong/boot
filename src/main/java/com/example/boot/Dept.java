package com.example.boot;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="dept")

public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptId;
    private String deptName;
    private String deptLoc;

    @Builder
    public Dept(String deptName, String deptLoc) {
        this.deptName = deptName;
        this.deptLoc = deptLoc;
    }
}
