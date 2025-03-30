package com.example.digitalart.Services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.digitalart.ResourceNotFoundException;
import com.example.digitalart.Entity.TaskEntity;
import com.example.digitalart.Repository.TaskRepo;
@Service
public class TaskService {
    @Autowired
    TaskRepo taskRepo;
     public List<TaskEntity> getTaskUsers()
    {
         return taskRepo.findAll();
    }

    public TaskEntity CreateTaskuser(TaskEntity  eventEntity)
    {
     return taskRepo.save(eventEntity);
    }
   
    public Optional<TaskEntity> getTaskUsersbyID(@PathVariable Integer id)
    {
         return Optional.of(taskRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this Id ")));
    }

    public TaskEntity updateTaskUser(@PathVariable Integer id , @RequestBody TaskEntity taskEntity)
    {
         
                TaskEntity taskEntityUser=taskRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this Id "));
                taskEntityUser.setTaskName(taskEntity.getTaskName());
                taskEntityUser.setEvent(taskEntity.getEvent());
                taskEntityUser.setEmployees(taskEntity.getEmployees());
                 return taskRepo.save(taskEntityUser);
         
    }
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id )
    {
        TaskEntity taskEntityUser = taskRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this Id "));
        taskRepo.delete(taskEntityUser);
        return ResponseEntity.ok().build();
    }


    
   public Page<TaskEntity> getPage(int page,int size , String sortBy, String sortDir){
     Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
     Pageable pageable = PageRequest.of(page,size ,sort);
     return taskRepo.findAll(pageable);
    }


}
