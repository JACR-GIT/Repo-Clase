package Ejercicio_8;

public abstract class Empleado {

    String nombre;
    int salarioBase;

    public Empleado(String nombre, int salarioBase){
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    abstract double calcularSalario();
}
