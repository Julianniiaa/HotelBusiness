package net.javaguides.springboot.service.impl;

import net.javaguides.springboot.model.RoomType;
import net.javaguides.springboot.model.RoomView;
import net.javaguides.springboot.repository.RoomTypeRepository;
import net.javaguides.springboot.repository.RoomViewRepository;
import net.javaguides.springboot.service.RoomViewService;
import net.javaguides.springboot.web.dto.RoomViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomViewServiceImpl implements RoomViewService {

    //    @Autowired
    private RoomViewRepository roomViewRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    public RoomViewServiceImpl(RoomViewRepository roomViewRepository) {
        super();
        this.roomViewRepository= roomViewRepository;
    }


    @Override
    public RoomView saveRoomView(RoomViewDto roomViewDto) {
        RoomType roomType = roomTypeRepository.findByType(roomViewDto.getTypeRoom().getType());
        RoomView roomView=new RoomView(roomViewDto.getColPeople(),
                roomViewDto.getPrice(),
//                roomViewDto.getColRooms(),
                roomViewDto.getNumber(),
                roomViewDto.getFloor(),
                roomViewDto.getStatusBooking(),
                roomType);
//                Arrays.asList(new RoomType(roomViewDto.getTypeRoom())));
        return roomViewRepository.save(roomView);
    }

//    @Override
//    public RoomView saveRoomView(RoomViewDto roomViewDto) {
//        RoomView roomView=new RoomView(roomViewDto.getColPeople(),
//                roomViewDto.getPrice(),
//                roomViewDto.getColRooms(),
//                roomViewDto.getNumber(),
//                roomViewDto.getFloor(),
//                roomViewDto.getTypeRoom());
////                Arrays.asList(new RoomType(roomViewDto.getTypeRoom())));
//        return roomViewRepository.save(roomView);
//    }


    @Override
    public List<RoomView> allRoomView() {
        return roomViewRepository.findAll();
    }

    @Override
    public RoomViewDto getRoomViewById(long id) {
        RoomView roomView = roomViewRepository.findById(id);

        RoomViewDto roomViewDto = new RoomViewDto(roomView.getId(),roomView.getColPeople(), roomView.getPrice(),
                roomView.getNumber(), roomView.getFloor(), roomView.getRoomType());
        return roomViewDto;
    }

    public void delete(long id) {
        roomViewRepository.deleteById(id);
    }

    @Override
    public RoomView save(RoomView roomView) {
        return roomViewRepository.save(roomView);
    }

    @Override
    public List<RoomView> findByKeyword(String keyword) {
        List<RoomView> roomViewList = roomViewRepository.findByNumberAndPriceAndFloorAndColPeopleAndRoomType(keyword);

        return roomViewList;
    }
}
