package utilidades;

import com.aseguradora.utils.SoporteVehiculos;
import modelos.Persona;
import modelos.Vehiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UtilidadesVehiculo {

    public static boolean esMatriculaValida(String matricula) {

        String regexNormal = "^[0-9]{4}[B-DF-HJ-NP-TV-Z]{3}$";
        String regexFuerzas = "^[A-Z]{1,4}[0-9]{4,6}[A-Z]{0,2}$";
        boolean valido = false;

        if (matricula == null || matricula.length() < 5 || matricula.length() > 9) return false;

        if (matricula.matches(regexNormal)) {
            System.out.println("Matrícula normal válida.");
            valido = true;
        } else if (matricula.matches(regexFuerzas)) {
            System.out.println("Matrícula de las fuerzas del estado válida.");
            valido = true;
        } else {
            System.out.println("Formato de matrícula no válido.");
        }
        return valido;
    }

    public static boolean esMatriculaValida(Vehiculo veh) {
        return veh != null && esMatriculaValida(veh.getMatricula());
    }

    public static int calculaEdad(Vehiculo v){
        return v.getFechaMatriculacion().until(LocalDate.now()).getYears();
    }

    public static List<Vehiculo> getVehiculos(List<Vehiculo> listaVehiculos, Persona p) {
        List<Vehiculo> vehiculosFiltrados = new ArrayList<>();

        for (Vehiculo v : listaVehiculos) {
            if (v.getDuenyoActual().equals(p)) {
                vehiculosFiltrados.add(v);
            }
        }
        return vehiculosFiltrados;
    }

    public static boolean validaFechaMatriculacion(LocalDate fecha){
        return fecha.isBefore(LocalDate.now());
    }

    public static boolean validarMarca(String marca) {
        return SoporteVehiculos.getInstance().esMarcaValida(marca);
    }

    public static boolean validarModelo(String marca, String modelo) {
        return SoporteVehiculos.getInstance().esModeloValido(marca,modelo);
    }
}
