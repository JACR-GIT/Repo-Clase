package Ejercicio_6;

abstract class Cocinero {

    public void cocinar() {
        prepararIngredientes();
        cocinarPlato();
        System.out.println("Plato listo para servir");
    }

    public abstract void prepararIngredientes();

    public abstract void cocinarPlato();
}
