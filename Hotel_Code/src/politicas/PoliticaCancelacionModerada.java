package politicas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import hotel.reservas.Reserva;

public class PoliticaCancelacionModerada implements PoliticaCancelacion {
    @Override
    public boolean puedeCancelar(Reserva reserva, LocalDate fechaCancelacion)
    {
        return ChronoUnit.DAYS.between(fechaCancelacion, reserva.getFechaCheckIn()) >= 3;
    }
    @Override
    public double calcularMontoReembolso(Reserva reserva, LocalDate fechaCancelacion)
    {
        if (puedeCancelar(reserva, fechaCancelacion))
        {
            return reserva.getMontoTotal() *  0.5;      
        }
        return 0.0;
    }
    @Override
    public String getNombrePolitica()
    {
        return "Moderada (50% de rembolso hasta 72h antes)";
    }
}
