package org.jpa.dao;

import org.jpa.EmbeddApplication;
import org.jpa.entity.Email;
import org.jpa.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmbeddApplication.class)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void addUser() {
        User user = User.builder()
                        .name("qwq")
                        .email(Email.builder().email("qwq@gmail.com").serverEmail("qwq.server@gmail.com").build())
                        .build();
        userDao.save(user);
    }
}