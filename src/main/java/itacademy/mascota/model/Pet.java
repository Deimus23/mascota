package itacademy.mascota.model;

import itacademy.mascota.enums.Complement;
import itacademy.mascota.enums.Environment;
import itacademy.mascota.enums.PetColor;
import itacademy.mascota.enums.PetType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private PetColor petColor;

    @Enumerated(EnumType.STRING)
    private PetType petType;

    @Enumerated(EnumType.STRING)
    private Environment environment;

    @Enumerated(EnumType.STRING)
    private Complement complement;

    private int life=100;
    private int happiness=100;
    private int energy=100;

}

