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
import com.example.digitalart.Entity.ArtworkEntity;
import com.example.digitalart.Services.ArtworkService;

@RestController
@RequestMapping("/artworkuser")

public class ArtworkController {
    
    @Autowired
    ArtworkService artworkService;
    @GetMapping
    public List<ArtworkEntity> getEventUsers()
    {
         return artworkService.getEventUsers();
    }
    @PostMapping
    public ArtworkEntity CreateEventuser(@RequestBody ArtworkEntity artworkEntity)
    {
     return artworkService.CreateEventuser(artworkEntity);
    }

    @GetMapping("/{id}")
    public Optional<ArtworkEntity> getEventUsersbyID(@PathVariable Integer id)
    {
         return artworkService.getEventUsersbyID(id);
    }
    @PutMapping("/{id}")
    public ArtworkEntity updateEventUser(@PathVariable Integer id , @RequestBody ArtworkEntity artworkEntity)
    {
         
            return artworkService.updateEventUser(id, artworkEntity);
         
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id )
    {
        return artworkService.deleteUser(id);
    }

     @GetMapping("/pagination")
    public Page<ArtworkEntity> getPage(@RequestParam int page,@RequestParam int size   )
    {
         return artworkService.getPage(page, size);
    }

    @GetMapping("/sorting")    
    public List<ArtworkEntity> sorting(@RequestParam String sortBy , @RequestParam String sortDir){
     return artworkService.sorting(sortBy, sortDir);
    }
      
    @GetMapping("/search")
    public ResponseEntity<List<ArtworkEntity>> searchUsers(@RequestParam String title)
    {
       return ResponseEntity.ok(artworkService.searchUserByName(title));
    }    


    

    


}
