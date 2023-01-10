package org.one2many.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_room")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(exclude = {"userList"})
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
//    @JoinColumn(name = "room_id")
//    @JsonIgnoreProperties({"room"})
    private List<User> userList = new ArrayList<>();

}
