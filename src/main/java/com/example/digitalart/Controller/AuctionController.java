package com.example.digitalart.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.digitalart.Entity.AuctionEntity;
import com.example.digitalart.Services.AuctionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auctionuser")
public class AuctionController {
    @Autowired
    AuctionService auctionService;
    @GetMapping
    public List<AuctionEntity> getguestUser()
    {
       return auctionService.getGuestUser();
    }
    @PostMapping
    public AuctionEntity createGuestuser(@RequestBody AuctionEntity auctionEntity)
    {
        return auctionService.createGuestuser(auctionEntity);
    }

    
    @GetMapping("/{id}")
    public Optional<AuctionEntity> getGuestUsersbyID(@PathVariable Integer id)
    {
         return auctionService.getguestUsersbyID(id);
    }
    @PutMapping("/{id}")
    public AuctionEntity updateGuestUser(@PathVariable Integer id , @RequestBody AuctionEntity auctionEntity)
    {
         
            return auctionService.updateGuestUser(id, auctionEntity);
         
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id )
    {
        return auctionService.deleteUser(id);
    }


     @GetMapping("/pagination")
    public Page<AuctionEntity> getPage(@RequestParam int page,@RequestParam int size   )
    {
         return auctionService.getPage(page, size);
    }

    @GetMapping("/sorting")    
    public List<AuctionEntity> sorting(@RequestParam String sortBy , @RequestParam String sortDir){
     return auctionService.sorting(sortBy, sortDir);
    }
      
    @GetMapping("/search")
    public ResponseEntity<List<AuctionEntity>> searchUsers(@RequestParam String title)
    {
       return ResponseEntity.ok(auctionService.searchUserByName(title));
    }  
    

 
}
