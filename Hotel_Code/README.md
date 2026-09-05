# 🏨 Sistema de Gestión de Reservas de Hotel (Principios SOLID)

Este proyecto implementa de forma integral las **5 Experiencias Prácticas de la Guía 03** de la asignatura **Lenguajes de Programación III (UCSM)**, aplicando rigurosamente los principios de diseño de software orientado a objetos **SOLID**.

---

## 🎯 Principios SOLID Aplicados

| Principio | Nombre | Aplicación en el Proyecto |
|---|---|---|
| **S** | **Single Responsibility Principle (SRP)** | Separación de entidades (`Cliente`, `Personal`) y delegación de la lógica de disponibilidad en `GestorDisponibilidadHabitacion` y de informes en `GestorInformes`. |
| **O** | **Open/Closed Principle (OCP)** | Creación de la interfaz `PoliticaCancelacion`. Se pueden agregar nuevas políticas (`Flexible`, `Moderada`, `Estricta`, etc.) sin modificar la clase `Reserva`. |
| **L** | **Liskov Substitution Principle (LSP)** | Clase base abstracta `Habitacion` con subclases `HabitacionSimple`, `HabitacionDoble` y `HabitacionSuite`. Todas son sustituibles polimórficamente sin alterar el comportamiento esperado. |
| **I** | **Interface Segregation Principle (ISP)** | Segregación de servicios adicionales en interfaces pequeñas y específicas: `ServicioLimpieza`, `ServicioComida` y `ServicioLavanderia`. Cada habitación implementa solo lo que ofrece. |
| **D** | **Dependency Inversion Principle (DIP)** | `NotificacionReserva` depende de la abstracción `CanalNotificacion` y no de implementaciones concretas. Se inyectan `EnviadorCorreo`, `EnviadorSMS` o `NotificadorSlack`. |

---

## 📂 Estructura de Paquetes y Clases

```
Hotel_Code/
├── Makefile
├── README.md
├── diagrama_hotel_solid.dot
└── src/
    ├── entidades/
    │   ├── empleado/
    │   │   └── Personal.java              # SRP: Gestión de empleados y turnos
    │   └── usuario/
    │       └── Cliente.java               # SRP: Datos del cliente e historial
    ├── hotel/
    │   ├── gestores/
    │   │   ├── GestorDisponibilidadHabitacion.java # SRP: Verificación de solapamiento de fechas
    │   │   └── GestorInformes.java        # SRP: Cálculo de ingresos y reportes
    │   ├── habitaciones/
    │   │   ├── Habitacion.java            # LSP: Superclase abstracta con contrato polimórfico
    │   │   ├── HabitacionSimple.java      # LSP: Subclase concreta (+ ServicioLimpieza)
    │   │   ├── HabitacionDoble.java       # LSP: Subclase concreta (+ Limpieza, Comida)
    │   │   └── HabitacionSuite.java       # LSP: Subclase concreta (+ Limpieza, Comida, Lavandería)
    │   ├── reservas/
    │   │   └── Reserva.java               # OCP: Utiliza PoliticaCancelacion por composición
    │   └── servicios/
    │       ├── ServicioLimpieza.java      # ISP: Interfaz específica de aseo
    │       ├── ServicioComida.java        # ISP: Interfaz específica de room service
    │       └── ServicioLavanderia.java   # ISP: Interfaz específica de lavandería
    ├── notificaciones/
    │   ├── CanalNotificacion.java         # DIP: Abstracción de canal de mensajería
    │   ├── EnviadorCorreo.java           # DIP: Implementación concreta de email
    │   ├── EnviadorSMS.java              # DIP: Implementación concreta de SMS
    │   ├── NotificadorSlack.java         # DIP: Implementación concreta de Slack
    │   └── NotificacionReserva.java      # DIP: Módulo de alto nivel con inyección por constructor
    ├── politicas/
    │   ├── PoliticaCancelacion.java       # OCP: Abstracción de política de cancelación
    │   ├── PoliticaCancelacionFlexible.java # OCP: 100% reembolso hasta 24h antes
    │   ├── PoliticaCancelacionModerada.java # OCP: 50% reembolso hasta 72h antes
    │   └── PoliticaCancelacionEstricta.java # OCP: Sin cancelaciones ni reembolsos
    └── principal/
        └── Main.java                      # Demostración en consola de los 5 principios
```

---

## 🚀 Compilación y Ejecución

### Opción 1: Con Makefile (Recomendado)
```bash
# Compilar y ejecutar
make run

# Solo compilar
make build

# Limpiar archivos generados
make clean
```

### Opción 2: Con comandos directos de Java
```bash
# Compilar todo el proyecto
mkdir -p bin
javac -d bin $(find src -name "*.java")

# Ejecutar la clase principal
java -cp bin principal.Main
```
