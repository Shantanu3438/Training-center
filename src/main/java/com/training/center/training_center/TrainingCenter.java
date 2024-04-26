package com.training.center.training_center;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
class TrainingCenter {
    private @Id @GeneratedValue Long id;
    private String CenterName;
    private String CenterCode;

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
}
