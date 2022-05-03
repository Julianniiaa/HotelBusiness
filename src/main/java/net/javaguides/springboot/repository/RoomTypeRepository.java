package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
    RoomType findByType(String type);
}
