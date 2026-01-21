package com.madhu.vendormanagementsystem.service;
import com.madhu.vendormanagementsystem.dto.v2.VendorSummaryResponse;
import com.madhu.vendormanagementsystem.entity.vendor;
import java.util.List;
import java.util.UUID;


public interface VendorService {
    vendor createUser(vendor user);
    vendor getUserById(UUID id);
    //List<VendorSummaryResponse> getAllUsersV2();
    vendor updateUser(UUID id, vendor user);
    void deleteUser(UUID id);
    void deleteAllUser();
    List<vendor> getAllUsers();

}
