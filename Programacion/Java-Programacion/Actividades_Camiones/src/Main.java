import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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


    }
}