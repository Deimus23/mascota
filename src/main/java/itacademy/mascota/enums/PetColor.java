package itacademy.mascota.enums;

public enum PetColor {
    RED("#FF0000", "Color rojo brillante"),
    GREEN("#00FF00", "Color verde vibrante"),
    BLUE("#0000FF", "Color azul profundo");

    private final String hexCode;
    private final String description;

    PetColor(String hexCode, String description) {
        this.hexCode = hexCode;
        this.description = description;
    }

    public String getHexCode() {
        return hexCode;
    }

    public String getDescription() {
        return description;
    }
}
