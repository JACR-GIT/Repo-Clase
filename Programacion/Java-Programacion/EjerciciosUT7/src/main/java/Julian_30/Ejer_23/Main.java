package Julian_30.Ejer_23;

import java.util.function.BiFunction;
public class Main {
    public static void main(String[] args) {
        BiFunction<String, Integer, Estudiante> crearEstudiante = Estudiante::new;
        Estudiante est = crearEstudiante.apply("Ana", 20);
        System.out.println(est);
    }
}
