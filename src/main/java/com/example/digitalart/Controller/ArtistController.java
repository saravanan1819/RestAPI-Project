package com.example.digitalart.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.digitalart.Entity.ArtistEntity;

import com.example.digitalart.Services.ArtistService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/artistuser")


public class ArtistController {
    
    @Autowired
    ArtistService artistService;
    @GetMapping
    public List<ArtistEntity> getEmployeeUsers()
    {
         return artistService.getEmployeeUsers();
    }
    @PostMapping
    public ArtistEntity CreateEmployeeuser(@RequestBody ArtistEntity  artistEntity )
    {
     return artistService.CreateEmployeeuser( artistEntity );
    }

    @GetMapping("/{id}")
    public Optional<ArtistEntity> getEmployeeUsersbyID(@PathVariable Integer id)
    {
         return artistService.getEmployeeUsersbyID(id);
    }
    @PutMapping("/{id}")
    public ArtistEntity updateEmployeeUser(@PathVariable Integer id , @RequestBody ArtistEntity  artistEntity )
    {
         
            return artistService.updateEmployeeUser(id,  artistEntity );
         
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id )
    {
        return artistService.deleteUser(id);
    }

    @GetMapping("/pagination")
    public Page<ArtistEntity> getPage(@RequestParam int page,@RequestParam int size   )
    {
         return artistService.getPage(page, size);
    }

    @GetMapping("/sorting")    
    public List<ArtistEntity> sorting(@RequestParam String sortBy , @RequestParam String sortDir){
     return artistService.sorting(sortBy, sortDir);
    }
      
    @GetMapping("/search")
    public ResponseEntity<List<ArtistEntity>> searchUsers(@RequestParam String name)
    {
       return ResponseEntity.ok(artistService.searchUserByName(name));
    }    




}
