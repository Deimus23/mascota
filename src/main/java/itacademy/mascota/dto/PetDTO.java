package itacademy.mascota.dto;
import itacademy.mascota.enums.Complement;
import itacademy.mascota.enums.Environment;
import itacademy.mascota.enums.PetColor;
import itacademy.mascota.enums.PetType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO {
    private Long id;
    private String name;
    private PetColor petColor;
    private PetType petType;
    private Environment environment;
    private Complement complement;
    private int life;
    private int happiness;
    private int energy;
}
