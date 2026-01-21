package com.madhu.vendormanagementsystem.service.impl;
import com.madhu.vendormanagementsystem.dto.v2.VendorSummaryResponse;
import com.madhu.vendormanagementsystem.entity.vendor;
import com.madhu.vendormanagementsystem.exception.VendorNotFoundException;
import com.madhu.vendormanagementsystem.repository.VendorRepository;
import com.madhu.vendormanagementsystem.service.VendorService;
import com.madhu.vendormanagementsystem.service.VendorServiceV2;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service("vendorServiceV2")
public class VendorServiceImplV2 implements VendorServiceV2{
    private final VendorRepository repo;
    public VendorServiceImplV2(VendorRepository repo){ this.repo = repo; }


    public vendor createUser(vendor user){
        user.setName(user.getName().toUpperCase());
        return repo.save(user);
    }


    public vendor getUserById(UUID id){
        return repo.findById(id).orElseThrow(()->new VendorNotFoundException("vendor not found with id " + id));
    }


    public List<VendorSummaryResponse> getAllUsersV2(){
        return repo.findAll().stream().map(v->new VendorSummaryResponse(v.getId(),v.getName(),v.getEmail())).toList();
    }


    public vendor updateUser(UUID id, vendor user){
        vendor existing = getUserById(id);
        existing.setName(user.getName().toUpperCase());
        existing.setEmail(user.getEmail());
        return repo.save(existing);
    }


    public void deleteUser(UUID id){
        repo.deleteById(id);
    }
    public void deleteAllUser()
    {
        repo.deleteAll();
    }
}
