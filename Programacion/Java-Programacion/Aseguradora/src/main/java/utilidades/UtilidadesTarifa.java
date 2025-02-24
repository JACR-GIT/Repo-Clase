package utilidades;

import com.aseguradora.utils.SoporteVehiculos;
import com.aseguradora.utils.Tarifa;
import modelos.Cotizacion;
import modelos.Conductor;

public class UtilidadesTarifa {

    // Método para calcular la tarifa final de una cotización según la modalidad
    public static double calcularTarifa(Cotizacion cotizacion) {
        // Obtener la tarifa base desde SoporteVehiculos
        Tarifa tarifaBase = SoporteVehiculos.getInstance().calcularTarifa(
                cotizacion.getVehiculo().getMarca().getNombre(),
                cotizacion.getVehiculo().getModelo().getNombre(),
                cotizacion.getVehiculo().getFechaMatriculacion().getYear()
        );

        // Seleccionar el precio base según la modalidad elegida
        double precioBase;
        switch (cotizacion.getModalidadElegida()) {
            case TERC:
                precioBase = tarifaBase.getPrecioTERC();
                break;
            case TAMP:
                precioBase = tarifaBase.getPrecioTAMP();
                break;
            case TRIE:
                precioBase = tarifaBase.getPrecioTRIE();
                break;
            default:
                precioBase = tarifaBase.getPrecioTERC(); // Por defecto terceros
        }

        // Iniciar el multiplicador
        double multiplicador = 1.0;

        // Aplicar multiplicador por código postal
        String cp = cotizacion.getConductorPrincipal().getDireccion().getCodigoPostal();
        double multiplicadorCP = SoporteVehiculos.getInstance().multiplicadorCP(cp);
        multiplicador *= multiplicadorCP;

        // Ajustar por aparcamiento privado
        if (!cotizacion.isTieneAparcamientoPrivado()) {
            multiplicador *= 1.1; // 10% más si no tiene parking
        }

        // Ajustar por edad del conductor principal
        if (UtilidadesPersonas.getEdad(cotizacion.getConductorPrincipal()) < 25) {
            multiplicador *= 1.2; // 20% más si es menor de 25
        } else {
            // Revisar conductores ocasionales
            for (Conductor conductor : cotizacion.getConductoresOcasionales()) {
                if (UtilidadesPersonas.getEdad(conductor) < 25) {
                    multiplicador *= 1.1; // 10% más si hay un conductor ocasional menor de 25
                    break; // Solo aplica una vez
                }
            }
        }

        // Ajustar por número de siniestros
        int numSiniestros = cotizacion.getNumSini5();
        multiplicador *= (1 + numSiniestros * 0.05); // 5% más por cada siniestro

        // Calcular y devolver el precio final
        return precioBase * multiplicador;
    }

    // Método para calcular todas las tarifas y asignarlas a la cotización
    public static void calcularTodasLasTarifas(Cotizacion cotizacion) {
        // Obtener la tarifa base
        Tarifa tarifaBase = SoporteVehiculos.getInstance().calcularTarifa(
                cotizacion.getVehiculo().getMarca().getNombre(),
                cotizacion.getVehiculo().getModelo().getNombre(),
                cotizacion.getVehiculo().getFechaMatriculacion().getYear()
        );

        // Iniciar el multiplicador
        double multiplicador = 1.0;

        // Aplicar multiplicador por código postal
        String cp = cotizacion.getConductorPrincipal().getDireccion().getCodigoPostal();
        multiplicador *= SoporteVehiculos.getInstance().multiplicadorCP(cp);

        // Ajustar por aparcamiento privado
        if (!cotizacion.isTieneAparcamientoPrivado()) {
            multiplicador *= 1.1;
        }

        // Ajustar por edad
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

        // Ajustar por siniestros
        int numSiniestros = cotizacion.getNumSini5();
        multiplicador *= (1 + numSiniestros * 0.05);

        // Asignar los precios calculados a la cotización
        cotizacion.setPrecioTERC(tarifaBase.getPrecioTERC() * multiplicador);
        cotizacion.setPrecioTAMP(tarifaBase.getPrecioTAMP() * multiplicador);
        cotizacion.setPrecioTRIE(tarifaBase.getPrecioTRIE() * multiplicador);
    }
}