package org.jpa.dao;


import org.jpa.entity.User;
import org.jpa.entity.UserPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, UserPK> {

}
