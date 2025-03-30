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

import com.example.digitalart.Entity.EmployeeEntity;
import com.example.digitalart.Services.EmployeeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/employeeuser")


public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;
    @GetMapping
    public List<EmployeeEntity> getEmployeeUsers()
    {
         return employeeService.getEmployeeUsers();
    }
    @PostMapping
    public EmployeeEntity CreateEmployeeuser(@RequestBody EmployeeEntity employeeEntity)
    {
     return employeeService.CreateEmployeeuser(employeeEntity);
    }

    @GetMapping("/{id}")
    public Optional<EmployeeEntity> getEmployeeUsersbyID(@PathVariable Integer id)
    {
         return employeeService.getEmployeeUsersbyID(id);
    }
    @PutMapping("/{id}")
    public EmployeeEntity updateEmployeeUser(@PathVariable Integer id , @RequestBody EmployeeEntity employeeEntity)
    {
         
            return employeeService.updateEmployeeUser(id, employeeEntity);
         
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id )
    {
        return employeeService.deleteUser(id);
    }

    @GetMapping("/pagination")
    public Page<EmployeeEntity> getPage(@RequestParam int page,@RequestParam int size  )
    {
         return employeeService.getPage(page, size);
    }
    @GetMapping("/sortingByName")
    public List<EmployeeEntity> getPage( )
    {
         return employeeService.sortAll();
    }


}
