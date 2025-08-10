package com.example.realEstateListing.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "properties")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String title;
    @Column(nullable=false)
    private String description;
    @Column(nullable=false)
    private Integer price;
    @Column(nullable=false)
    private String type;
    @Column(nullable=false)
    private String location;
    @Column(nullable=false)
    private Integer ownerId;
    @Column(nullable=false)
    private LocalDate dateListed;
    @Column(nullable=false)
    private Long userId;
    @Column(nullable=false)
    private String adminApproval;
    @Column(nullable=false)
    private String imageUrl;
    @Column(nullable=false)
    private String contactNumber;

    
}
