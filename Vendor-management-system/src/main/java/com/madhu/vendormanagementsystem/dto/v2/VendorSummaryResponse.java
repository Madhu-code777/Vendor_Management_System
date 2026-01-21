package com.madhu.vendormanagementsystem.dto.v2;
import java.util.UUID;

public class VendorSummaryResponse {

        private UUID id;
        private String name;
        private String email;
        private String vendorCategory;

        public VendorSummaryResponse(UUID vendorId, String vendorName, String email) {
            this.id = vendorId;
            this.name = vendorName;
            this.email = email;
            this.vendorCategory = "STANDARD_VENDOR";
        }

        public UUID getVendorId() {
            return id;
        }

        public String getVendorName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getVendorCategory() {
            return vendorCategory;
        }
}
