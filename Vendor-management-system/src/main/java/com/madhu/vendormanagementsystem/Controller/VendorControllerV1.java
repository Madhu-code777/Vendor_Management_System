package com.madhu.vendormanagementsystem.Controller;
import com.madhu.vendormanagementsystem.entity.vendor;
import com.madhu.vendormanagementsystem.service.VendorService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vendors")
public class VendorControllerV1 {
    private final VendorService service;

    public VendorControllerV1(@Qualifier("vendorServiceV1") VendorService service){
        this.service = service;
    }


    @PostMapping public vendor create(@RequestBody vendor user){
        return service.createUser(user);
    }


    @GetMapping("/{id}") public vendor get(@PathVariable Long id){
        return service.getUserById(id);
    }


    @GetMapping public List<vendor> getAll(){
        return service.getAllUsers();
    }

    //devtool testing
  /*  @GetMapping("/test")
    public String test() {
        return "DEVTOOLS WORKING - V1";
    }*/


    @PutMapping("/{id}")
    public vendor updateUser(@PathVariable Long id,
                           @RequestBody vendor user) {
        return service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "vendor deleted successfully with id " + id;
    }
}
