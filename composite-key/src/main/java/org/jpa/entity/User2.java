package org.jpa.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
@IdClass(UserPK.class)
public class User2 {

    @Id
    private Long id;

    @Id
    private String phone;

    private String name;
}
