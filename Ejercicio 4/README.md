# 🖨️ Ejercicio 4: Principio de Segregación de Interfaces (ISP)

> **Enunciado:**  
> *"Tienes una interfaz `Imprimible` con métodos `imprimir()` y `escanear()`. Hay clases `Impresora` e `ImpresoraMultifuncional` que implementan esta interfaz. La clase `Impresora` no tiene la capacidad de escanear, por lo que su método `escanear()` lanza una excepción. Refactorizar el código para cumplir con ISP, creando interfaces más específicas para evitar que las clases implementen métodos que no necesitan. Desarrolle una aplicación."*

---

## 🔍 Análisis del Problema y Violación de ISP

En el diseño original existía una **"Fat Interface"** (interfaz obesa o sobrecargada):
```java
// Violación de ISP:
public interface Imprimible {
    void imprimir(String doc);
    void escanear(String doc);
}
```
Al obligar a la clase `Impresora` básica a implementar `Imprimible`, esta debía implementar forzosamente `escanear()`, recurriendo a `throw new UnsupportedOperationException("No soporta escaneo");`. Esto vulnera tanto el **ISP** como el **LSP**.

---

## 🛠️ Solución Refactorizada

Se segrega la interfaz monolítica en interfaces cohesivas y de responsabilidad acotada:
1. **`Imprimible`**: Define únicamente `void imprimir(String documento)`.
2. **`Escaneable`**: Define únicamente `void escanear(String documento)`.

### Implementación en Clases:
- **`Impresora`**: Implementa únicamente `Imprimible`.
- **`ImpresoraMultifuncional`**: Implementa `Imprimible` y `Escaneable`.

### Beneficio:
Los métodos cliente como `procesarEscaneo(Escaneable d, String doc)` solo aceptan dispositivos que verdaderamente soportan escaneo, garantizando seguridad en tiempo de compilación y eliminando excepciones en tiempo de ejecución.

---

## 🚀 Compilación y Ejecución

```bash
# Con Makefile
make run

# Manualmente
javac -d bin src/ejercicio4/*.java
java -cp bin ejercicio4.Main
```
