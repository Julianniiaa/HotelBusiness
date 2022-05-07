package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Booking;
import net.javaguides.springboot.model.CustomService;
import net.javaguides.springboot.model.RoomView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookingRepository  extends JpaRepository<Booking, Long> {
//    Booking findByUser (long id);
    List<Booking> findBookingByUserId(long id);
//    List<RoomView> findByRoomViewId(long id);
    Booking findBookingById(long id);

}
