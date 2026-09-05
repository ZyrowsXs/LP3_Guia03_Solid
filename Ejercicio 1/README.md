# 💼 Ejercicio 1: Principio de Responsabilidad Única (SRP)

> **Enunciado:**  
> *"Tienes una clase `Empleado` que se encarga de almacenar la información del empleado (nombre, salario, departamento) y también de calcular el pago mensual del empleado. Refactorizar el código para cumplir con SRP, separando la lógica de cálculo del pago en una clase separada."*

---

## 🔍 Análisis del Problema y Violación de SRP

En el diseño inicial, la clase `Empleado` acumulaba dos razones distintas para cambiar:
1. **Cambios en los datos o modelo de negocio del empleado:** Agregar nuevos atributos (DNI, email, tipo de contrato, etc.).
2. **Cambios en las políticas financieras y cálculo salarial:** Cambios en fórmulas de deducción, impuestos, bonificaciones o cálculo proporcional.

Esto violaba el **Single Responsibility Principle (SRP)**: *"Una clase debe tener una sola razón para cambiar"*.

---

## 🛠️ Solución Refactorizada

Se aplicó la separación de responsabilidades:
1. **`Empleado`**: Se encarga única y exclusivamente de encapsular el estado e información personal/laboral del trabajador.
2. **`CalculadoraSalarial`**: Clase de servicio que encapsula la lógica de cálculo del pago mensual neto recibiendo la instancia de `Empleado` y las deducciones aplicables.

```
       +-----------------------+              +-----------------------+
       |       Empleado        |              |  CalculadoraSalarial  |
       +-----------------------+              +-----------------------+
       | - nombre: String      |              | + calcularPagoMensual(|
       | - salarioAnual: double| <----------  |     emp: Empleado,    |
       | - dep: String         | (Usa datos)  |     ded: double): dbl |
       +-----------------------+              +-----------------------+
```

---

## 🚀 Compilación y Ejecución

```bash
# Con Makefile
make run

# Manualmente
javac -d bin src/ejercicio1/*.java
java -cp bin ejercicio1.Main
```
