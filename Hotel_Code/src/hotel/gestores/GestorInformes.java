package hotel.gestores;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import hotel.habitaciones.Habitacion;
import hotel.reservas.Reserva;

public class GestorInformes {
    private List<Reserva> reservas;
    private List<Habitacion> habitaciones;

    public GestorInformes(List<Habitacion> habitaciones, List<Reserva> reservas)
    {
        this.reservas = reservas;
        this.habitaciones = habitaciones;
    }

    public void generarInformesOcupacionPorTipo(LocalDate inicio, LocalDate fin)
    {
        System.out.println("---Informe de Ocupacion por Tipo");

        Map<String, Long> ocupacionPorTipo = this.reservas.stream()
        .filter(reservas -> !reservas.getFechaCheckOut().isBefore(inicio) && !reservas.getFechaCheckIn().isAfter(fin))
        .collect(Collectors.groupingBy(
            reserva -> reserva.getHabitacion().getTipo(), Collectors.counting()
        ));

        ocupacionPorTipo.forEach((tipo, cantidad) 
        -> System.out.println("Tipo: " + tipo + "- Habitaciones reservadas" + cantidad));
    }
    public void generarInformesIngresosPorPeriodo(LocalDate inicio, LocalDate fin)
    {
        double ingresosPeriodo = this.reservas.stream()
        .filter(r-> !r.getFechaCheckOut().isBefore(inicio) && !r.getFechaCheckIn().isAfter(fin))
        .mapToDouble(reserva -> reserva.getMontoTotal())
        .sum();

        System.out.println("Ingresos totales desde " + inicio + "Hasta " + fin + "=" + ingresosPeriodo);
    }

    public double calcularTotalIngresos()
    {
        double ingresosTotales = this.reservas.stream()
        .mapToDouble(reserva -> reserva.getMontoTotal())
        .sum();

        return ingresosTotales;
    }


}
