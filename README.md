# 🏛️ Universidad Católica de Santa María
## Escuela Profesional de Ingeniería de Sistemas
### Asignatura: Lenguajes de Programación III
**Práctica de Laboratorio N° 03: Programación Orientada a Objetos Avanzada — Principios SOLID**

---

[![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![SOLID](https://img.shields.io/badge/Architecture-SOLID%20Principles-00599C?style=for-the-badge)](https://en.wikipedia.org/wiki/SOLID)
[![Build](https://img.shields.io/badge/Build-Passing-brightgreen?style=for-the-badge&logo=make)](https://www.gnu.org/software/make/)

---

## 📋 Tabla de Contenidos
1. [Descripción General](#-descripción-general)
2. [Fundamentos Teóricos de los Principios SOLID](#-fundamentos-teóricos-de-los-principios-solid)
3. [Estructura del Repositorio](#-estructura-del-repositorio)
4. [Actividad Principal: Sistema de Gestión Hotelera (`Hotel_Code`)](#-actividad-principal-sistema-de-gestión-hotelera-hotel_code)
5. [Ejercicios Propuestos](#-ejercicios-propuestos)
   - [Ejercicio 1: SRP (Empleado y Calculadora Salarial)](#ejercicio-1-principio-de-responsabilidad-única-srp)
   - [Ejercicio 2: OCP (Jerarquía de Formas Geométricas)](#ejercicio-2-principio-abiertocerrado-ocp)
   - [Ejercicio 3: LSP (Vehículo: Coche y Bicicleta)](#ejercicio-3-principio-de-sustitución-de-liskov-lsp)
   - [Ejercicio 4: ISP (Impresoras y Escáneres Segregados)](#ejercicio-4-principio-de-segregación-de-interfaces-isp)
6. [Guía de Compilación y Ejecución](#-guía-de-compilación-y-ejecución)
7. [Guía para Subir este Proyecto a GitHub](#-guía-para-subir-este-proyecto-a-github)

---

## 📖 Descripción General

Este repositorio contiene la solución completa, modular y documentada correspondiente a la **Guía Práctica N° 03** del curso de **Lenguajes de Programación III (UCSM)**. El objetivo primordial es demostrar la transición desde diseños acoplados y frágiles hacia arquitecturas de software robustas, flexibles, mantenibles y extensibles mediante la aplicación rigurosa de los **5 Principios SOLID**.

El proyecto abarca:
* **Actividad Principal Integral (`Hotel_Code`)**: Un sistema empresarial de gestión de reservas de hotel que articula armónicamente los 5 principios SOLID en un único dominio.
* **4 Ejercicios Propuestos (`Ejercicio 1` a `Ejercicio 4`)**: Casos de estudio independientes enfocados en resolver problemas específicos de violación arquitectónica para cada principio individual.

---

## 🧠 Fundamentos Teóricos de los Principios SOLID

Los principios SOLID, acuñados por Robert C. Martin ("Uncle Bob"), representan las cinco reglas fundamentales para el diseño de software orientado a objetos de calidad profesional:

| Sigla | Principio | Definición Formal | Problema que Resuelve | Solución de Diseño |
|---|---|---|---|---|
| **S** | **Single Responsibility Principle (SRP)** | *Una clase debe tener una, y solo una, razón para cambiar.* | Clases "God Object", código acoplado, dificultad para pruebas unitarias. | Dividir responsabilidades en clases pequeñas con una única tarea bien definida. |
| **O** | **Open/Closed Principle (OCP)** | *Las entidades de software deben estar abiertas a la extensión, pero cerradas a la modificación.* | Modificar clases base existentes para cada nuevo requisito, introduciendo errores colaterales. | Abstracciones (interfaces y clases abstractas) y polimorfismo dinámico. |
| **L** | **Liskov Substitution Principle (LSP)** | *Los objetos de un programa deben poder ser reemplazados por instancias de sus subtipos sin alterar la corrección del programa.* | Subclases que rompen el contrato de la superclase (lanzando excepciones no esperadas o anulando métodos). | Contratos polimórficos consistentes donde los subtipos respeten pre y postcondiciones. |
| **I** | **Interface Segregation Principle (ISP)** | *Los clientes no deben ser forzados a depender de interfaces con métodos que no utilizan.* | "Fat Interfaces" (interfaces infladas), clases obligadas a implementar métodos vacíos o con excepciones. | Dividir interfaces grandes en interfaces atómicas, cohesivas y específicas. |
| **D** | **Dependency Inversion Principle (DIP)** | *Los módulos de alto nivel no deben depender de módulos de bajo nivel; ambos deben depender de abstracciones.* | Alto acoplamiento a implementaciones concretas, rigidez arquitectónica y baja testeabilidad. | Inyección de dependencias (por constructor) a través de contratos de interfaz. |

---

## 🗂️ Estructura del Repositorio

```
LP3_Guia03_SOLID/
├── Makefile                               # Orquestador global de compilación y ejecución
├── README.md                              # Documentación técnica central del repositorio
├── .gitignore                             # Filtro de archivos no versionables (binarios, IDEs)
│
├── Hotel_Code/                            # ACTIVIDAD PRINCIPAL: SISTEMA DE RESERVAS DE HOTEL
│   ├── Makefile                           # Automatización local de Hotel_Code
│   ├── README.md                          # Documentación del sistema de reservas
│   ├── diagrama_hotel_solid.dot           # Diagrama Graphviz del modelo y arquitectura
│   └── src/
│       ├── entidades/
│       │   ├── empleado/Personal.java     # SRP: Gestión del empleado y su turno
│       │   └── usuario/Cliente.java       # SRP: Información y reservas del cliente
│       ├── hotel/
│       │   ├── gestores/
│       │   │   ├── GestorDisponibilidadHabitacion.java # SRP: Verificación de solapamiento de fechas
│       │   │   └── GestorInformes.java    # SRP: Métricas de ingresos y reportes
│       │   ├── habitaciones/
│       │   │   ├── Habitacion.java        # LSP: Superclase abstracta con contrato base
│       │   │   ├── HabitacionSimple.java  # LSP: Subtipo concreto (+ Limpieza)
│       │   │   ├── HabitacionDoble.java   # LSP: Subtipo concreto (+ Limpieza, Comida)
│       │   │   └── HabitacionSuite.java   # LSP: Subtipo concreto (+ Limpieza, Comida, Lavandería)
│       │   ├── reservas/Reserva.java      # OCP: Asocia políticas por composición
│       │   └── servicios/
│       │       ├── ServicioLimpieza.java  # ISP: Interfaz segregada de aseo
│       │       ├── ServicioComida.java    # ISP: Interfaz segregada de alimentación
│       │       └── ServicioLavanderia.java # ISP: Interfaz segregada de lavandería
│       ├── notificaciones/
│       │   ├── CanalNotificacion.java     # DIP: Abstracción de canal de comunicación
│       │   ├── EnviadorCorreo.java        # DIP: Implementación concreta Email
│       │   ├── EnviadorSMS.java           # DIP: Implementación concreta SMS
│       │   ├── NotificadorSlack.java      # DIP: Implementación concreta Slack
│       │   └── NotificacionReserva.java  # DIP: Módulo de alto nivel con inyección por constructor
│       ├── politicas/
│       │   ├── PoliticaCancelacion.java   # OCP: Interfaz de política de cancelación
│       │   ├── PoliticaCancelacionFlexible.java # OCP: 100% reembolso hasta 24h
│       │   ├── PoliticaCancelacionModerada.java # OCP: 50% reembolso hasta 72h
│       │   └── PoliticaCancelacionEstricta.java # OCP: Sin derecho a reembolso
│       └── principal/
│           └── Main.java                  # Runner demostrativo en consola
│
├── Ejercicio 1/                           # EJERCICIO 1: SINGLE RESPONSIBILITY PRINCIPLE (SRP)
│   ├── Makefile                           # Automatización del ejercicio
│   ├── README.md                          # Detalle conceptual y resolución
│   └── src/ejercicio1/
│       ├── Empleado.java                  # Modelo de datos puro del trabajador
│       ├── CalculadoraSalarial.java       # Servicio financiero de cálculo de nómina
│       └── Main.java                      # Demostración del principio
│
├── Ejercicio 2/                           # EJERCICIO 2: OPEN/CLOSED PRINCIPLE (OCP)
│   ├── Makefile                           # Automatización del ejercicio
│   ├── README.md                          # Detalle conceptual y resolución
│   └── src/
│       ├── FormasGeometricas/
│       │   ├── Forma.java                 # Clase base abstracta extensible
│       │   ├── Circulo.java               # Subclase concreta existente
│       │   ├── Rectangulo.java            # Subclase concreta existente
│       │   └── Triangulo.java             # NUEVA FORMA agregada sin modificar código previo
│       └── Main.java                      # Invocación polimórfica en bucle
│
├── Ejercicio 3/                           # EJERCICIO 3: LISKOV SUBSTITUTION PRINCIPLE (LSP)
│   ├── Makefile                           # Automatización del ejercicio
│   ├── README.md                          # Detalle conceptual y resolución
│   └── src/ejercicio3/
│       ├── Vehiculo.java                  # Interfaz con el contrato funcional común
│       ├── Coche.java                     # Subtipo con aceleración por motor
│       ├── Bicicleta.java                 # Subtipo con aceleración por pedaleo
│       └── Main.java                      # Validación de sustitución sin efectos laterales
│
└── Ejercicio 4/                           # EJERCICIO 4: INTERFACE SEGREGATION PRINCIPLE (ISP)
    ├── Makefile                           # Automatización del ejercicio
    ├── README.md                          # Detalle conceptual y resolución
    └── src/ejercicio4/
        ├── Imprimible.java                # Interfaz especializada en impresión
        ├── Escaneable.java                # Interfaz especializada en escaneo
        ├── Impresora.java                 # Solo implementa Imprimible (sin forzar escaneo)
        ├── ImpresoraMultifuncional.java   # Implementa Imprimible y Escaneable
        └── Main.java                      # Validación cliente con tipos segregados
```

---

## 🏨 Actividad Principal: Sistema de Gestión Hotelera (`Hotel_Code`)

El sistema modela una plataforma hotelera moderna resolviendo los retos planteados en las **5 Experiencias Prácticas**:

### 1. Experiencia N° 01: Single Responsibility Principle (SRP)
* **Problema:** Si `Habitacion` verificara solapamiento de fechas, administrara informes y gestionara el personal, se convertiría en un "God Object".
* **Refactorización:** 
  * `Cliente`: Almacena exclusivamente datos personales e historial de reservas.
  * `Personal`: Modela al empleado de limpieza y su asignación de turnos.
  * `GestorDisponibilidadHabitacion`: Lógica dedicada a calcular disponibilidad en calendarios de fechas sin acoplar a la entidad de datos.
  * `GestorInformes`: Centraliza la generación de estadísticas y reportes de facturación.

### 2. Experiencia N° 02: Open/Closed Principle (OCP)
* **Problema:** Condicionales `switch` o `if-else` en `Reserva` para calcular multas o cancelaciones obligan a reescribir `Reserva` con cada nueva política comercial.
* **Refactorización:**
  * Se diseñó la interfaz `PoliticaCancelacion`.
  * Se implementaron de forma independiente:
    * `PoliticaCancelacionFlexible`: Reembolso íntegro (100%) si se cancela hasta 24 horas antes del check-in.
    * `PoliticaCancelacionModerada`: Reembolso parcial (50%) si se cancela hasta 72 horas antes.
    * `PoliticaCancelacionEstricta`: No admite cancelaciones ni reembolsos tras confirmar.
  * `Reserva` colabora con `PoliticaCancelacion` mediante composición, admitiendo infinitas nuevas políticas futuras sin alterar una sola línea de código existente.

### 3. Experiencia N° 03: Liskov Substitution Principle (LSP)
* **Problema:** Si un tipo de habitación altera de forma inesperada la firma o cálculo de precios o capacidad máxima, el sistema fallaría al tratar habitaciones de manera genérica.
* **Refactorización:**
  * Superclase abstracta `Habitacion` con métodos abstractos definidos: `calcularPrecioTotal(int noches)`, `getCapacidadMaxima()` y `mostrarDetalles()`.
  * Subclases `HabitacionSimple`, `HabitacionDoble` y `HabitacionSuite` honran de manera transparente y predecible el contrato base. El cliente puede iterar `List<Habitacion>` y calcular importes polimórficamente con total consistencia.

### 4. Experiencia N° 04: Interface Segregation Principle (ISP)
* **Problema:** Una interfaz pesada `ServicioHabitacion` obligaría a una habitación simple económica a declarar servicios que físicamente no ofrece (ej. lavandería o room service de lujo).
* **Refactorización:**
  * Se segregaron tres interfaces atómicas:
    * `ServicioLimpieza` (implementada por Simple, Doble y Suite).
    * `ServicioComida` (implementada por Doble y Suite).
    * `ServicioLavanderia` (implementada exclusivamente por Suite).
  * Ninguna clase se ve forzada a implementar métodos "fantasma" o lanzar excepciones ficticias.

### 5. Experiencia N° 05: Dependency Inversion Principle (DIP)
* **Problema:** Si el sistema de notificaciones instanciara internamente `new EnviadorCorreo()`, sería imposible notificar por SMS, Slack o WhatsApp sin reescribir la lógica de notificaciones.
* **Refactorización:**
  * Se creó la interfaz de abstracción `CanalNotificacion`.
  * Se implementaron los canales desacoplados: `EnviadorCorreo`, `EnviadorSMS` y `NotificadorSlack`.
  * `NotificacionReserva` recibe la interfaz en su constructor (inyección de dependencias) y permite cambiar dinámicamente el canal en tiempo de ejecución con `cambiarCanal(CanalNotificacion nuevoCanal)`.

---

## 🎯 Ejercicios Propuestos

### Ejercicio 1: Principio de Responsabilidad Única (SRP)
* **Objetivo:** Refactorizar la clase `Empleado` que almacenaba datos del trabajador y además calculaba su liquidación mensual.
* **Solución:** 
  * `Empleado` encapsula exclusivamente estado (`nombre`, `salarioAnual`, `departamento`).
  * `CalculadoraSalarial` encapsula la lógica matemática y deducciones del pago mensual.
  * Si la fórmula salarial cambia, solo se modifica `CalculadoraSalarial`; si cambian datos del empleado, solo se modifica `Empleado`.

### Ejercicio 2: Principio Abierto/Cerrado (OCP)
* **Objetivo:** Permitir el dibujado de un nuevo `Triangulo` sin modificar la clase base `Forma` ni las subclases existentes `Circulo` y `Rectangulo`.
* **Solución:**
  * `Forma` define el método abstracto `public abstract void dibujar()`.
  * `Triangulo` hereda de `Forma` y aporta su propia implementación.
  * El cliente maneja `Forma[]` de manera agnóstica a tipos específicos, logrando extensión sin modificación.

### Ejercicio 3: Principio de Sustitución de Liskov (LSP)
* **Objetivo:** Jerarquía `Vehiculo` con subclases `Coche` (acelera por motor) y `Bicicleta` (acelera pedaleando).
* **Solución:**
  * `Vehiculo` declara el contrato polimórfico `acelerar(int incremento)` y `getVelocidad()`.
  * Tanto `Coche` como `Bicicleta` incrementan la velocidad de forma acumulativa y no negativa sin violar invariantes ni lanzar excepciones inesperadas.
  * El método de prueba `probarVehiculo(Vehiculo v)` garantiza interoperabilidad sin condicionales de tipo `instanceof`.

### Ejercicio 4: Principio de Segregación de Interfaces (ISP)
* **Objetivo:** Corregir una fat interface `Imprimible` que forzaba a una `Impresora` básica a tener un método `escanear()` con excepción.
* **Solución:**
  * Se divide la interfaz en dos contratos independientes: `Imprimible` y `Escaneable`.
  * `Impresora` implementa solo `Imprimible`.
  * `ImpresoraMultifuncional` implementa `Imprimible` y `Escaneable`.
  * La seguridad de tipos del compilador previene errores en tiempo de ejecución al invocar escaneos solo sobre instancias de `Escaneable`.

---

## 🚀 Guía de Compilación y Ejecución

### Prerrequisitos
* **Java Development Kit (JDK):** Versión 17 o superior instalada (`javac -version` y `java -version`).
* **Make (Opcional pero recomendado):** Disponible en la mayoría de distribuciones Linux y macOS (`make -version`).

---

### Método 1: Ejecución Rápida con Makefile (Recomendado)

Desde la raíz del repositorio (`LP3_Guia03_SOLID/`):

```bash
# 1. Ver el menú de comandos disponibles
make help

# 2. Compilar todos los proyectos (Hotel y los 4 ejercicios)
make all

# 3. Ejecutar la Actividad Principal del Hotel
make run-hotel

# 4. Ejecutar los Ejercicios individuales
make run-ej1      # Ejercicio 1 (SRP)
make run-ej2      # Ejercicio 2 (OCP)
make run-ej3      # Ejercicio 3 (LSP)
make run-ej4      # Ejercicio 4 (ISP)

# 5. Limpiar todos los archivos binarios compilados (.class)
make clean
```

---

### Método 2: Compilación y Ejecución Manual con `javac` y `java`

Si no dispones de `make`, puedes compilar y ejecutar cada proyecto de forma manual:

#### 1. Sistema de Hotel (`Hotel_Code`)
```bash
cd "Hotel_Code"
mkdir -p bin
javac -d bin $(find src -name "*.java")
java -cp bin principal.Main
cd ..
```

#### 2. Ejercicio 1 (SRP)
```bash
cd "Ejercicio 1"
mkdir -p bin
javac -d bin src/ejercicio1/*.java
java -cp bin ejercicio1.Main
cd ..
```

#### 3. Ejercicio 2 (OCP)
```bash
cd "Ejercicio 2"
mkdir -p bin
javac -d bin $(find src -name "*.java")
java -cp bin Main
cd ..
```

#### 4. Ejercicio 3 (LSP)
```bash
cd "Ejercicio 3"
mkdir -p bin
javac -d bin src/ejercicio3/*.java
java -cp bin ejercicio3.Main
cd ..
```

#### 5. Ejercicio 4 (ISP)
```bash
cd "Ejercicio 4"
mkdir -p bin
javac -d bin src/ejercicio4/*.java
java -cp bin ejercicio4.Main
cd ..
```

---

## 🐙 Guía para Subir este Proyecto a GitHub

Sigue estos sencillos pasos para crear un repositorio en tu cuenta de GitHub y subir la carpeta completa:

### 1. Iniciar en la carpeta del proyecto
Abre una terminal y sitúate dentro de la carpeta:
```bash
cd "/run/media/zyro/USB CS/UCSM/SEMESTRE 4/LP3 - Marisol - Karim/Practica/Ejercicio 1/LP3_Guia03_SOLID"
```

### 2. Inicializar el repositorio Git local
```bash
git init
```

### 3. Asegurar la limpieza y agregar los archivos
El archivo `.gitignore` ya incluido filtrará automáticamente cualquier archivo binario (`.class`, `bin/`, `out/`) o configuración de IDE:
```bash
git add .
```

### 4. Crear el commit inicial
```bash
git commit -m "feat: solución completa de Guía 03 LP3 (Principios SOLID - Hotel y Ejercicios 1-4)"
```

### 5. Conectar con tu repositorio en GitHub
1. Entra a [github.com/new](https://github.com/new) y crea un nuevo repositorio (por ejemplo: `LP3_Guia03_SOLID`).
2. Copia la URL de tu repositorio y ejecuta:
```bash
git branch -M main
git remote add origin https://github.com/TU_USUARIO/LP3_Guia03_SOLID.git
git push -u origin main
```

¡Listo! Tu repositorio quedará publicado con una estructura limpia, documentación integral y listo para evaluación académica.

---

## 👥 Créditos y Autores
* **Institución:** Universidad Católica de Santa María (UCSM)
* **Carrera:** Ingeniería de Sistemas
* **Curso:** Lenguajes de Programación III
* **Docentes:** Ing. Marisol Galarza / Ing. Karim Guevara
* **Semestre:** IV Semestre
