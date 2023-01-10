package org.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import lombok.*;
import org.jpa.dao.base.BaseEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NamedQuery(name = "User.findByName",
            query = "select u from User u where u.name = ?1")
public class User extends BaseEntity {

    private String name;

    private String password;

    private String salt;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 状态，-1：逻辑删除，0：禁用，1：启用
     */
    private Integer status;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

}
