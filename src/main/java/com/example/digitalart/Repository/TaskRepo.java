package com.example.digitalart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.digitalart.Entity.TaskEntity;

@Repository
public interface TaskRepo extends JpaRepository<TaskEntity, Integer>
{
    
}
