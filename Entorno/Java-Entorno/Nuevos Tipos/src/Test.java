package geometria;
import Punto3D,Punto3DImpl,Segmento,SegmentoImpl;
public class TestGeometria {
    public static void main(String[] args) {
        // Pruebas para Punto3D
        Punto3D punto1 = new Punto3DImpl(1.0, 2.0, 3.0);
        Punto3D punto2 = new Punto3DImpl(4.0, 5.0, 6.0);

        System.out.println("Punto1: " + punto1);
        System.out.println("Punto2: " + punto2);
        System.out.println("Distancia entre Punto1 y Punto2: " + punto1.distanciaA(punto2));

        // Pruebas para Segmento
        Segmento segmento = new SegmentoImpl(punto1, punto2);
        System.out.println("Segmento: " + segmento);
        System.out.println("Longitud del segmento: " + segmento.longitud());

        // Pruebas de restricciones
        try {
            Punto3D puntoInvalido = new Punto3DImpl(Double.NaN, 2.0, 3.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        try {
            Segmento segmentoInvalido = new SegmentoImpl(null, punto2);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}