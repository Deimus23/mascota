package itacademy.mascota.enums;

public enum PetType {
    THANK("Tanque, especializado en defensa"),
    ASSASSIN(" Especializado en daño rápido, pero con poca defensa."),
    WIZARD("Especializado en hechizos y ataques a distancia."),
    BARD("Usa música o sonidos para atacar ");
    private final String description;

    PetType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }



}
