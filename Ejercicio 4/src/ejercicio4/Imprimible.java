package ejercicio4;

/**
 * Interfaz segregada para capacidades de impresión.
 * Cumple con ISP: Dispositivos que solo imprimen no son forzados
 * a conocer ni implementar funciones de escaneo.
 */
public interface Imprimible {
    void imprimir(String documento);
}
