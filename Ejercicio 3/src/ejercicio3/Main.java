package ejercicio3;

public class Main {

    /**
     * Demostración del Principio de Sustitución de Liskov (LSP).
     * Este método recibe la abstracción Vehiculo y opera sobre ella
     * sin necesitar verificar si es un Coche o una Bicicleta (sin instanceof).
     * Ambas clases sustituyen a Vehiculo de forma transparente y consistente.
     */
    public static void probarVehiculo(Vehiculo vehiculo) {
        vehiculo.acelerar(10);
        vehiculo.acelerar(15);
        System.out.println("  -> Velocidad final verificada: " + vehiculo.getVelocidad() + " km/h\n");
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  EJERCICIO 3: LISKOV SUBSTITUTION PRINCIPLE (LSP)");
        System.out.println("==================================================");

        Vehiculo miCoche = new Coche();
        Vehiculo miBicicleta = new Bicicleta();

        System.out.println("--- Prueba Polimórfica: Coche ---");
        probarVehiculo(miCoche);

        System.out.println("--- Prueba Polimórfica: Bicicleta ---");
        probarVehiculo(miBicicleta);

        System.out.println("Ambos subtipos cumplieron el contrato de la abstracción sin efectos colaterales.");
        System.out.println("==================================================");
    }
}
