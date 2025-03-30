package com.example.digitalart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.digitalart.Entity.GuestEntity;

@Repository
public interface GuestRepo extends JpaRepository<GuestEntity, Integer>
{
    
}

