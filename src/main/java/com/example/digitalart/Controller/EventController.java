package com.example.digitalart.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
// import org.springframework.http.ResponseEntity;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.digitalart.Entity.EventEntity;
import com.example.digitalart.Services.EventService;

@RestController
@RequestMapping("/eventuser")

public class EventController {
    
    @Autowired
    EventService eventService;
    @GetMapping
    public List<EventEntity> getEventUsers()
    {
         return eventService.getEventUsers();
    }
    @PostMapping
    public EventEntity CreateEventuser(@RequestBody EventEntity eventEntity)
    {
     return eventService.CreateEventuser(eventEntity);
    }

    @GetMapping("/{id}")
    public Optional<EventEntity> getEventUsersbyID(@PathVariable Integer id)
    {
         return eventService.getEventUsersbyID(id);
    }
    @PutMapping("/{id}")
    public EventEntity updateEventUser(@PathVariable Integer id , @RequestBody EventEntity eventEntity)
    {
         
            return eventService.updateEventUser(id, eventEntity);
         
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id )
    {
        return eventService.deleteUser(id);
    }

     @GetMapping("/pagination")
    public Page<EventEntity> getPage(@RequestParam int page,@RequestParam int size   )
    {
         return eventService.getPage(page, size);
    }

    @GetMapping("/sorting")    
    public List<EventEntity> sortEvent(@RequestParam String sortBy , @RequestParam String sortDir){
     return eventService.sortEvent(sortBy, sortDir);
    }
      
    @GetMapping("/search")
    public ResponseEntity<List<EventEntity>> searchUsers(@RequestParam String eventName)
    {
       return ResponseEntity.ok(eventService.searchUserByName(eventName));
    }    


    

    


}
