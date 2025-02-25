package utilidades;

import modelos.Aseguradora;
import modelos.Poliza;

import java.util.ArrayList;
import java.util.List;

public class UtilidadesAseguradora {

    public Poliza recuperarPoliza(Aseguradora a, String numeroPoliza) {
        if (a == null || numeroPoliza == null || a.getListaPolizas() == null) {
            return null; // Validación básica para evitar NullPointerException.
        }

        for (Poliza p : a.getListaPolizas()) {
            if (p != null && numeroPoliza.equals(p.getNumero())) {
                return p;
            }
        }
        return null; // Si no se encuentra la póliza, se devuelve null.
    }

    // ==================== MÉTODOS ====================

    public List<Poliza> recuperarPolizasActivas(Aseguradora aseguradora) {
        List<Poliza> polizasActivas = new ArrayList<>();

        if (aseguradora == null || aseguradora.getListaPolizas() == null) {
            return polizasActivas; // Validación básica para evitar NullPointerException.
        }

        for (Poliza p : aseguradora.getListaPolizas()) {
            if (p != null && Poliza.EstadoPoliza.VIGENTE.equals(p.getEstadoPoliza())) {
                polizasActivas.add(p);
            }
        }
        return polizasActivas;
    }

    public List<Poliza> recuperarPolizasPorTomador(Aseguradora aseguradora, String nif) {
        List<Poliza> polizasTomador = new ArrayList<>();

        if (aseguradora == null || nif == null || aseguradora.getListaPolizas() == null) {
            System.out.println("Error: aseguradora, nif o lista de pólizas nulos.");
        }else if(aseguradora.getListaPolizas().getLast().getTomador().getNif().equalsIgnoreCase(nif)) {

            for (Poliza p : aseguradora.getListaPolizas()) {
                if (p != null && p.getTomador() != null && nif.equals(p.getTomador().getNif())) {
                    polizasTomador.add(p);
                }
            }
        }
        return polizasTomador;
    }

    /**
     * Recupera todas las pólizas asociadas a un conductor específico basándose en su NIF.
     *
     * @param aseguradora Aseguradora en la que se buscarán las pólizas.
     * @param nif         NIF del conductor de las pólizas.
     * @return Lista de pólizas asociadas al conductor.
     */
    public List<Poliza> recuperarPolizasPorConductor(Aseguradora aseguradora, String nif) {
        List<Poliza> polizasConductor = new ArrayList<>();

        if (aseguradora == null || nif == null || aseguradora.getListaPolizas() == null) {
            return polizasConductor; // Validación básica para evitar NullPointerException.
        }

        for (Poliza p : aseguradora.getListaPolizas()) {
            if (p != null && p.getConductorPrincipal() != null && nif.equals(p.getConductorPrincipal().getNif())) {
                polizasConductor.add(p);
            }
        }
        return polizasConductor;
    }
}