package Paquete;

public class BusquedaHeuristica {
    public static void main(String[] args) {
        Estado estadoInicial = new Estado(0); // Posición inicial del punto de montaje (B)
        Estado mejorEstado = buscarPosicionMontajeHeuristica(estadoInicial);
        System.out.println("Posición de montaje encontrada: " + mejorEstado);
    }

    public static Estado buscarPosicionMontajeHeuristica(Estado estadoInicial) {
        double margenTolerancia = 0.1; // Margen de tolerancia para la posición de montaje
        double objetivo = 0.5; // Posición objetivo del punto de montaje (A)
        double mejorDistancia = Double.MAX_VALUE;
        Estado mejorEstado = estadoInicial;

        // Búsqueda heurística basada en la distancia al objetivo
        for (double posicion = estadoInicial.getX() - margenTolerancia; posicion <= estadoInicial.getX() + margenTolerancia; posicion += 0.01) {
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
