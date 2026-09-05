package ejercicio4;

public class Main {

    /**
     * Consume únicamente el contrato Imprimible.
     */
    public static void procesarImpresion(Imprimible dispositivo, String doc) {
        dispositivo.imprimir(doc);
    }

    /**
     * Consume únicamente el contrato Escaneable.
     */
    public static void procesarEscaneo(Escaneable dispositivo, String doc) {
        dispositivo.escanear(doc);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 4: INTERFACE SEGREGATION PRINCIPLE (ISP)");
        System.out.println("==================================================");

        Impresora impresoraSimple = new Impresora();
        ImpresoraMultifuncional multifuncional = new ImpresoraMultifuncional();

        String documento = "Guia03_LP3_SOLID_Informe.pdf";

        System.out.println("\n--- Operaciones de Impresión (Contrato Imprimible) ---");
        procesarImpresion(impresoraSimple, documento);
        procesarImpresion(multifuncional, documento);

        System.out.println("\n--- Operaciones de Escaneo (Contrato Escaneable) ---");
        // impresoraSimple no es aceptada aquí por el compilador, evitando errores en tiempo de ejecución.
        procesarEscaneo(multifuncional, documento);

        System.out.println("\nDemostración de ISP finalizada con éxito.");
        System.out.println("==================================================");
    }
}
