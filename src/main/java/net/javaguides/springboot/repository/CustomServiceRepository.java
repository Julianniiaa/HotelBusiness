package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Booking;
import net.javaguides.springboot.model.CustomService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CustomServiceRepository extends JpaRepository<CustomService, Long> {
    CustomService findById(long id);
    CustomService findByType(String type);
}
