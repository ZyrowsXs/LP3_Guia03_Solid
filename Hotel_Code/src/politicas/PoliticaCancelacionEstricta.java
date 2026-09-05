package politicas;

import java.time.LocalDate;

import hotel.reservas.Reserva;

public class PoliticaCancelacionEstricta implements PoliticaCancelacion {
    @Override
    public boolean puedeCancelar(Reserva reserva, LocalDate fechaCancelacion)
    {
        return false;
    }
    @Override
    public double calcularMontoReembolso(Reserva reserva, LocalDate fechaCancelacion)
    {
        return 0.0;
    }
    @Override
    public String getNombrePolitica()
    {
        return "Estricta (NO Reembolsable)";
    }
    
}
