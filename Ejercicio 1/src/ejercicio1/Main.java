package ejercicio1;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  EJERCICIO 1: SINGLE RESPONSIBILITY PRINCIPLE   ");
        System.out.println("==================================================");

        // Creación del empleado (solo almacena estado e identidad)
        Empleado empleado = new Empleado("Walter Figueroa", 36000.0, "Sistemas");

        // Cálculo salarial delegado a la clase especializada
        CalculadoraSalarial calculadora = new CalculadoraSalarial();
        double deducciones = 150.0;
        double pagoNeto = calculadora.calcularPagoMensual(empleado, deducciones);

        System.out.println("Información del Empleado:");
        System.out.println("  Nombre:        " + empleado.getNombre());
        System.out.println("  Departamento:  " + empleado.getDepartamento());
        System.out.printf("  Salario Anual: $%.2f%n", empleado.getSalarioAnual());
        System.out.println("--------------------------------------------------");
        System.out.printf("  Deducciones:   $%.2f%n", deducciones);
        System.out.printf("  Pago Neto:     $%.2f%n", pagoNeto);
        System.out.println("==================================================");
    }
}
