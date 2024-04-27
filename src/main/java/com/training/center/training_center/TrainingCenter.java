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
    private String CenterName;

    @NotNull(message = "Center code is required")
    @Size(min = 12, max = 12, message = "Center code should be 12 characters")
    private String CenterCode;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Center address is required")
    private CenterAddress address;

    private int StudentCapacity;
    private List<String> Cources;
    private LocalDateTime CreatedOn;

    @Email(message = "Please enter valid email")
    private String ContactEmail;

    @NotNull(message = "Phone is required")
    @Size(min = 10, max = 10, message = "Please enter valid phone")
    private String ContactPhone;

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCenterName() {
        return this.CenterName;
    }
    
    public void setCenterName(String CenterName) {
        this.CenterName = CenterName;
    }
    
    public String getCenterCode() {
        return this.CenterCode;
    }
    
    public void setCenterCode(String CenterCode) {
        this.CenterCode = CenterCode;
    }

    public CenterAddress getAddress() {
        return this.address;
    }

    public void setAddress(CenterAddress address) {
        this.address = address;
    }

    public int getStudentCapacity() {
        return this.StudentCapacity;
    }
    
    public void setStudentCapacity(int studentCapacity) {
        this.StudentCapacity = studentCapacity;
    }
    
    public List<String> getCources() {
        return this.Cources;
    }
    
    public void setCources(List<String> Cources) {
        this.Cources = Cources;
    }
    
    public LocalDateTime getCreatedOn() {
        return this.CreatedOn;
    }
    
    public void setCreatedOn(LocalDateTime createdOn) {
        this.CreatedOn = createdOn;
    }
    
    public String getContactEmail() {
        return this.ContactEmail;
    }
    
    public void setContactEmail(String contactEmail) {
        this.ContactEmail = contactEmail;
    }
    
    public String getContactPhone() {
        return this.ContactPhone;
    }
    
    public void setContactPhone(String contactPhone) {
        this.ContactPhone = contactPhone;
    }
}
