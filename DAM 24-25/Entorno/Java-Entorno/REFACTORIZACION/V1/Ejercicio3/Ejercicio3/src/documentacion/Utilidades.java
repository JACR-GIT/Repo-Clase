package documentacion;

import java.util.ArrayList;
import java.util.List;

//Refactorizamos con rename tanto la clase Utilidades que estaba en minuscula, extraemos los metodos mostrarNumHabitantes,
// listaClientes y formatoImpresion. En el metodo datosEmpresa llamamos a los metodos extraidos.
//Creamos una variable ciudad en el metodo datosEmpresa para poder compararla con el nombre de la poblacion y mostrar el numero de habitantes.
//Ademas hemos creado el metodo crearConstructores para quitarlo del metodo main

public class Utilidades {
    public static void main(String[] args) {
        Poblacion p1 = crearConstructores();
        datosEmpresa("Manuel", p1, "Sevilla");
        datosEmpresa("Rocío", p1, "Kiev");
    }

    private static Poblacion crearConstructores() {
        Festividad feriaDeAbril = new FestividadImpl("Abril", "Fería de Abril");
        Poblacion sevilla = new PoblacionImpl("Sevilla", 1945000, 140.8, 1000000, 152014, feriaDeAbril);
        return sevilla;
    }


    public static void datosEmpresa(String cliente, Poblacion poblacion, String ciudad) {
        formatoImpresion();
        listaClientes(cliente);
        mostarNumHabitantes(poblacion, ciudad);


    }

    private static void mostarNumHabitantes(Poblacion pob, String ciudad) {
        if(pob.getNombre().equals(ciudad)) {
          System.out.println(pob.getNumHabitantes());
        }
    }

    private static void listaClientes(String cliente) {
        List<String> lc = new ArrayList<>();
        lc.add(cliente);
        System.out.println("Cliente: ");
        System.out.println(lc);
    }

    private static void formatoImpresion() {
        System.out.println("Datos del cliente");
        System.out.println("==================");
        System.out.println();
    }
}
