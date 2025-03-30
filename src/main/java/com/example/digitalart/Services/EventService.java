package com.example.digitalart.Services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.digitalart.ResourceNotFoundException;
import com.example.digitalart.Entity.EventEntity;
import com.example.digitalart.Repository.EventRepo;

@Service
public class EventService {
    @Autowired
    private EventRepo eventRepo;
     public List<EventEntity> getEventUsers()
    {
         return eventRepo.findAll();
    }

    public EventEntity CreateEventuser(EventEntity  eventEntity)
    {
     return eventRepo.save(eventEntity);
    }
   
    public Optional<EventEntity> getEventUsersbyID(@PathVariable Integer id)
    {
         return Optional.of(eventRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this Id ")));
    }

    public EventEntity updateEventUser(@PathVariable Integer id , @RequestBody EventEntity eventEntity)
    {
         
              EventEntity eventEntityUser=eventRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this Id "));
                eventEntityUser.setEventName(eventEntity.getEventName());
                eventEntityUser.setTasks(eventEntity.getTasks());
                eventEntityUser.setGuests(eventEntity.getGuests());
               return eventRepo.save(eventEntityUser);
         
    }
    public String deleteUser(@PathVariable Integer id )
    {
      EventEntity eventEntityUser = eventRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this Id "));
      eventRepo.delete(eventEntityUser);
       return "Delete Successs";
    }

     public Page<EventEntity> getPage(int page,int size ){
     Pageable pageable = PageRequest.of(page,size);
     return eventRepo.findAll(pageable);
    }
    
    public List<EventEntity> sortEvent(String sortBy , String sortDir){
     Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
     return eventRepo.findAll(sort);
    }

    public List<EventEntity> searchUserByName(String eventName)
    {
        return eventRepo.searchUserByName(eventName);
    }


}
