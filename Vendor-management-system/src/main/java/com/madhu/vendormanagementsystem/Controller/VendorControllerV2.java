package com.madhu.vendormanagementsystem.Controller;
import com.madhu.vendormanagementsystem.entity.vendor;
import com.madhu.vendormanagementsystem.service.VendorService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/vendors")
public class VendorControllerV2 {
    private final VendorService service;

    public VendorControllerV2(@Qualifier("vendorServiceV2") VendorService service) {
        this.service = service;
    }


    @PostMapping
    public vendor create(@RequestBody vendor user) {
        return service.createUser(user);
    }
    //Get by id
    @GetMapping("/{id}")
    public vendor getById(@PathVariable long id)
    {
        return service.getUserById(id);
    }
    //Get all
    @GetMapping
    public List<vendor>getAll(){
        return service.getAllUsers();
    }

}