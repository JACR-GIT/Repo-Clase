import modelos.Aseguradora;
import modelos.Poliza;
import utilidades.UtilidadesAseguradora;

import java.util.List;

public class PruebaV5 {
    public static void main(String[] args) {
        Aseguradora aseguradora = new Aseguradora();
        UtilidadesAseguradora utilidades = new UtilidadesAseguradora();

        // Simulación de recuperación de pólizas
        Poliza poliza = utilidades.recuperarPoliza(aseguradora, "12345");
        if (poliza != null) {
            System.out.println("Poliza recuperada: " + poliza);
        } else {
            System.out.println("No se encontró la póliza con número 12345");
        }

        List<Poliza> polizasActivas = utilidades.recuperarPolizasActivas(aseguradora);
        System.out.println("Polizas activas: " + polizasActivas);

        List<Poliza> polizasTomador = utilidades.recuperarPolizasPorTomador(aseguradora, "NIF123");
        System.out.println("Polizas por tomador: " + polizasTomador);

        List<Poliza> polizasConductor = utilidades.recuperarPolizasPorConductor(aseguradora, "NIF456");
        System.out.println("Polizas por conductor: " + polizasConductor);
    }
}