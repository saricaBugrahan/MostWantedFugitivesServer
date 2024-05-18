package com.fugitive.server.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fugitive")
public class Fugitive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String name;
    private String surname;
    private String birthPlace;
    private String birthDate;
    private String organization;
    private String color;

    @Lob
    private String b64Image;

    private LocalDateTime createdDate;
}
