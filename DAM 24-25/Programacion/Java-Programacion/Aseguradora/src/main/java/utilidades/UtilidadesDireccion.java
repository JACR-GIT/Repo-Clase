package utilidades;

import java.util.HashMap;
import java.util.Map;

public class UtilidadesDireccion {

    // ==================== MAPA ESTÁTICO DE PROVINCIAS ====================

    private static final Map<String, String> PROVINCIAS = new HashMap<>();

    // Bloque estático para inicializar el mapa de provincias.
    static {
        PROVINCIAS.put("Álava", "01");
        PROVINCIAS.put("Albacete", "02");
        PROVINCIAS.put("Alicante", "03");
        PROVINCIAS.put("Almería", "04");
        PROVINCIAS.put("Ávila", "05");
        PROVINCIAS.put("Badajoz", "06");
        PROVINCIAS.put("Islas Baleares", "07");
        PROVINCIAS.put("Barcelona", "08");
        PROVINCIAS.put("Burgos", "09");
        PROVINCIAS.put("Cáceres", "10");
        PROVINCIAS.put("Cádiz", "11");
        PROVINCIAS.put("Castellón", "12");
        PROVINCIAS.put("Ciudad Real", "13");
        PROVINCIAS.put("Córdoba", "14");
        PROVINCIAS.put("A Coruña", "15");
        PROVINCIAS.put("Cuenca", "16");
        PROVINCIAS.put("Girona", "17");
        PROVINCIAS.put("Granada", "18");
        PROVINCIAS.put("Guadalajara", "19");
        PROVINCIAS.put("Guipúzcoa", "20");
        PROVINCIAS.put("Huelva", "21");
        PROVINCIAS.put("Huesca", "22");
        PROVINCIAS.put("Jaén", "23");
        PROVINCIAS.put("León", "24");
        PROVINCIAS.put("Lleida", "25");
        PROVINCIAS.put("La Rioja", "26");
        PROVINCIAS.put("Lugo", "27");
        PROVINCIAS.put("Madrid", "28");
        PROVINCIAS.put("Málaga", "29");
        PROVINCIAS.put("Murcia", "30");
        PROVINCIAS.put("Navarra", "31");
        PROVINCIAS.put("Ourense", "32");
        PROVINCIAS.put("Asturias", "33");
        PROVINCIAS.put("Palencia", "34");
        PROVINCIAS.put("Las Palmas", "35");
        PROVINCIAS.put("Pontevedra", "36");
        PROVINCIAS.put("Salamanca", "37");
        PROVINCIAS.put("Santa Cruz de Tenerife", "38");
        PROVINCIAS.put("Cantabria", "39");
        PROVINCIAS.put("Segovia", "40");
        PROVINCIAS.put("Sevilla", "41");
        PROVINCIAS.put("Soria", "42");
        PROVINCIAS.put("Tarragona", "43");
        PROVINCIAS.put("Teruel", "44");
        PROVINCIAS.put("Toledo", "45");
        PROVINCIAS.put("Valencia", "46");
        PROVINCIAS.put("Valladolid", "47");
        PROVINCIAS.put("Vizcaya", "48");
        PROVINCIAS.put("Zamora", "49");
        PROVINCIAS.put("Zaragoza", "50");
        PROVINCIAS.put("Ceuta", "51");
        PROVINCIAS.put("Melilla", "52");
    }

    // ==================== MÉTODOS ====================

    public static boolean esCPValido(String cp) {
        if (cp == null || cp.length() != 5 || !cp.matches("\\d{5}")) {
            return false; // Validación básica: el código postal debe tener 5 dígitos.
        }

        int codigoProvincia = Integer.parseInt(cp.substring(0, 2)); // Extrae los dos primeros dígitos.
        return codigoProvincia >= 1 && codigoProvincia <= 52; // Verifica que el código de provincia esté entre 01 y 52.
    }

    public static String obtenerCodigoProvincia(String nombreProvincia) {
        return PROVINCIAS.get(nombreProvincia);
    }

    public static String obtenerNombreProvincia(String codigoProvincia) {
        for (Map.Entry<String, String> entry : PROVINCIAS.entrySet()) {
            if (entry.getValue().equals(codigoProvincia)) {
                return entry.getKey();
            }
        }
        return null; // Si no se encuentra la provincia, se devuelve null.
    }
}