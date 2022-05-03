package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.RoomView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomViewRepository extends JpaRepository<RoomView, Long> {
    RoomView findByRoomType(RoomView type);
    RoomView findById(long id);

    //@Query("SELECT p FROM RoomView p WHERE p.number LIKE %?1%"
//        + " OR p.price LIKE %?1%"
//        + " OR p.floor LIKE %?1%"
//        + " OR p.roomType.type LIKE %?1%"
//        + " OR p.colPeople LIKE %?1%")
    @Query("SELECT p FROM RoomView p WHERE p.roomType.type LIKE %?1%")
    List<RoomView> findByNumberAndPriceAndFloorAndColPeopleAndRoomType(String keyword);
}
