package org.jpa.dao;

import org.jpa.entity.User2;
import org.jpa.entity.UserPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User2Dao extends JpaRepository<User2, UserPK> {
}
