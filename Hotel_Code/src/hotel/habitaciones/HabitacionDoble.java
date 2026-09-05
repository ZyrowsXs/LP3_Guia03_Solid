package hotel.habitaciones;

import hotel.servicios.*;

public class HabitacionDoble extends Habitacion implements ServicioComida, ServicioLimpieza{
    private int cantidadCamas;

    public HabitacionDoble(int numero, double precioBasePorNoche, int cantidadCamas)
    {
        super(numero,"Doble", precioBasePorNoche);
        this.cantidadCamas = cantidadCamas;
    }
    @Override
    public double calcularPrecioTotal(int noches) 
    {
        if(cantidadCamas == 1)
        {
            return precioBasePorNoche * noches;
        }
        return precioBasePorNoche * noches * 1.07;
    }
    @Override
    public int getCapacidadMaxima() {return 2;}
    @Override
    public void mostrarDetalles() 
    {
        System.out.println("===========");
        System.out.println("Numero de Habitacion: " + this.numero);
        System.out.println("Tipo de Habitacion: " + this.tipo);
        System.out.println("Precio base por noche: " + this.precioBasePorNoche);
        System.out.println("Cantidad de camas: " + this.cantidadCamas);
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

    @Override
    public void solicitarComida(String comida)
    {
        System.out.println("LLevando comida a la habitacion Nro: "  + this.numero);
        System.out.println("Pedido: " + comida); 
    }

}