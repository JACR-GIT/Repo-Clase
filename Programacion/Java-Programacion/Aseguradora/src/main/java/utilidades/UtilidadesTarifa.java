package utilidades;

import modelos.Cotizacion;
import modelos.Conductor;
import soporte.SoporteVehiculos;

public class UtilidadesTarifa extends SoporteVehiculos {

    @Override
    public double calcularTarifa(Cotizacion cotizacion) {
        double tarifaBase = super.calcularTarifa(cotizacion);
        double multiplicador = 1.0;

        String cp = cotizacion.getConductorPrincipal().getDireccion().getCodigoPostal();
        multiplicador *= multiplicadorCP(cp);

        if (!cotizacion.isTieneAparcamientoPrivado()) {
            multiplicador *= 1.1; // Increase by 10% if the car sleeps on the street
        }

        if (cotizacion.getConductorPrincipal().getEdad() < 25) {
            multiplicador *= 1.2; // Increase by 20% if the principal driver is under 25
        } else {
            for (Conductor conductor : cotizacion.getConductoresOcasionales()) {
                if (conductor.getEdad() < 25) {
                    multiplicador *= 1.1; // Increase by 10% if any occasional driver is under 25
                    break;
                }
            }
        }

        int numSiniestros = cotizacion.getNumSini5();
        multiplicador *= (1 + numSiniestros * 0.05); // Increase by 5% per accident in the last 5 years

        return tarifaBase * multiplicador;
    }
}