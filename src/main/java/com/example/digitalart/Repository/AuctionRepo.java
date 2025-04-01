package com.example.digitalart.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.digitalart.Entity.AuctionEntity;

@Repository
public interface AuctionRepo extends JpaRepository<AuctionEntity, Integer>
{

    
      @SuppressWarnings("null")
     Page<AuctionEntity> findAll(Pageable pageable);

     @Query("SELECT u FROM AuctionEntity u WHERE u.title =:title")
     List<AuctionEntity> searchUserByName(@Param ("title")String title);
    
    
}

