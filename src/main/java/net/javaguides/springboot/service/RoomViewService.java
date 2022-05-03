package net.javaguides.springboot.service;

import net.javaguides.springboot.model.RoomView;
import net.javaguides.springboot.web.dto.RoomViewDto;

import java.util.List;

public interface RoomViewService {

    RoomView saveRoomView(RoomViewDto roomViewDto);
    List<RoomView> allRoomView();
    RoomViewDto getRoomViewById(long id);
//    RoomView getRoomViewByType(String typeOfRooms);
    void delete(long id);
    RoomView save(RoomView roomView);
    List<RoomView> findByKeyword(String keyword);

}

