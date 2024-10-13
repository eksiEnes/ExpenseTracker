package com.enes.expensetracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public class BaseEntity {
    @Column(name="createdDate")
    private LocalDateTime createdDate;
    @Column(name="updatedDate")
    private LocalDateTime updatedDate;

    @PrePersist
    public void onCreate()
    {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate()
    {
        updatedDate = LocalDateTime.now();
    }



}