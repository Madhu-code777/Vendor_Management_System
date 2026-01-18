package com.madhu.vendormanagementsystem.service.impl;
import com.madhu.vendormanagementsystem.entity.vendor;
import com.madhu.vendormanagementsystem.exception.DuplicateVendorNameException;
import com.madhu.vendormanagementsystem.exception.VendorNotFoundException;
import com.madhu.vendormanagementsystem.repository.VendorRepository;
import com.madhu.vendormanagementsystem.service.VendorService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("vendorServiceV1")
public class VendorServiceImplV1 implements VendorService{
    private final VendorRepository repo;
    public VendorServiceImplV1(VendorRepository repo){ this.repo = repo; }


    public vendor createUser(vendor user){
        if(repo.existsByNameIgnoreCase(user.getName()))
        {
            throw new DuplicateVendorNameException("vendor with name " + user.getName() + " already exists");
        }
        return repo.save(user);
    }


    public vendor getUserById(Long id){
        return repo.findById(id).orElseThrow(() -> new VendorNotFoundException("Vendor not found " + id));
    }


    public List<vendor> getAllUsers(){ return repo.findAll(); }


    public vendor updateUser(Long id, vendor user){
        vendor u = repo.findById(id).orElseThrow(()->new VendorNotFoundException("Vendor not found"));
        if(!u.getName().equalsIgnoreCase(user.getName()) && repo.existsByNameIgnoreCase(user.getName()))
        {
            throw new DuplicateVendorNameException("vendor with name " + user.getName() + " already exists");
        }
        //vendor u = getUserById(id);
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        return repo.save(u);
    }


    public void deleteUser(Long id){
        repo.deleteById(id);
    }

}
