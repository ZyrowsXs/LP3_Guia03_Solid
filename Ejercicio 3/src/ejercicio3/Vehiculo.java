package ejercicio3;

/**
 * Contrato base para todos los vehículos.
 * Según LSP (Liskov Substitution Principle), cualquier implementación
 * debe cumplir con las precondiciones y postcondiciones del contrato
 * de forma predecible sin lanzar excepciones inesperadas.
 */
public interface Vehiculo {

    /**
     * Incrementa la velocidad del vehículo.
     * @param incremento Magnitud de aceleración (> 0).
     */
    void acelerar(int incremento);

    /**
     * Retorna la velocidad actual del vehículo en km/h.
     * @return Velocidad no negativa.
     */
    int getVelocidad();
}
