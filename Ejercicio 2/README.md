# 📐 Ejercicio 2: Principio Abierto/Cerrado (OCP)

> **Enunciado:**  
> *"Tienes una clase `Forma` con un método `dibujar()`. Hay subclases `Circulo` y `Rectangulo` que implementan este método. Se requiere añadir la capacidad de dibujar un `Triangulo` sin modificar la clase `Forma` ni las subclases existentes. Refactorizar el código para cumplir con OCP, permitiendo añadir nuevas formas geométricas sin modificar la clase `Forma` ni las subclases existentes."*

---

## 🔍 Análisis del Principio OCP

El **Open/Closed Principle (OCP)** establece:
> *"Las entidades de software deben estar abiertas para la extensión, pero cerradas para la modificación."*

Si el cálculo o dibujado de figuras se hiciera mediante estructuras `if-else` o `switch` basadas en `instanceof` dentro de un procesador central, agregar una nueva figura requeriría modificar el código existente, arriesgando introducir errores.

---

## 🛠️ Solución Implementada

1. Se define la clase base abstracta `Forma` con el método abstracto `dibujar()`.
2. Las figuras existentes `Circulo` y `Rectangulo` heredan de `Forma` e implementan su propia lógica de dibujo.
3. Para dar soporte a `Triangulo`, simplemente se crea la nueva clase `Triangulo extends Forma` implementando `dibujar()`, **sin alterar una sola línea de `Forma`, `Circulo` ni `Rectangulo`**.
4. El cliente (`Main`) interactúa con la abstracción `Forma` de manera polimórfica:

```java
Forma[] formas = { new Circulo(), new Rectangulo(), new Triangulo() };
for (Forma f : formas) {
    f.dibujar();
}
```

---

## 🚀 Compilación y Ejecución

```bash
# Con Makefile
make run

# Manualmente
javac -d bin $(find src -name "*.java")
java -cp bin Main
```
