package utilidades;

import modelos.Persona;
import modelos.Vehiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UtilidadesVehiculo {

    public static boolean esMatriculaValida(String mat) {


        if (mat == null || mat.length() < 5 || mat.length()>9) return false;

        if (matricula.matches(regexNormal)) {
            System.out.println("Matrícula normal válida.");
        } else if (matricula.matches(regexFuerzas)) {
            System.out.println("Matrícula de las fuerzas del estado válida.");
        } else {
            System.out.println("Formato de matrícula no válido.");
        }

        String numeros = mat.substring(0, 4);
        String letras = mat.substring(4, 7);

        try {
            int num = Integer.parseInt(numeros);
            return letras.matches("[B-DF-HJ-NP-TV-Z]{3}") && num >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean esMatriculaValida(Vehiculo veh) {

    }

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
