package notificaciones;

import hotel.reservas.Reserva;

public class NotificacionReserva{
    private CanalNotificacion canal;
    public NotificacionReserva(CanalNotificacion canal)
    {
        this.canal = canal;
    }
    public void cambiarCanal(CanalNotificacion nuevoCanal) {this.canal = nuevoCanal;}
    public void notificarCreacionReserva(Reserva reserva)
    {
        String mensaje = "Reserva realizada con Exito :) " + '\'' +
        "La fecha del check-in : " + reserva.getFechaCheckIn() + '\'' + 
        "check-out : " + reserva.getFechaCheckOut() +  '\''  +
        " Monto Total : " + reserva.getMontoTotal() + "$" + '\'' +  
        " Tipo de Politica Aplicada : " + reserva.getPoliticaCancelacion().getNombrePolitica();

        canal.enviar(reserva.getCliente().getEmail(),mensaje);
    }
    public void notificarCancelacionReserva(Reserva reserva, double reembolso) {
        String mensaje = "Reserva [" + reserva.getCodigoReserva() + "] cancelada. " +
        "Monto a reembolsar: S/." + reembolso + " según política: " +
        reserva.getPoliticaCancelacion().getNombrePolitica();
        canal.enviar(reserva.getCliente().getEmail(), mensaje);
    }
}



