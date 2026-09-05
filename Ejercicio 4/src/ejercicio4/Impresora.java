package ejercicio4;

/**
 * Impresora básica que únicamente imprime.
 * Al aplicar ISP, esta clase ya no se ve obligada a implementar
 * un método escanear() que lanzaría una excepción UnsupportedOperationException.
 */
public class Impresora implements Imprimible {
    @Override
    public void imprimir(String documento) {
        System.out.println("[Impresora Estándar] Imprimiendo documento: " + documento);
    }
}
