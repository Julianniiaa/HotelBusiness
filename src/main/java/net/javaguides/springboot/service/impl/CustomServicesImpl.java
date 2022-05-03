package net.javaguides.springboot.service.impl;


import net.javaguides.springboot.model.CustomService;
import net.javaguides.springboot.repository.CustomServiceRepository;
import net.javaguides.springboot.service.CustomServices;
import net.javaguides.springboot.web.dto.CustomServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomServicesImpl implements CustomServices {
    @Autowired
    CustomServiceRepository serviceRepository;

    public CustomServicesImpl(CustomServiceRepository serviceRepository) {
        super();
        this.serviceRepository = serviceRepository;
    }

    @Override
    public CustomService saveService(CustomServiceDto serviceDto) {
//        Services service = new Services(serviceDto.isStatus(),
//                serviceDto.getServiceType());
//
//        return serviceRepository.save(service);
        return null;
    }

    @Override
    public List<CustomService> allService() {
        return serviceRepository.findAll();
    }

//    @Override
//    public List<CustomService> findByTypeCustom(String type) {
//        return serviceRepository.findByType(type);
//    }
}
