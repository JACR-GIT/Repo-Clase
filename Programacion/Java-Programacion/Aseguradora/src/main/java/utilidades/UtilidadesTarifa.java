package utilidades;

import com.aseguradora.utils.SoporteVehiculos;
import modelos.*;

public class UtilidadesTarifa {

    public double calcularTarifa  {

        double tarifaBase = SoporteVehiculos.getInstance().calcularTarifa(cotizacion.getVehiculo().getMarca().getNombre(),cotizacion.getVehiculo().getModelo().getNombre(),UtilidadesVehiculo.calculaEdad(cotizacion.getVehiculo()));
        double multiplicador = 1.0;

        String cp = cotizacion.getConductorPrincipal().getDireccion().getCodigoPostal();
        double multiplicadorCP = SoporteVehiculos.getInstance().multiplicadorCP(cp);
        multiplicador *= SoporteVehiculos.getInstance().multiplicadorCP(cp);

        if (!cotizacion.isTieneAparcamientoPrivado()) {
            multiplicador *= 1.1;
        }

        if (UtilidadesPersonas.getEdad(cotizacion.getConductorPrincipal()) < 25) {
            multiplicador *= 1.2;
        } else {
            for (Conductor conductor : cotizacion.getConductoresOcasionales()) {
                if (UtilidadesPersonas.getEdad(conductor) < 25) {
                    multiplicador *= 1.1;
                    break;
                }
            }
        }

        int numSiniestros = cotizacion.getNumSini5();
        multiplicador *= (1 + numSiniestros * 0.05); // Increase by 5% per accident in the last 5 years

        return tarifaBase * multiplicador;
    }
}