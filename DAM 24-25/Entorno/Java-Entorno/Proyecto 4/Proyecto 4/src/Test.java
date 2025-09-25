import com.Punto3D.Punto3D;
import com.Segmento.Segmento;

public class Test {
    public static void main(String[] args) {
        Punto3D punto1 = new Punto3D(1.0,2.0,3.0);
        Punto3D punto2 = new Punto3D(4.0,5.0,6.0);
        Segmento segmento = new Segmento(punto1,punto2);
        Double longitud = segmento.getLongitudSegmento(punto1,punto2);
        System.out.println(segmento);
        System.out.println(longitud);

        Punto3D p1 = new Punto3D(1.0,2.0,3.0);
        Punto3D p2 = new Punto3D(4.0,5.0,6.0);
        System.out.println(p1);
        System.out.println(p2);
        Double distancia = p2.getDistancia(p2,p1);
        System.out.println(distancia);
    }

}
