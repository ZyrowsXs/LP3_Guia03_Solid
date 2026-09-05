package ejercicio1;

/**
 * Clase encargada exclusivamente del cálculo financiero y salarial.
 * Cumple con SRP: Si las reglas tributarias o de deducciones cambian,
 * solo esta clase se modifica, dejando intacta a la entidad Empleado.
 */
public class CalculadoraSalarial {

    /**
     * Calcula el salario mensual neto descontando deducciones aplicables.
     * @param empleado Empleado sobre el que se calcula.
     * @param deducciones Descuentos legales o adicionales del mes.
     * @return Pago neto mensual calculado.
     */
    public double calcularPagoMensual(Empleado empleado, double deducciones) {
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo.");
        }
        double salarioBaseMensual = empleado.getSalarioAnual() / 12.0;
        return Math.max(0.0, salarioBaseMensual - deducciones);
    }
}
