package com.example.digitalart.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;

import com.example.digitalart.ResourceNotFoundException;
import com.example.digitalart.Entity.ArtistEntity;

import com.example.digitalart.Repository.ArtistRepo;


@Service
public class ArtistService {
 
    @Autowired
     private ArtistRepo artistRepo;
     public List<ArtistEntity> getEmployeeUsers()
    {
         return artistRepo.findAll();
    }

    public ArtistEntity CreateEmployeeuser(ArtistEntity artistEntity)
    {
     return artistRepo.save(artistEntity);
    }
   
    public Optional<ArtistEntity> getEmployeeUsersbyID(int id)
    {
         return Optional.of(artistRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this Id ")));
    }

    public ArtistEntity updateEmployeeUser(int id ,  ArtistEntity artistEntity)
    {
         
              ArtistEntity artistEntityUser=artistRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this Id "));
              artistEntityUser.setName(artistEntity.getName());
              artistEntityUser.setEmail(artistEntity.getEmail());
              artistEntityUser.setBio(artistEntity.getBio());
              artistEntityUser.setArtworks(artistEntity.getArtworks());
              return artistRepo.save(artistEntityUser);
         
    }

    public ResponseEntity<Object> deleteUser( int id )
    {
      ArtistEntity employeeEntityUser = artistRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this Id "));
      artistRepo.delete(employeeEntityUser);
     return ResponseEntity.ok().build();
    }

    public Page< ArtistEntity> getPage(int page,int size ){
     Pageable pageable = PageRequest.of(page,size);
     return artistRepo.findAll(pageable);
    }
    
    public List<ArtistEntity> sorting(String sortBy , String sortDir){
     Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
     return artistRepo.findAll(sort);
    }

    public List<ArtistEntity> searchUserByName(String name)
    {
        return artistRepo.searchUserByName(name);
    }

 
}
