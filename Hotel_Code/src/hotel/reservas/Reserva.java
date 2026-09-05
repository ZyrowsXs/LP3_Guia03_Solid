package hotel.reservas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import entidades.usuario.Cliente;
import hotel.habitaciones.Habitacion;
import politicas.*;


public class Reserva {
    private String codigoReserva;
    private Cliente cliente;
    private Habitacion habitacion;
    private LocalDate fechaCheckIn;
    private LocalDate fechaCheckOut;
    private double montoTotal;
    private String estado;
    private PoliticaCancelacion politicaCancelacion;

    public Reserva (String codigoReserva, Cliente cliente, Habitacion habitacion,
        LocalDate fechaCheckIn, LocalDate fechaCheckOut, PoliticaCancelacion politicaCancelacion)
    {
        this.codigoReserva = codigoReserva;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.politicaCancelacion = politicaCancelacion;
        this.montoTotal = this.habitacion.calcularPrecioTotal(getCantidadNoches());
        this.estado = "Confirmada";
        this.habitacion.setDisponible(false);
        this.cliente.agregarReservaAlHistorial(this);
    }
    public boolean cancelar(LocalDate fechaCancelacion)
    {
        if (politicaCancelacion.puedeCancelar(this, fechaCancelacion))
        {
            this.estado = "Cancelada";
            this.habitacion.setDisponible(true);
            return true;
        }
        
        return false;
    }
    public double calcularReembolso(LocalDate fechaCancelacion)
    {
        return politicaCancelacion.calcularMontoReembolso(this, fechaCancelacion);
    }
    public int getCantidadNoches()
    {
        int dias = (int)ChronoUnit.DAYS.between(fechaCheckIn, fechaCheckOut);
        if ( dias <= 0)
        {
            System.out.println("Revisar las fechas de CheckOut y CheckIn Dias puestos 1");
            return 1;
        }
        return dias;
    }
    public String getCodigoReserva() {return this.codigoReserva;}
    public Cliente getCliente() {return this.cliente;}
    public Habitacion getHabitacion() {return this.habitacion;}
    public LocalDate getFechaCheckIn() {return this.fechaCheckIn;}
    public LocalDate getFechaCheckOut() {return this.fechaCheckOut;}
    public double getMontoTotal() {return this.montoTotal;}
    public String getEstado() {return this.estado;}
    public void setEstado(String estado) {this.estado = estado;}
    public PoliticaCancelacion getPoliticaCancelacion() {return this.politicaCancelacion;}
    public void setPoliticaCancelacion(PoliticaCancelacion politicaCancelacion) {this.politicaCancelacion = politicaCancelacion;}
    @Override
    public String toString()
    {
        return "Reserva [" +
        "codigoReserva=" + this.codigoReserva + '\'' +
        ", cliente=" +this.cliente.toString() + '\'' +
        ", habitacion=" + this.habitacion.toString() + '\'' +
        ", fechaCheckIn="+this.fechaCheckIn.toString() + '\'' +
        ", fechaCheckOut="+this.fechaCheckOut.toString() + '\'' +
        ", politicaCancelacion="+this.politicaCancelacion.toString() + '\'' +
        ", montoTotal="+this.montoTotal + '\'' +
        ", estado="+this.estado+ '\'' +
        "]";
    }



}