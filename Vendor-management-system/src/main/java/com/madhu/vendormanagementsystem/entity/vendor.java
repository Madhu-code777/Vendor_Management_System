package com.madhu.vendormanagementsystem.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import java.util.UUID;

@Entity
public class vendor {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(unique = true)
    @NotBlank(message = "Vendor name must not be empty")
    private String name;
    @Email(message = "Email format is invalid")
    @NotBlank(message = "Email must not be empty")
    @Column(unique = true)
    private String email;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

}
