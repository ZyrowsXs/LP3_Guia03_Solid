package ejercicio1;

/**
 * Clase que representa a un empleado y sus atributos fundamentales.
 * Cumple con SRP: Solo almacena y gestiona datos del empleado,
 * sin mezclar lógica de cálculo de salarios ni de impresión.
 */
public class Empleado {
    private String nombre;
    private double salarioAnual;
    private String departamento;

    public Empleado(String nombre, double salarioAnual, String departamento) {
        this.nombre = nombre;
        this.salarioAnual = salarioAnual;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalarioAnual() {
        return salarioAnual;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setSalarioAnual(double salarioAnual) {
        this.salarioAnual = salarioAnual;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Empleado [Nombre: " + nombre + ", Salario Anual: $" + salarioAnual + ", Departamento: " + departamento + "]";
    }
}
