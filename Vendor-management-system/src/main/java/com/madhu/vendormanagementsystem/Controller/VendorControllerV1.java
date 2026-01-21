package com.madhu.vendormanagementsystem.Controller;
import com.madhu.vendormanagementsystem.entity.vendor;
import com.madhu.vendormanagementsystem.service.VendorService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/vendors")
public class VendorControllerV1 {
    private final VendorService service;

    public VendorControllerV1(@Qualifier("vendorServiceV1") VendorService service){
        this.service = service;
    }


    @PostMapping public vendor create(@Valid @RequestBody vendor user){
        return service.createUser(user);
    }


    @GetMapping("/{id}") public vendor get(@PathVariable UUID id){
        return service.getUserById(id);
    }


    @GetMapping public List<vendor> getAll(){
        return service.getAllUsers();
    }

    @PutMapping("/{id}")
    public vendor updateUser(@PathVariable UUID id,
                           @RequestBody vendor user) {
        return service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable UUID id) {
        service.deleteUser(id);
        return "vendor deleted successfully with id " + id;
    }
    @DeleteMapping
    public String deleteAllUser(){
        service.deleteAllUser();
        return "All Vendors deleted successfully";
    }
}
