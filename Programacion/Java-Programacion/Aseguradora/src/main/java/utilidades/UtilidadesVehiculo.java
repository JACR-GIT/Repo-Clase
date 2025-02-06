package utilidades;

import modelos.Persona;
import modelos.Vehiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Matrícula normal (coches y motocicletas): 0000BBB (4 números, del 0 al 9, seguidas
//de letras). Las letras de este tipo de matrícula no pueden ser A, E, I, O, U, Ñ o Q.
public class UtilidadesVehiculo {

    public static boolean esMatriculaValida(String mat) {
        if (mat == null || mat.length() != 7) return false;

        String numeros = mat.substring(0, 4);
        String letras = mat.substring(4, 7);

        try {
            int num = Integer.parseInt(numeros);
            return letras.matches("[B-DF-HJ-NP-TV-Z]{3}") && num >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    Vehiculos especiales

    public static int calculaEdad(Vehiculo v){
        return v.getFechaMatriculacion().until(LocalDate.now()).getYears();
    }

    public static List<Vehiculo> getVehiculos(List<Vehiculo> listaVehiculos, Persona p) {
        List<Vehiculo> vehiculosFiltrados = new ArrayList<>(); // Nueva lista para almacenar resultados

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

}
