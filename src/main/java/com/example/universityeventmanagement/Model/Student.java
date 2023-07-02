package com.example.universityeventmanagement.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.boot.spi.AccessType;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="student")
public class Student {
    @Id
    private int studentId;
    @Pattern(regexp="([A-Z][a-zA-Z]*)+",message = "first letter should start with capital letter")
    private String firstName;
    private String lastName;
    @Min(value=18,message = "age must be above or equal to 18")
    @Max(value=25,message = "age must be below or equal to 25")
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Department department;
}
