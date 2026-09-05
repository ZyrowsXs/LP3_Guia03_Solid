# 🚗 Ejercicio 3: Principio de Sustitución de Liskov (LSP)

> **Enunciado:**  
> *"Tienes una clase `Vehiculo` con un método `acelerar()`. Hay subclases `Coche` y `Bicicleta` que implementan este método. La clase `Bicicleta` sobrescribe `acelerar()` para indicar que se acelera pedaleando, mientras que `Coche` indica que se acelera usando el motor. Analizar si el código cumple con LSP. Si no es así, refactorizar para asegurarte de que las subclases se comporten de manera consistente con la clase base."*

---

## 🔍 Análisis de LSP

El **Liskov Substitution Principle (LSP)** formulado por Barbara Liskov establece:
> *"Si $S$ es un subtipo de $T$, entonces los objetos de tipo $T$ en un programa deben poder reemplazarse por objetos de tipo $S$ sin alterar ninguna de las propiedades deseables de ese programa (corrección, tarea desempeñada, etc.)."*

### ¿Cuándo se violaría LSP?
Si la clase base asumiera detalles específicos de un motor (por ejemplo `encenderMotor()` o lanzar una excepción `UnsupportedOperationException` en `Bicicleta` porque carece de motor), se violaría LSP porque el cliente no podría sustituir un `Coche` por una `Bicicleta` de manera transparente.

---

## 🛠️ Solución Implementada

1. Se modela la abstracción `Vehiculo` con el contrato general `acelerar(int incremento)` y `getVelocidad()`.
2. Tanto `Coche` como `Bicicleta` cumplen de forma estricta las precondiciones y postcondiciones del contrato:
   - Ambas aumentan la velocidad actual de forma acumulativa y no negativa.
   - Ninguna altera las expectativas del cliente ni lanza excepciones imprevistas.
3. El cliente `probarVehiculo(Vehiculo vehiculo)` consume la abstracción sin importar qué implementación concreta reciba:

```java
public static void probarVehiculo(Vehiculo vehiculo) {
    vehiculo.acelerar(10);
    vehiculo.acelerar(15);
    System.out.println("Velocidad: " + vehiculo.getVelocidad());
}
```

---

## 🚀 Compilación y Ejecución

```bash
# Con Makefile
make run

# Manualmente
javac -d bin src/ejercicio3/*.java
java -cp bin ejercicio3.Main
```
