package com.example.digitalart.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.digitalart.Entity.ArtistEntity;

@Repository
public interface ArtistRepo extends JpaRepository<ArtistEntity, Integer>
{
      @SuppressWarnings("null")
     Page<ArtistEntity> findAll(Pageable pageable);

     @Query("SELECT u FROM ArtistEntity u WHERE u.name =:name")
     List<ArtistEntity> searchUserByName(@Param ("name")String name);
}
