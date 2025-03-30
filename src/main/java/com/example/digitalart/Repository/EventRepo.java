package com.example.digitalart.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.digitalart.Entity.EventEntity;

@Repository
public interface EventRepo extends JpaRepository<EventEntity, Integer>
{

     @SuppressWarnings("null")
     Page<EventEntity> findAll(Pageable pageable);

     @Query("SELECT u FROM EventEntity u WHERE u.eventName =:eventName")
     List<EventEntity> searchUserByName(@Param ("eventName")String eventName);
    
}
