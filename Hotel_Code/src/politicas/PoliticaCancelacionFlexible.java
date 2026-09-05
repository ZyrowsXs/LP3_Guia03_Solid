package politicas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import hotel.reservas.Reserva;

public class PoliticaCancelacionFlexible implements PoliticaCancelacion {

    @Override
    public boolean puedeCancelar(Reserva reserva, LocalDate fechaCancelacion)
    {
        return ChronoUnit.DAYS.between(fechaCancelacion, reserva.getFechaCheckIn()) >= 1;
    }
    @Override
    public double calcularMontoReembolso(Reserva reserva, LocalDate fechaCancelacion)
    {
        if (puedeCancelar(reserva, fechaCancelacion))
        {
            return reserva.getMontoTotal();      
        }
        return 0.0;
    }
    @Override
    public String getNombrePolitica()
    {
        return "Flexible (100% de rembolso hasta 24h antes)";
    }
}