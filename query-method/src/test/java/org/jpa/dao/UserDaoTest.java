package org.jpa.dao;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import org.assertj.core.util.Lists;
import org.jpa.QueryMethodApplication;
import org.jpa.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = QueryMethodApplication.class)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;


    /**
     * 动态查询示例
     */
    @Test
    public void testExample() {
        User user = User.builder()
                        .name("0")
                        .build();
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                                                      .withIgnorePaths("password") // 1.
                                                      .withIncludeNullValues()  // 2.
                                                      .withIgnoreCase()  // 3.
                                                      .withIgnoreNullValues()  // 4.
                                                      .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // 5.
                                                      .withIgnoreCase("name")  // 6.
                                                      .withMatcher("name",
                                                                   ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.ENDING));  // 7.

        Example<User> example = Example.of(user,
                                           exampleMatcher);
        List<User> userList = userDao.findAll(example);
        System.out.println(userList);
    }

    /**
     * 分页测试
     */
    @Test
    public void testPageable() {
        PageRequest pageRequest = PageRequest.of(0,
                                                 5);

        List<User> users = userDao.findByNameLike("test%",
                                                  pageRequest);
        System.out.println(users);
    }

    /**
     * 排序测试
     */
    @Test
    public void testSort() {
        Sort sort = Sort.by(Sort.Direction.ASC,
                            "phoneNumber");
        List<User> users = userDao.findByPhoneNumberLike("137%",
                                                         sort);
        System.out.println(users);
    }

    /**
     * 测试 @Param 名称参数注解
     */
    @Test
    public void testNameParameter() {
        List<User> userList = userDao.findByNameParam("test0");
        System.out.println(userList);
    }

    /**
     * 自定义修改测试
     */
    @Test
    public void testUpdate() {
        int affectedCount = userDao.updateNameById(5L,
                                                   "test4444");
        System.out.println(affectedCount);
    }

    @Test
    public void testQueryForPageable() {
        Sort sort = Sort.by(Sort.Direction.ASC,
                            "id");
        PageRequest pageRequest = PageRequest.of(0,
                                                 5,
                                                 sort);
        Date date = new Date(1672848000000L);
        Page<User> userPage = userDao.findByCreateTimeGreaterThan(date,
                                                                  pageRequest);
        List<User> userList = userPage.stream()
                                      .toList();
        System.out.println(userList);
    }

    /**
     * 使用@NamedQuery创建的查询方法查询
     */
    @Test
    public void testNamedQuery() {
        List<User> user = userDao.findByName("test5");
        System.out.println(user);
    }


    /**
     * 从方法名中翻译为指定的JPQL查询语句
     * 以下方法翻译为 `select u from User u where u.email=?1 and u.name=?2`
     */
    @Test
    public void testQueryCreation() {
        List<User> userList = userDao.findByEmailAndName("test0@gmail.com",
                                                         "test0");
        System.out.println(new ArrayList<>(userList));
    }

    /**
     * 初始化数据表，并进行分页查询
     */
    @Test
    public void queryPage() {
        initData();
        Sort sort = Sort.by(Sort.Direction.ASC,
                            "id");
        // 分页时起始页为页码减1
        PageRequest pageRequest = PageRequest.of(0,
                                                 5,
                                                 sort);

        Page<User> userPage = userDao.findAll(pageRequest);
        long totalElements = userPage.getTotalElements();
        int totalPages = userPage.getTotalPages();
        System.out.println("totalPages: " + totalPages);
        System.out.println("totalElements: " + totalElements);
        System.out.println(userPage.stream()
                                   .collect(Collectors.toList()));
    }

    public void initData() {
        List<User> userList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            String salt = IdUtil.fastSimpleUUID();
            String name = "test" + i;
            String email = name + "@gmail.com";
            User user = User.builder()
                            .name(name)
                            .email(email)
                            .lastLoginTime(new DateTime())
                            .phoneNumber("1370000000" + i)
                            .salt(salt)
                            .status(1)
                            .password(SecureUtil.md5("123456" + salt))
                            .build();
            userList.add(user);
        }
        userDao.saveAll(userList);
    }
}