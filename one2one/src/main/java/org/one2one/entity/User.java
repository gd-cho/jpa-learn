package org.one2one.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import java.util.Date;
import java.util.Objects;

@Entity(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private String name;

    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id", referencedColumnName = "id")
    private Department department;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


}
