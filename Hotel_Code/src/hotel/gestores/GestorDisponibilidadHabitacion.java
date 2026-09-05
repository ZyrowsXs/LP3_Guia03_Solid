package hotel.gestores;

import java.time.LocalDate;
import java.util.List;

import java.util.stream.Collectors;

import hotel.habitaciones.Habitacion;
import hotel.reservas.Reserva;

public class GestorDisponibilidadHabitacion {
    private List<Reserva> listaReservas;
    private List<Habitacion> listaHabitaciones;

    public GestorDisponibilidadHabitacion(List<Habitacion> habitaciones, List<Reserva> reservas)
    {
        this.listaHabitaciones = habitaciones;
        this.listaReservas = reservas;
    }
    public boolean verificarDisponibilidadHabitacion(Habitacion habitacion, LocalDate inicio, LocalDate fin)
    {
        boolean disponibilidad = this.listaReservas.stream()
        .filter(reserva -> reserva.getHabitacion().equals(habitacion))
        .anyMatch(reserva -> inicio.isBefore(reserva.getFechaCheckOut()) && fin.isAfter(reserva.getFechaCheckIn()));
        
        return !disponibilidad;   
    }
    public  List<Habitacion> buscarHabitacionesDisponibles(String tipo,LocalDate inicio, LocalDate fin)
    {
        List<Habitacion> habitacionesDisponibles = this.listaHabitaciones.stream()
        .filter(hab -> hab.getTipo().equalsIgnoreCase(tipo))
        .filter(hab -> verificarDisponibilidadHabitacion(hab,inicio,fin))
        .collect(Collectors.toList());

        return habitacionesDisponibles;
    }
    public void marcarHabitacionOcupada(Habitacion hab)
    {
        this.listaHabitaciones.stream()
        .filter(h-> h.getNumero() == hab.getNumero())
        .findFirst()
        .ifPresent(h->h.setDisponible(false));
    }
    public void marcarHabitacionDisponible(Habitacion hab)
    {
        this.listaHabitaciones.stream()
        .filter(h->h.getNumero() == hab.getNumero())
        .findFirst()
        .ifPresent(h->h.setDisponible(true));
    }
}
