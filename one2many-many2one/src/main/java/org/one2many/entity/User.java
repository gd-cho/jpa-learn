package org.one2many.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "t_users")
@ToString(exclude = {"room"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long age;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Room room;
}
