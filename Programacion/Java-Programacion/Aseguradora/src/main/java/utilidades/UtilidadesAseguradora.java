package utilidades;

import modelos.Aseguradora;
import modelos.Poliza;

import java.util.ArrayList;
import java.util.List;

public class UtilidadesAseguradora {

    //Métodos

    Poliza recuperarPoliza(Aseguradora a, String numeroPoliza) {
        for (Poliza p : a.getListaPolizas()) {
            if (p.getNumero().equals(numeroPoliza)) {
                return p;
            }
        }
        return null;
    }

    List<Poliza> recuperarPolizasActivas(Aseguradora aseguradora){
        List<Poliza> polizasActivas = new ArrayList<>();
        for (Poliza p : aseguradora.getListaPolizas()) {
            if (p.getEstadoPoliza().equals(Poliza.EstadoPoliza.VIGENTE)) {
                polizasActivas.add(p);
            }
        }
        return polizasActivas;
    }

    List<Poliza> recuperarPolizasPorTomador (Aseguradora aseguradora,String nif) {
        List<Poliza> polizasTomador = new ArrayList<>();
        for (Poliza p : aseguradora.getListaPolizas()) {
            if (p.getTomador().getNif().equals(nif)) {
                polizasTomador.add(p);
            }
        }
        return polizasTomador;
    }

    List<Poliza> recuperarPolizasPorConductor (Aseguradora aseguradora, String nif) {
        List<Poliza> polizasConductor = new ArrayList<>();
        for (Poliza p : aseguradora.getListaPolizas()) {
            if (p.getConductorPrincipal().getNif().equals(nif)) {
                polizasConductor.add(p);
            }
        }
        return polizasConductor;
    }
}
