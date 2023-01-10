package org.jpa.dao;

import org.jpa.CompositeKeyApplication;
import org.jpa.entity.User;
import org.jpa.entity.User2;
import org.jpa.entity.UserPK;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * 测试联合主键方式2
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CompositeKeyApplication.class)
public class User2DaoTest {

    @Autowired
    private User2Dao user2Dao;

    /**
     * 存储user至数据库
     */
    @Test
    public void addUser() {
        User2 user2 = User2.builder().id(2L).phone("147852").name("Kim").build();

        user2Dao.save(user2);
    }

    /**
     * 使用联合主键进行查询
     */
    @Test
    public void findUser() {
        UserPK userPk = UserPK.builder().id(2L).phone("147852").build();
        Optional<User2> user2 = user2Dao.findById(userPk);
        user2.ifPresent(System.out::println);
    }
}