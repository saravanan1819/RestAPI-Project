package com.example.digitalart.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.digitalart.Entity.TaskEntity;
import com.example.digitalart.Services.TaskService;

@RestController
@RequestMapping("/taskuser")

public class TaskController {
    @Autowired
    TaskService taskService;
    @GetMapping
    public List<TaskEntity> getTaskUsers()
    {
         return taskService.getTaskUsers();
    }
    @PostMapping
    public TaskEntity CreateTaskuser(@RequestBody TaskEntity eventEntity)
    {
     return taskService.CreateTaskuser(eventEntity);
    }

    @GetMapping("/{id}")
    public Optional<TaskEntity> getTaskUsersbyID(@PathVariable Integer id)
    {
         return taskService.getTaskUsersbyID(id);
    }
    @PutMapping("/{id}")
    public TaskEntity updateTaskUser(@PathVariable Integer id , @RequestBody TaskEntity eventEntity)
    {
         
            return taskService.updateTaskUser(id, eventEntity);
         
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id )
    {
        return taskService.deleteUser(id);
    }


    
   @GetMapping("/pagination")
    public Page<TaskEntity> getPage(@RequestParam int page,@RequestParam int size , @RequestParam String sortBy , @RequestParam String sortDir  )
    {
         return taskService.getPage(page, size , sortBy, sortDir);
    }

    

}
