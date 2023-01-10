package org.jpa.dao;

import org.jpa.MultitableMappingApplication;
import org.jpa.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MultitableMappingApplication.class)
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    /**
     * 创建多表映射，User实体映射至users与contract表格
     */
    @Test
    public void addUser() {
        User user = User.builder().name("abc").age(19L).blog("a new world").email("abc@gmail.com").build();
        userDao.save(user);
    }

    @Test
    public void add() {
    }

}