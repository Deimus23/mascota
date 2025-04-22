package itacademy.mascota.enums;

public enum Environment {
    CASTLE("Un majestuoso castillo con altos muros, torres de vigilancia y grandes salas. Perfecto para defenderse y realizar hechizos mágicos."),
    DUNGEON("Un laberinto oscuro y lleno de trampas. Ideal para aquellos que buscan aventuras peligrosas y enfrentarse a enemigos ocultos."),
    CITY("Una ciudad bulliciosa llena de vida, comerciantes y magia. Ideal para moverse rápidamente y usar la agilidad para escapar.");

    private final String description;

    Environment(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
