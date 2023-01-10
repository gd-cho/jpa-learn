package org.one2many.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.one2many.One2ManyApplication;
import org.one2many.entity.Room;
import org.one2many.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = One2ManyApplication.class)
public class UserDaoTest {


    @Autowired
    UserDao userDao;

    @Autowired
    RoomDao roomDao;

    /**
     * 双向关联，维护权交给roomDao，保存room后，再保存user。
     */
    @Test
    public void roomControl() {

        User user1 = User.builder().age(10L).name("qaq3443").build();
        User user2 = User.builder().age(20L).name("cvc3344").build();
        Room room = Room.builder()
                        .userList(Arrays.asList(user1, user2))
                        .address("奇迹").build();
        user1.setRoom(room);
        user2.setRoom(room);

        roomDao.save(room);
    }
    /**
     * 双向关联，维护权交给userDao，保存room后，再保存user。
     */
    @Test
    public void userControl() {
        User user1 = User.builder().age(10L).name("abc").build();
        User user2 = User.builder().age(20L).name("efg").build();

        Room room = Room.builder()
                        .userList(Arrays.asList(user1, user2))
                        .address("香格里拉").build();
        user1.setRoom(room);
        user2.setRoom(room);
        userDao.save(user1);
        userDao.save(user2);

    }
}