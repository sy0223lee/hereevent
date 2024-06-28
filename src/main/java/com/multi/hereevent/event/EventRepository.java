package com.multi.hereevent.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(readOnly = true)
public interface EventRepository extends JpaRepository<EventEntity, Long> {
    @Query(value = "SELECT * FROM event e WHERE e.name LIKE %:keyword%",
      nativeQuery = true)
    List<EventEntity> findByNameContaining(@Param("keyword") String keyword);
}
