package Ejercicio_4;

public interface Vehiculo {
    default void detener(){
        System.out.println("Deteniendo vehiculo");
    };
    public  void mover();
}
