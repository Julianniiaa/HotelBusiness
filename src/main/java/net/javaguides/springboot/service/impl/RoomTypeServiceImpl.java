package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.model.RoomType;
import net.javaguides.springboot.repository.RoomTypeRepository;
import net.javaguides.springboot.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    private RoomTypeRepository roomTypeRepository;

//    @Override
//    public RoomType saveTypeOfRoom(RoomTypeDto roomTypeDto) {
//        RoomType roomType = new RoomType(roomTypeDto.getTypeOfroom());
//        return roomType;
//    }

    @Override
    public List<RoomType> allTypeOfRooms() {
        return roomTypeRepository.findAll();
    }

//    @Override
//    public List<RoomType> allTypes() {
//        RoomType roomType = new RoomType();
//        return roomTypeRepository.findByType(roomType.getType());
//    }

    @Override
    public void getTypeOfRoomsById(long id) {
        this.roomTypeRepository.findById(id);
    }

    @Override
    public RoomType getTypeOfRoomsByType(String typeOfRooms) {
//        RoomType roomType = roomTypeRepository.findByType(typeOfRooms);
//        if(typeOfRooms==null)
//        {
//            throw new UsernameNotFoundException("Invalid type of rooms");
//        }
//        return roomType;
        return null;
    }
}
