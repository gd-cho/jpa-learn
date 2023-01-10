package org.one2many.dao;

import org.one2many.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<Room, Long> {

}
