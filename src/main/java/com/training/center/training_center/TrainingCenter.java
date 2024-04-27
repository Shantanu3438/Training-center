package com.training.center.training_center;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
class TrainingCenter {
    private @Id @GeneratedValue Long id;
    private String CenterName;
    private String CenterCode;

    @OneToOne(cascade = CascadeType.ALL)
    private CenterAddress address;

    private int StudentCapacity;
    private List<String> Cources;
    private LocalDateTime CreatedOn;
    private String ContactEmail;
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

    @Override
    public String toString() {
        return "TrainingCenter{" +
                "id=" + id +
                ", CenterName='" + CenterName + '\'' +
                ", CenterCode='" + CenterCode + '\'' +
                ", address=" + address +
                ", StudentCapacity=" + StudentCapacity +
                ", Courses=" + Cources +
                ", CreatedOn=" + CreatedOn +
                ", ContactEmail='" + ContactEmail + '\'' +
                ", ContactPhone='" + ContactPhone + '\'' +
                '}';
    }
}
