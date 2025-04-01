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

import com.example.digitalart.Repository.AuctionRepo;
import com.example.digitalart.ResourceNotFoundException;

import com.example.digitalart.Entity.AuctionEntity;
import java.util.List;
import java.util.Optional;

@Service
public class AuctionService {
    @Autowired
    AuctionRepo auctionRepo;
    public List<AuctionEntity> getGuestUser()
    { 
        return auctionRepo.findAll();
    }
    public AuctionEntity createGuestuser(AuctionEntity auctionEntity)
    {
         return auctionRepo.save(auctionEntity);
    }

    public Optional<AuctionEntity> getguestUsersbyID(@PathVariable Integer id)
    {
         return Optional.of(auctionRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this Id ")));
    }

    public AuctionEntity updateGuestUser(@PathVariable Integer id , @RequestBody  AuctionEntity auctionEntity)
    {
         
             AuctionEntity auctionEntityUser=auctionRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this Id "));
             auctionEntityUser.setTitle(auctionEntity.getTitle());
             auctionEntityUser.setStartDate(auctionEntity.getStartDate());
             auctionEntityUser.setEndDate(auctionEntity.getEndDate());
             auctionEntityUser.setStartingPrice(auctionEntity.getStartingPrice());
             auctionEntityUser.setArtwork(auctionEntity.getArtwork());
            return auctionRepo.save(auctionEntityUser);
         
    }
     public ResponseEntity<Object> deleteUser(@PathVariable Integer id )
    {
      AuctionEntity guestEntityUser = auctionRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this Id "));
      auctionRepo.delete(guestEntityUser);
       return ResponseEntity.ok().build();
    }

     public Page<AuctionEntity> getPage(int page,int size ){
     Pageable pageable = PageRequest.of(page,size);
     return auctionRepo.findAll(pageable);
    }
    
    public List<AuctionEntity> sorting(String sortBy , String sortDir){
     Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
     return auctionRepo.findAll(sort);
    }

    public List<AuctionEntity> searchUserByName(String title)
    {
        return auctionRepo.searchUserByName(title);
    }


}
