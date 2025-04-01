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
import com.example.digitalart.Entity.ArtworkEntity;
import com.example.digitalart.Repository.ArtworkRepo;

@Service
public class ArtworkService {
    @Autowired
    private ArtworkRepo artworkRepo;
     public List<ArtworkEntity> getEventUsers()
    {
         return artworkRepo.findAll();
    }

    public ArtworkEntity CreateEventuser(ArtworkEntity  artworkEntity)
    {
     return artworkRepo.save(artworkEntity);
    }
   
    public Optional<ArtworkEntity> getEventUsersbyID(@PathVariable Integer id)
    {
         return Optional.of(artworkRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this Id ")));
    }

    public ArtworkEntity updateEventUser(@PathVariable Integer id , @RequestBody ArtworkEntity artworkEntity)
    {
         
              ArtworkEntity artworkEntityUser=artworkRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this Id "));
              artworkEntityUser.setTitle(artworkEntity.getTitle());
              artworkEntityUser.setDescription(artworkEntity.getDescription());
              artworkEntityUser.setPrice(artworkEntity.getPrice());
              artworkEntityUser.setArtist(artworkEntity.getArtist());
              artworkEntityUser.setAuctions(artworkEntity.getAuctions());
          
               return artworkRepo.save(artworkEntityUser);
         
    }
    public String deleteUser(@PathVariable Integer id )
    {
      ArtworkEntity eventEntityUser = artworkRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this Id "));
      artworkRepo.delete(eventEntityUser);
       return "Delete Successs";
    }

     public Page<ArtworkEntity> getPage(int page,int size ){
     Pageable pageable = PageRequest.of(page,size);
     return artworkRepo.findAll(pageable);
    }
    
    public List<ArtworkEntity> sorting(String sortBy , String sortDir){
     Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
     return artworkRepo.findAll(sort);
    }

    public List<ArtworkEntity> searchUserByName(String title)
    {
        return artworkRepo.searchUserByName(title);
    }


}
