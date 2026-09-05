package hotel.habitaciones;

import hotel.servicios.*;
public class HabitacionSuite extends Habitacion implements ServicioComida,ServicioLavanderia,ServicioLimpieza {
    private boolean incluyeJacuzzi;
    private double recargoLujo;

    public HabitacionSuite(int numero, double precioBasePorNoche, boolean incluyeJacuzzi, double recargoLujo)
    {
        super(numero, "Lujo", precioBasePorNoche);
        this.recargoLujo = recargoLujo/100;
        this.incluyeJacuzzi = incluyeJacuzzi;
    }
    @Override
    public double calcularPrecioTotal(int noches) 
    {
        if(incluyeJacuzzi)
        {
            return precioBasePorNoche * noches  * (1 + this.recargoLujo) * 1.10;
        }
        return precioBasePorNoche * noches * (1 + this.recargoLujo);
    }
    @Override
    public int getCapacidadMaxima() {return 4;}
    @Override
    public void mostrarDetalles() 
    {
        System.out.println("===========");
        System.out.println("Numero de Habitacion: " + this.numero);
        System.out.println("Tipo de Habitacion: " + this.tipo);
        System.out.println("Precio base por noche: " + this.precioBasePorNoche);
        System.out.println("Incluye Jacuzzi: " + (this.incluyeJacuzzi ? "Si" : "No"));
        System.out.println("Recargo al Lujo: " + this.recargoLujo*100 + "%");
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
    
    @Override
    public void solicitarLavanderia(int prendas)
    {
        System.out.println("Lavando " + prendas + "de la habitacion Nro: " + this.numero);
        System.out.println("Tipo de Habitacion: " + this.tipo);
    }
}