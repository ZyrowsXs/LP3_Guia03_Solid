package hotel.habitaciones;

import java.lang.String;

public abstract class Habitacion {
    protected int numero;
    protected String tipo;
    protected double precioBasePorNoche;
    protected boolean disponible;

    public Habitacion (int numero, String tipo, double precioBasePorNoche)
    {
        this.numero = numero;
        this.tipo = tipo;
        this.precioBasePorNoche = precioBasePorNoche;
        this.disponible = true;
    }

    public abstract double calcularPrecioTotal(int noches) ;
    public abstract int getCapacidadMaxima();
    public abstract void mostrarDetalles() ;

    public int getNumero() {return this.numero;}
    public String getTipo() {return this.tipo;}
    public double getPrecioBasePorNoche() {return this.precioBasePorNoche;}
    public boolean isDisponible() {return this.disponible;}
    public void setDisponible(boolean disponible) {this.disponible = disponible;}     

    @Override
    public String toString()
    {
        return "Habitacion [" +
               "numero=" + this.numero + 
               ", tipo='" + this.tipo + '\'' + 
               ", precioBasePorNoche=" + this.precioBasePorNoche + 
               ", disponible=" + this.disponible + 
               "]";
    }
}