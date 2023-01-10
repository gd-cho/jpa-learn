package org.jpa.dao;

import org.jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public interface UserDao extends JpaRepository<User, Long> {


    List<User> findByEmailAndName(String email,
                                  String name);

    List<User> findByName(String name);

    @Query(value = "select u from User u where u.email = ?1")
    List<User> findByEmail(String email);

    // like 查询
    @Query(value = "select u from User u where u.email like %?1")
    List<User> findByEmailEndsWith(String email);

    // 原生查询
    @Query(value = "select * from user where email = ?1",
           nativeQuery = true)
    List<User> findByEmailNative(String email);

    // 原生分页查询，实际的查询语法为：
    // `select * from user where create_time > ? order by id asc limit ?`
    // `select count(*) from user where create_time > ?`
    @Query(value = "select * from user where create_time > ?1",
           countQuery = "select count(*) from user where create_time > ?1",
           nativeQuery = true)
    Page<User> findByCreateTimeGreaterThan(Date time,
                                           Pageable pageable);

    @Query("select u from User u where u.name = :name")
    List<User> findByNameParam(@Param("name") String name);

    // 自定义修改
    // @Transactional
    @Modifying
    @Query(value = "update User u set u.name = ?2 where u.id = ?1")
    int updateNameById(Long id,
                       String name);

    List<User> findByPhoneNumberLike(String phoneNumber,
                                     Sort sort);

    List<User> findByNameLike(String name,
                              Pageable pageable);


}
