package ejercicio3;

public class Coche implements Vehiculo {
    private int velocidad = 0;

    @Override
    public void acelerar(int incremento) {
        if (incremento < 0) {
            throw new IllegalArgumentException("El incremento no puede ser negativo.");
        }
        this.velocidad += incremento;
        System.out.println("Coche acelerando mediante motor de combustión/eléctrico. Velocidad actual: " + this.velocidad + " km/h");
    }

    @Override
    public int getVelocidad() {
        return this.velocidad;
    }
}
