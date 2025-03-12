package Ejercicio_8;

public class Gerente extends Empleado {
    int bono;

    public Gerente(String nombre, int salarioBase, int bono){
        super(nombre, salarioBase);
        this.bono = bono;
    }

    double calcularSalario() {
        double salarioFinal = salarioBase + bono;
        return salarioFinal;
    }
}
