package com.madhu.vendormanagementsystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.madhu.vendormanagementsystem.entity.vendor;
public interface VendorRepository extends JpaRepository<vendor, Long> {
    boolean existsByNameIgnoreCase(String name);
}
