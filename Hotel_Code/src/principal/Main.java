package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entidades.usuario.Cliente;
import entidades.empleado.Personal;
import hotel.habitaciones.*;
import hotel.reservas.Reserva;
import hotel.gestores.GestorDisponibilidadHabitacion;
import hotel.servicios.*;
import politicas.*;
import notificaciones.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("    DEMOSTRACIÓN DE PRINCIPIOS SOLID (HOTEL)     ");
        System.out.println("=================================================");

        // -------------------------------------------------------------
        // 1. SRP: Responsabilidad Única (Entidades y Gestor separados)
        // -------------------------------------------------------------
        System.out.println("\n--- 1. SRP (Single Responsibility Principle) ---");
        Cliente cliente = new Cliente("C01", "72345678", "Juan Perez", "juan@mail.com", "987654321");
        Personal empleado = new Personal("E01", "Maria Lopez", "MAÑANA");

        Habitacion hab1 = new HabitacionSimple(101, 80.0, true);
        Habitacion hab2 = new HabitacionDoble(201, 120.0, 2);
        Habitacion hab3 = new HabitacionSuite(301, 250.0, true, 20.0);

        List<Habitacion> habitaciones = new ArrayList<>(List.of(hab1, hab2, hab3));
        List<Reserva> reservas = new ArrayList<>();
        GestorDisponibilidadHabitacion gestorDisp = new GestorDisponibilidadHabitacion(habitaciones, reservas);

        System.out.println("Cliente: " + cliente.getNombreCompleto() + " | Personal: " + empleado.getNombre());
        System.out.println("¿Hab. 101 disponible prox 3 dias?: " + 
            gestorDisp.verificarDisponibilidadHabitacion(hab1, LocalDate.now(), LocalDate.now().plusDays(3)));

        // -------------------------------------------------------------
        // 2. OCP: Abierto/Cerrado (Políticas intercambiables sin tocar Reserva)
        // -------------------------------------------------------------
        System.out.println("\n--- 2. OCP (Open/Closed Principle) ---");
        PoliticaCancelacion polFlex = new PoliticaCancelacionFlexible();
        PoliticaCancelacion polMod = new PoliticaCancelacionModerada();

        Reserva res1 = new Reserva("R01", cliente, hab1, LocalDate.now().plusDays(5), LocalDate.now().plusDays(7), polFlex);
        Reserva res2 = new Reserva("R02", cliente, hab2, LocalDate.now().plusDays(1), LocalDate.now().plusDays(3), polMod);
        reservas.add(res1);
        reservas.add(res2);

        LocalDate hoy = LocalDate.now();
        System.out.println("Reserva 1 (" + polFlex.getNombrePolitica() + ") cancelada hoy: " + 
            res1.cancelar(hoy) + " | Reembolso: S/." + res1.calcularReembolso(hoy));
        System.out.println("Reserva 2 (" + polMod.getNombrePolitica() + ") cancelada hoy: " + 
            res2.cancelar(hoy) + " | Reembolso: S/." + res2.calcularReembolso(hoy));

        // -------------------------------------------------------------
        // 3. LSP: Sustitución de Liskov (Cálculo polimórfico uniforme)
        // -------------------------------------------------------------
        System.out.println("\n--- 3. LSP (Liskov Substitution Principle) ---");
        for (Habitacion h : habitaciones) {
            System.out.println("Hab. #" + h.getNumero() + " (" + h.getTipo() + 
                ") -> 3 noches: S/." + h.calcularPrecioTotal(3) + " | Capacidad: " + h.getCapacidadMaxima() + " pers.");
        }

        // -------------------------------------------------------------
        // 4. ISP: Segregación de Interfaces (Servicios según capacidad)
        // -------------------------------------------------------------
        System.out.println("\n--- 4. ISP (Interface Segregation Principle) ---");
        for (Habitacion h : habitaciones) {
            System.out.println("Servicios para Hab #" + h.getNumero() + " (" + h.getTipo() + "):");
            if (h instanceof ServicioLimpieza) ((ServicioLimpieza) h).realizarLimpieza();
            if (h instanceof ServicioComida) ((ServicioComida) h).solicitarComida("Desayuno");
            if (h instanceof ServicioLavanderia) ((ServicioLavanderia) h).solicitarLavanderia(2);
        }

        // -------------------------------------------------------------
        // 5. DIP: Inversión de Dependencias (Inyección de CanalNotificacion)
        // -------------------------------------------------------------
        System.out.println("\n--- 5. DIP (Dependency Inversion Principle) ---");
        NotificacionReserva notificador = new NotificacionReserva(new EnviadorCorreo());
        System.out.print("Vía Email -> ");
        notificador.notificarCreacionReserva(res1);

        notificador.cambiarCanal(new EnviadorSMS());
        System.out.print("Vía SMS   -> ");
        notificador.notificarCancelacionReserva(res1, res1.calcularReembolso(hoy));

        notificador.cambiarCanal(new NotificadorSlack());
        System.out.print("Vía Slack -> ");
        notificador.notificarCreacionReserva(res2);

        System.out.println("\n=================================================");
        System.out.println("           DEMOSTRACIÓN FINALIZADA               ");
        System.out.println("=================================================");
    }
}