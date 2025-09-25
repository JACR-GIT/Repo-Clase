import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*//Actividad 1
        List<Conductor> listaConductores = new ArrayList<Conductor>();
        listaConductores.add(new Conductor(1, "Juan", "Perez", "123456", LocalDate.of(2020, 1, 1)));
        listaConductores.add(new Conductor(2, "Maria", "Gomez", "654321", LocalDate.of(2020, 1, 1)));
        listaConductores.add(new Conductor(3, "Pedro", "Rodriguez", "456123", LocalDate.of(2020, 1, 1)));
        listaConductores.add(new Conductor(4, "Ana", "Martinez", "321654", LocalDate.of(2020, 1, 1)));
        listaConductores.add(new Conductor(5, "Luis", "Hernandez", "654123", LocalDate.of(2020, 1, 1)));

        List<Camion> listaCamiones = new ArrayList<Camion>();
        listaCamiones.add(new Camion(1, "Mercedes", "Actros", "1234ABC", listaConductores.get(0)));
        listaCamiones.add(new Camion(2, "Volvo", "FH", "5678DEF", listaConductores.get(1)));
        listaCamiones.add(new Camion(3, "Scania", "R500", "9012GHI", listaConductores.get(2)));
        listaCamiones.add(new Camion(4, "Renault", "T", "3456JKL", listaConductores.get(3)));
        listaCamiones.add(new Camion(5, "Iveco", "Stralis", "7890MNO", listaConductores.get(4)));
        listaCamiones.add(new Camion(6,"Mercedes", "Actros", "1234ABC", listaConductores.get(0)));
        listaCamiones.add(new Camion(7,"Volvo", "FH", "5678DEF", listaConductores.get(1)));
        listaCamiones.add(new Camion(8,"Scania", "R500", "9012GHI", listaConductores.get(2)));
        listaCamiones.add(new Camion(9,"Renault", "T", "3456JKL", listaConductores.get(3)));
        listaCamiones.add(new Camion(10,"Iveco", "Stralis", "7890MNO", listaConductores.get(4)));

        for(Camion camion : listaCamiones) {
            System.out.println(camion.toString());
        }
        for(Conductor conductor : listaConductores) {
            System.out.println(conductor.toString());
        }*/

        /*//Actividad 2
        Camion camion = new Camion(1, "Mercedes", "Actros", "1234GJBC", null);
        if (Camion.validarMatricula(camion.getMatricula())) {
            System.out.println("Matricula valida");
        } else {
            System.out.println("Matricula no valida");
        }
        Camion camion2 = new Camion(2, "Volvo", "FH", "5678BKAR", null);
        if (Camion.validarMatricula(camion2.getMatricula())) {
            System.out.println("Matricula valida");
        } else {
            System.out.println("Matricula no valida");
        }
        Camion camion3 = new Camion(3, "Renault", "T", "3956JKPL", null);
        if (Camion.validarMatricula(camion3.getMatricula())) {
            System.out.println("Matricula valida");
        } else {
            System.out.println("Matricula no valida");
        }*/

        /*//Actividad 3

        List<Conductor> conductores = new ArrayList<>();
        conductores.add(new Conductor(1, "Juan", "Pérez", "123456", LocalDate.of(2020, 1, 1)));
        conductores.add(new Conductor(2, "María", "Gómez", "654321", LocalDate.of(2020, 1, 1)));
        conductores.add(new Conductor(3, "Pedro", "Rodríguez", "456123", LocalDate.of(2020, 1, 1)));

        List<Camion> camiones = new ArrayList<>();
        camiones.add(new Camion(1, "Mercedes", "Actros", "1234BCDF", conductores.get(0)));
        camiones.add(new Camion(2, "Volvo", "FH", "5678KLMN", null));
        camiones.add(new Camion(3, "Scania", "R500", "9012PRST", conductores.get(1)));
        camiones.add(new Camion(4, "Renault", "T", "3456STVW", null));
        camiones.add(new Camion(5, "Iveco", "Stralis", "7890XYZW", conductores.get(2)));

        List<Camion> camionesConConductor = camiones.stream().filter(camion -> camion.getConductorAsignado() != null).toList();
        List<String> nombresConductores = camiones.stream().filter(camion -> camion.getConductorAsignado() != null).map(camion -> camion.getConductorAsignado().getNombre()).toList();
        long camionesSinConductor = camiones.stream().filter(camion -> camion.getConductorAsignado() == null).count();

        System.out.println("Camiones con conductor: " + camionesConConductor);
        System.out.println("Nombres de los conductores: " + nombresConductores);
        System.out.println("Camiones sin conductor: " + camionesSinConductor);

         */

        //Actividad 4
        // Crear lista de conductores
        List<Conductor> conductores = new ArrayList<>();
        conductores.add(new Conductor(1, "Juan", "Pérez", "123456", LocalDate.of(2020, 1, 1)));
        conductores.add(new Conductor(2, "María", "Gómez", "654321", LocalDate.of(2020, 1, 1)));
        conductores.add(new Conductor(3, "Pedro", "Rodríguez", "456123", LocalDate.of(2020, 1, 1)));

        // Crear lista de camiones con añoFabricacion
        List<Camion> camiones = new ArrayList<>();
        camiones.add(new Camion(1, "Mercedes", "Actros", "1234BCDF", conductores.get(0), 2019)); // Juan
        camiones.add(new Camion(2, "Volvo", "FH", "5678KLMN", conductores.get(0), 2021)); // Sin conductor
        camiones.add(new Camion(3, "Scania", "R500", "9012PRST", conductores.get(1), 2018)); // María
        camiones.add(new Camion(4, "Renault", "T", "3456STVW", conductores.get(2), 2020)); // Pedro

        // 1. Ordenar por marca
        Comparator<Camion> porMarca = (c1, c2) -> c1.getMarca().compareTo(c2.getMarca());
        camiones.sort(porMarca);
        System.out.println("Ordenados por marca:");
        camiones.forEach(camion -> System.out.println(camion.toString()));
        System.out.println();

        // 2. Ordenar por año de fabricación
        Comparator<Camion> porAño = (c1, c2) -> Integer.compare(c1.getAñoFabricacion(), c2.getAñoFabricacion());
        camiones.sort(porAño);
        System.out.println("Ordenados por año de fabricación:");
        camiones.forEach(camion -> System.out.println(camion.toString()));
        System.out.println();

        // 3. Ordenar por nombre del conductor
        Comparator<Camion> porNombreConductor = (c1, c2) -> {
            String nombre1 = (c1.getConductorAsignado() != null) ? c1.getConductorAsignado().getNombre() : "";
            String nombre2 = (c2.getConductorAsignado() != null) ? c2.getConductorAsignado().getNombre() : "";
            return nombre1.compareTo(nombre2);
        };
        camiones.sort(porNombreConductor);
        System.out.println("Ordenados por nombre del conductor:");
        camiones.forEach(camion -> System.out.println(camion.toString()));

    }
}