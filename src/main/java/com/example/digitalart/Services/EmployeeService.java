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
import com.example.digitalart.Entity.EmployeeEntity;
import com.example.digitalart.Repository.EmployeeRepo;


@Service
public class EmployeeService {
 
    @Autowired
     private EmployeeRepo employeeRepo;
     public List<EmployeeEntity> getEmployeeUsers()
    {
         return employeeRepo.findAll();
    }

    public EmployeeEntity CreateEmployeeuser(EmployeeEntity employeeEntity)
    {
     return employeeRepo.save(employeeEntity);
    }
   
    public Optional<EmployeeEntity> getEmployeeUsersbyID(int id)
    {
         return Optional.of(employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this Id ")));
    }

    public EmployeeEntity updateEmployeeUser(int id ,  EmployeeEntity employeeEntity)
    {
         
              EmployeeEntity employeeEntityUser=employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this Id "));
              employeeEntityUser.setEmployeeName(employeeEntity.getEmployeeName());
              employeeEntityUser.setDesignation(employeeEntity.getDesignation());
              return employeeRepo.save(employeeEntityUser);
         
    }

    public ResponseEntity<Object> deleteUser( int id )
    {
      EmployeeEntity employeeEntityUser = employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with this Id "));
     employeeRepo.delete(employeeEntityUser);
     return ResponseEntity.ok().build();
    }


    public Page<EmployeeEntity> getPage(int page,int size ){
     Pageable pageable = PageRequest.of(page,size);
     return employeeRepo.findAll(pageable);
    }

//     public List<EmployeeEntity> getPage(String sortBy, String sortDir){
//      Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
//      Pageable pageable = PageRequest.of(0, 0, sort);
//      return employeeRepo.findAll(pageable);
//     }

    public List<EmployeeEntity> sortAll(){
        return employeeRepo.findAll(Sort.by(Sort.Direction.ASC,"employeeName"));
    }

 
}
