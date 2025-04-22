package itacademy.mascota.enums;


public enum Complement {
    WEAPON("Arma"),
    ARMOR("Armadura"),
    POTION("Poción");

    private final String description;

    Complement(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
