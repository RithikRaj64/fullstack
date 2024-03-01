package com.educonnect.rithikraj.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_student")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    @Builder.Default
    private boolean completed = false;

    @Column(nullable = false)
    private String fatherName;

    @Column(nullable = false)
    private String motherName;

    @Column(nullable = false)
    private Date dob;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String emisNo;

    @Column(nullable = false)
    private String aadharNo;

    @Column(nullable = false)
    private String nationality;

    @Column(nullable = false)
    private String tenthBoard;

    @Column(nullable = false)
    private float tenthPercentage; 

    @Column(nullable = false)
    private String twelthBoard;

    @Column(nullable = false)
    private float twelthPercentage;

    @OneToOne(mappedBy = "student")
    private User user;

    @OneToMany(mappedBy = "student")
    private List<Application> applications;
}
