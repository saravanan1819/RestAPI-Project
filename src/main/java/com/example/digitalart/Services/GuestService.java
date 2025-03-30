package com.example.digitalart.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.digitalart.Repository.GuestRepo;
import com.example.digitalart.ResourceNotFoundException;
import com.example.digitalart.Entity.GuestEntity;
import java.util.List;
import java.util.Optional;

@Service
public class GuestService {
    @Autowired
    GuestRepo guestRepo;
    public List<GuestEntity> getGuestUser()
    { 
        return guestRepo.findAll();
    }
    public GuestEntity createGuestuser(GuestEntity guestEntity)
    {
         return guestRepo.save(guestEntity);
    }

    public Optional<GuestEntity> getguestUsersbyID(@PathVariable Integer id)
    {
         return Optional.of(guestRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this Id ")));
    }

    public GuestEntity updateGuestUser(@PathVariable Integer id , @RequestBody  GuestEntity guestEntity)
    {
         
             GuestEntity  guestEntityUser=guestRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this Id "));
             guestEntityUser.setName(guestEntity.getName());
             guestEntityUser.setEvent(guestEntity.getEvent());
            return guestRepo.save(guestEntityUser);
         
    }
     public ResponseEntity<Object> deleteUser(@PathVariable Integer id )
    {
      GuestEntity guestEntityUser = guestRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this Id "));
      guestRepo.delete(guestEntityUser);
       return ResponseEntity.ok().build();
    }

      public Page<GuestEntity> getPage(int page,int size , String sortBy, String sortDir){
     Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
     Pageable pageable = PageRequest.of(page,size ,sort);
     return guestRepo.findAll(pageable);
    }

}
