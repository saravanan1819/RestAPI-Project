package com.example.digitalart.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.digitalart.Entity.ArtworkEntity;

@Repository
public interface ArtworkRepo extends JpaRepository<ArtworkEntity, Integer>
{

     @SuppressWarnings("null")
     Page<ArtworkEntity> findAll(Pageable pageable);

     @Query("SELECT u FROM ArtEntity u WHERE u.title =:title")
     List<ArtworkEntity> searchUserByName(@Param ("title")String title);
    
}
