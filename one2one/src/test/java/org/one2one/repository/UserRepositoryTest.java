package org.one2one.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.one2one.JpaApplication;
import org.one2one.entity.Department;
import org.one2one.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Test
    public void addUser() {
        Department dept = Department.builder().name("Designer").build();
//        departmentRepository.save(dept);
//        Optional<Department> deptExists = departmentRepository.findByName(dept.getName());
//        System.out.println(deptExists.orElse(dept));
        User user =
                User.builder()
                    .name(UUID.randomUUID().toString().substring(0, 5))
                    .createTime(new Date())
                    .department(dept)
                    .build();
        userRepository.save(user);

        System.out.println(userRepository.findById(user.getId()));

    }

    @Test
    public void test01() {
        Date date = new Date(29, Calendar.FEBRUARY, 24);
        System.out.println(date);
    }

}