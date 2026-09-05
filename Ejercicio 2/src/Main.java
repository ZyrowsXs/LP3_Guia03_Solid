import FormasGeometricas.*;
public class Main {
    public static void main(String[] args) {
        // Instanciacion de objetos
        Forma Circulo = new Circulo();
        Forma Rectangulo = new Rectangulo();
        Forma Triangulo = new Triangulo();

        // Arreglo polimorfico
        Forma[] arregloFormas = {Circulo, Rectangulo, Triangulo};

        // Recorrido e invocacion polimorfica
        for(Forma f : arregloFormas){
            f.dibujar();
        }
    }
}
