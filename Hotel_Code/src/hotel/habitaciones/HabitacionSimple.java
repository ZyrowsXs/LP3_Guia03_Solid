package hotel.habitaciones;
import hotel.servicios.*;

public class HabitacionSimple extends Habitacion implements ServicioLimpieza {
    private boolean tieneEscritorio;

    public HabitacionSimple(int numero, double precioBasePorNoche, boolean tieneEscritorio)
    {
        super(numero,"Simple",precioBasePorNoche);
        this.tieneEscritorio = tieneEscritorio;
    }

    @Override
    public double calcularPrecioTotal(int noches) 
    {
        if (this.tieneEscritorio)
        {
            return (precioBasePorNoche * noches)*1.05;
        }
        return precioBasePorNoche * noches;
    }
    
    @Override
    public int getCapacidadMaxima() {return 1;}
    @Override
    public void mostrarDetalles() 
    {
        System.out.println("===========");
        System.out.println("Numero de Habitacion: " + this.numero);
        System.out.println("Tipo de Habitacion: " + this.tipo);
        System.out.println("Precio base por noche: " + this.precioBasePorNoche);
        System.out.println("Cuenta con Escritorio: " + (this.tieneEscritorio ? "Si" : "No"));
        System.out.println("Disponible: " + (this.disponible ? "Si" : "No"));
        System.out.println("===========");
    }
    @Override
    public void realizarLimpieza()
    {
        System.out.println("===========");
        System.out.println("Realizando limpieza en la habitacion Nro: " + this.numero);
        System.out.println("Tipo de habitacion: " + this.tipo);
        System.out.println("===========");
    }   
}