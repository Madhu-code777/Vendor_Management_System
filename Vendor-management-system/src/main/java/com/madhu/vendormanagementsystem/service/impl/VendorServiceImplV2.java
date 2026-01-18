package com.madhu.vendormanagementsystem.service.impl;
import com.madhu.vendormanagementsystem.entity.vendor;
import com.madhu.vendormanagementsystem.exception.VendorNotFoundException;
import com.madhu.vendormanagementsystem.repository.VendorRepository;
import com.madhu.vendormanagementsystem.service.VendorService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("vendorServiceV2")
public class VendorServiceImplV2 implements VendorService{
    private final VendorRepository repo;
    public VendorServiceImplV2(VendorRepository repo){ this.repo = repo; }


    public vendor createUser(vendor user){
        user.setName(user.getName().toUpperCase());
        return repo.save(user);
    }


    public vendor getUserById(Long id){
        return repo.findById(id).orElseThrow(()->new VendorNotFoundException("vendor not found with id " + id));
    }


    public List<vendor> getAllUsers(){
        return repo.findAll();
    }


    public vendor updateUser(Long id, vendor user){
        vendor existing = getUserById(id);
        existing.setName(user.getName().toUpperCase());
        existing.setEmail(user.getEmail());
        return repo.save(existing);
    }


    public void deleteUser(Long id){
        repo.deleteById(id);
    }
}
