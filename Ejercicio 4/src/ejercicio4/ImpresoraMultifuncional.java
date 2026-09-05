package ejercicio4;

/**
 * Dispositivo multifuncional que implementa ambas interfaces segregadas.
 */
public class ImpresoraMultifuncional implements Imprimible, Escaneable {
    @Override
    public void imprimir(String documento) {
        System.out.println("[Multifuncional] Imprimiendo documento en alta resolución: " + documento);
    }

    @Override
    public void escanear(String documento) {
        System.out.println("[Multifuncional] Escaneando y digitalizando documento: " + documento);
    }
}
