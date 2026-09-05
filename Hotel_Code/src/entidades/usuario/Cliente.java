package entidades.usuario;

import hotel.reservas.*;
import java.util.List;
import java.util.ArrayList;

public class Cliente {
    private String idCliente;
    private String dni;
    private String nombreCompleto;
    private String email;
    private String telefono;
    private List<Reserva> historialReservas;

    public Cliente(String idCliente, String dni, String nombreCompleto,String email, String telefono)
    {
        this.idCliente = idCliente;
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.telefono = telefono;
        this.historialReservas = new ArrayList<>();
    }

    public void agregarReservaAlHistorial(Reserva reserva) 
    {
        if(reserva != null)
        {
            this.historialReservas.add(reserva);
        }
    }
    public List<Reserva> getHistorialReservas() {return this.historialReservas;}
    public String getIdCliente() {return this.idCliente;}
    public String getDni() {return dni;}
    public String getNombreCompleto() {return this.nombreCompleto;}
    public String getEmail() {return this.email;}
    public String getTelefono() {return this.telefono;}
    
    @Override
    public String toString() 
    {
        return "Cliente [" + 
                "idCliente=" + this.idCliente + '\'' + 
                ", dni=" + this.dni + '\'' +
                ", nombreCompleto=" + this.nombreCompleto + '\'' +
                ", email=" + this.email + '\'' +
                ", telefono=" + this.telefono + '\'' +
                "]";
    }
}
