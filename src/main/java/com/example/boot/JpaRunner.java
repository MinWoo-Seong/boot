package com.example.boot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class JpaRunner implements ApplicationRunner {

    String[] tmp1 = {"김", "이", "박", "최"};
    String[] tmp2 = {"철수", "영희", "민수", "성희"};
    Integer[] tmp3 = {1000, 1200, 1400, 1600};
    Date[] dates = {
            Date.valueOf("2000-01-01"),
            Date.valueOf("2000-01-02"),
            Date.valueOf("2000-01-03"),
            Date.valueOf("2000-01-04")
    };

    private final DeptRepository deptRepository;
    private final EmployeeRepository employeeRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        //부서, 사원 정보 저장
        Dept dept1 = Dept.builder().deptName("경영").deptLoc("2층").build();
        Dept dept2 = Dept.builder().deptName("개발").deptLoc("3층").build();
        Dept dept3 = Dept.builder().deptName("지원").deptLoc("4층").build();

        deptRepository.save(dept1);
        deptRepository.save(dept2);
        deptRepository.save(dept3);
        empSave(dept1);
        empSave(dept2);
        empSave(dept3);

        //전체 사원 정보 출력
        List<Employee> employees = employeeRepository.findAll();
        employees.forEach((System.out::println));

        //사원 이름으로 검색해 출력
        int a = (int)(Math.random()*4);
        int b = (int)(Math.random()*4);
        String name = tmp1[a]+tmp2[b];
        employees = employeeRepository.findByEmpName(name, Sort.by(Sort.Order.desc("salary")));
        employees.forEach((System.out::println));
    }
    public void empSave(Dept dept) {
        for(int i=0; i<10; i++) {
            int a = (int)(Math.random()*4);
            int b = (int)(Math.random()*4);
            int c = (int)(Math.random()*4);
            int d = (int)(Math.random()*4);
            Employee emp = Employee.builder().empName((tmp1[a]+tmp2[b])).salary(tmp3[c]).joinDate(dates[d]).dept(dept).build();
            employeeRepository.save(emp);
        }
    }
}
