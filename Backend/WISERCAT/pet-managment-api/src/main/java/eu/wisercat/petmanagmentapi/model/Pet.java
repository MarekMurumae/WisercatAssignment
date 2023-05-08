package eu.wisercat.petmanagmentapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "identification_code", unique = true)
    private String identificationCode;

    @Column(name = "type")
    private String type;

    @Column(name = "fur_color")
    private String furColor;

    @Column(name = "country")
    private String country;
}

