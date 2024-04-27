package com.training.center.training_center;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

/*
 Training center class has all the fields required to define a training center. Each attributes has their own getters and setters.
 Some of the attributes has all the necessary validation annotations.
 */

@Entity
class TrainingCenter {
    private @Id @GeneratedValue Long id;

    @NotNull(message = "Center name is required")
    @Size(min = 1, max = 40, message = "Center name should not exceed 40 characters")
    private String centerName;

    @NotNull(message = "Center code is required")
    @Size(min = 12, max = 12, message = "Center code should be 12 characters")
    private String centerCode;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Center address is required")
    private CenterAddress address;

    private int studentCapacity;
    private List<String> cources;
    private LocalDateTime createdOn;

    @Email(message = "Please enter valid email")
    private String contactEmail;

    @NotNull(message = "Phone is required")
    @Size(min = 10, max = 10, message = "Please enter valid phone")
    private String contactPhone;

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCenterName() {
        return this.centerName;
    }
    
    public void setCenterName(String CenterName) {
        this.centerName = CenterName;
    }
    
    public String getCenterCode() {
        return this.centerCode;
    }
    
    public void setCenterCode(String CenterCode) {
        this.centerCode = CenterCode;
    }

    public CenterAddress getAddress() {
        return this.address;
    }

    public void setAddress(CenterAddress address) {
        this.address = address;
    }

    public int getStudentCapacity() {
        return this.studentCapacity;
    }
    
    public void setStudentCapacity(int studentCapacity) {
        this.studentCapacity = studentCapacity;
    }
    
    public List<String> getCources() {
        return this.cources;
    }
    
    public void setCources(List<String> Cources) {
        this.cources = Cources;
    }
    
    public LocalDateTime getCreatedOn() {
        return this.createdOn;
    }
    
    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
    
    public String getContactEmail() {
        return this.contactEmail;
    }
    
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    
    public String getContactPhone() {
        return this.contactPhone;
    }
    
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
