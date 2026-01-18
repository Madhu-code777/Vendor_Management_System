package com.madhu.vendormanagementsystem.service;
import com.madhu.vendormanagementsystem.entity.vendor;
import java.util.List;



public interface VendorService {
    vendor createUser(vendor user);
    vendor getUserById(Long id);
    List<vendor> getAllUsers();
    vendor updateUser(Long id, vendor user);
    void deleteUser(Long id);

}
