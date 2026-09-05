package politicas;

import java.time.LocalDate;

import hotel.reservas.Reserva;

public interface PoliticaCancelacion {
    boolean puedeCancelar(Reserva reserva,LocalDate fechaCancelacion);
    double calcularMontoReembolso(Reserva reserva, LocalDate fechaCancelacion);
    String getNombrePolitica();    
}
