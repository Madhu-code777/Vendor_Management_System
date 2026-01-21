package com.madhu.vendormanagementsystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.madhu.vendormanagementsystem.entity.vendor;
import java.util.Optional;
import java.util.UUID;

public interface VendorRepository extends JpaRepository<vendor, UUID> {
    boolean existsByNameIgnoreCase(String name);
    Optional<vendor>findByEmail(String email);
}
