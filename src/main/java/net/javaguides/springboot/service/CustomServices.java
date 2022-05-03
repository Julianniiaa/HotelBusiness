package net.javaguides.springboot.service;

import net.javaguides.springboot.model.CustomService;
import net.javaguides.springboot.web.dto.CustomServiceDto;

import java.util.List;

public interface CustomServices {
    CustomService saveService(CustomServiceDto serviceDto);
    List<CustomService> allService();
//    List<CustomService> findByTypeCustom(String type);

}
