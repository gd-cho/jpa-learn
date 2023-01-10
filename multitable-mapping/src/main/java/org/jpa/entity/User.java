package org.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@SecondaryTable(name = "contract", pkJoinColumns = @PrimaryKeyJoinColumn(name = "contract_id"))
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long age;


    @Column(table = "contract")
    private String email;

    @Column(table = "contract")
    private String blog;

}
