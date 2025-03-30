package com.example.digitalart.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.digitalart.Entity.GuestEntity;
import com.example.digitalart.Services.GuestService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/guestuser")
public class GuestController {
    @Autowired
    GuestService guestService;
    @GetMapping
    public List<GuestEntity> getguestUser()
    {
       return guestService.getGuestUser();
    }
    @PostMapping
    public GuestEntity createGuestuser(@RequestBody GuestEntity guestEntity)
    {
        return guestService.createGuestuser(guestEntity);
    }

    
    @GetMapping("/{id}")
    public Optional<GuestEntity> getGuestUsersbyID(@PathVariable Integer id)
    {
         return guestService.getguestUsersbyID(id);
    }
    @PutMapping("/{id}")
    public GuestEntity updateGuestUser(@PathVariable Integer id , @RequestBody GuestEntity guestEntity)
    {
         
            return guestService.updateGuestUser(id, guestEntity);
         
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id )
    {
        return guestService.deleteUser(id);
    }


   @GetMapping("/pagination")
    public Page<GuestEntity> getPage(@RequestParam int page,@RequestParam int size , @RequestParam String sortBy , @RequestParam String sortDir  )
    {
         return guestService.getPage(page, size , sortBy, sortDir);
    }
    

   
    
    
}
