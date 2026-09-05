package ejercicio3;

public class Bicicleta implements Vehiculo {
    private int velocidad = 0;

    @Override
    public void acelerar(int incremento) {
        if (incremento < 0) {
            throw new IllegalArgumentException("El incremento no puede ser negativo.");
        }
        this.velocidad += incremento;
        System.out.println("Bicicleta acelerando mediante pedaleo mecánico. Velocidad actual: " + this.velocidad + " km/h");
    }

    @Override
    public int getVelocidad() {
        return this.velocidad;
    }
}
