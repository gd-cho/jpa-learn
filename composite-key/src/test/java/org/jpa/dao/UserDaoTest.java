package org.jpa.dao;

import org.jpa.CompositeKeyApplication;
import org.jpa.entity.User;
import org.jpa.entity.UserPK;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * 测试联合主键方式1
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CompositeKeyApplication.class)
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    /**
     * 存储user至数据库
     */
    @Test
    public void addUser() {
        UserPK userPk = UserPK.builder().id(1L).phone("134679").build();
        User user = User.builder().userPk(userPk).name("KOko").build();
        userDao.save(user);
    }

    /**
     * 使用联合主键进行查询
     */
    @Test
    public void findUser() {
        UserPK userPk = UserPK.builder().id(1L).phone("134679").build();
        Optional<User> user = userDao.findById(userPk);
        user.ifPresent(System.out::println);
    }
}