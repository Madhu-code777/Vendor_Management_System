package com.madhu.vendormanagementsystem.Controller;
import com.madhu.vendormanagementsystem.dto.v2.VendorSummaryResponse;
import com.madhu.vendormanagementsystem.entity.vendor;
//import com.madhu.vendormanagementsystem.service.VendorService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
import java.util.List;
//import com.madhu.vendormanagementsystem.dto.v2.VendorSummaryResponse;
import com.madhu.vendormanagementsystem.service.VendorServiceV2;

@RestController
@RequestMapping("/api/v2/vendors")
public class VendorControllerV2 {
    private final VendorServiceV2 service;

    public VendorControllerV2(VendorServiceV2 service) {
        this.service = service;
    }

    //Get all
    @GetMapping
    public List<VendorSummaryResponse>getAll(){
        return service.getAllUsersV2();
    }

}