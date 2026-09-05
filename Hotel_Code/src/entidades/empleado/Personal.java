package entidades.empleado;

import java.util.List;
import hotel.habitaciones.*;
import java.util.ArrayList;
public class Personal {

    private String idEmpleado;
    private String nombre;
    private String turno;
    private List<Habitacion> habitacionesAsignadas;

    public Personal(String idEmpleado, String nombre, String turno)
    {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.turno = turno;
        this.habitacionesAsignadas = new ArrayList<>();
    }

    public void asignarHabitacion(Habitacion habitacion) {this.habitacionesAsignadas.add(habitacion);}
    public void LiberarAsignarHabitacion(Habitacion habitacion) 
    {
        if(habitacion != null && this.habitacionesAsignadas.contains(habitacion))
        {
            this.habitacionesAsignadas.remove(habitacion);
        }
    }
    
    public int getCargaTrabajo() {return this.habitacionesAsignadas.size();}
    public List<Habitacion> getHabitacionesAsignadas() {return this.habitacionesAsignadas;}
    public String getIdEmpleado() {return this.idEmpleado;}
    public String getNombre() {return this.nombre;}
    public String getTurno() {return this.turno;}
   
    @Override
    public String toString() 
    {
        return "Personal [" + 
        "idEmpleado=" + this.idEmpleado + '\'' +
        ", nombre=" + this.nombre + '\'' +
        ", turno=" + this.turno + '\'' +
        "]";
    }



}