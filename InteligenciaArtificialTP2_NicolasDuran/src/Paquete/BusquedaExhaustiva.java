package Paquete;

public class BusquedaExhaustiva {
    public static void main(String[] args) {
        Estado estadoInicial = new Estado(0); // Posición inicial del punto de montaje (B)
        Estado mejorEstado = buscarPosicionMontajeExhaustiva(estadoInicial);
        System.out.println("Posición de montaje encontrada: " + mejorEstado);
    }

    public static Estado buscarPosicionMontajeExhaustiva(Estado estadoInicial) {
        double incremento = 0.01; // Tamaño del incremento en la búsqueda
        double margenTolerancia = 0.1; // Margen de tolerancia para la posición de montaje
        double objetivo = 0.5; // Posición objetivo del punto de montaje (A)
        double mejorDistancia = Double.MAX_VALUE;
        Estado mejorEstado = estadoInicial;

        // Búsqueda exhaustiva en ambas direcciones (izquierda y derecha) sobre la horizontal "H"
        for (double posicion = estadoInicial.getX() - margenTolerancia; posicion <= estadoInicial.getX() + margenTolerancia; posicion += incremento) {
            Estado nuevoEstado = new Estado(posicion);
            double distancia = Math.abs(objetivo - posicion); // Calcular la distancia al objetivo
            if (distancia < mejorDistancia) {
                mejorDistancia = distancia;
                mejorEstado = nuevoEstado;
            }
        }

        return mejorEstado;
    }
}

class Estado {
    private double x; // Posición en la horizontal "H"

    public Estado(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    @Override
    public String toString() {
        return "B. Posición(" + x + ")";
    }
}
