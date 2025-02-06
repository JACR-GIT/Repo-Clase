public class PoblacionImpl {

    //Propiedades

    private String nombre;
    private int numHabitantes;
    private double superficie;
    private int personasTrabajando;
    private int numPersonasEmpleadas;


    //Constructor
    public PoblacionImpl implemets Poblacion(String nombre, int numHabitantes, double superficie, int personasTrabajando) {
        this.nombre = nombre;
        this.numHabitantes = numHabitantes;
        this.superficie = superficie;
        this.personasTrabajando = personasTrabajando;
    }


    //Getters y Setters


    public String getNombre() {
        return nombre;
    }

    public int getNumHabitantes() {
        return numHabitantes;
    }

    public double getSuperficie() {
        return superficie;
    }

    public int getPersonasTrabajando() {
        return personasTrabajando;
    }

    public int getNumPersonasEmpleadas() {
        return numPersonasEmpleadas;
    }

    public void setNumHabitantes(int numHabitantes) {
        this.numHabitantes = numHabitantes;
    }

    public void setPersonasTrabajando(int personasTrabajando) {
        this.personasTrabajando = personasTrabajando;
    }

    public void setNumPersonasEmpleadas(int numPersonasEmpleadas) {
        this.numPersonasEmpleadas = numPersonasEmpleadas;
    }

    //Metodos

    public double densidadPoblacion (int numHabitantes, double superficie ){
        double densidadPoblacion1 = numHabitantes/superficie;
        return densidadPoblacion1;
    }

    public double porcentajeDesempleo (int numHabitantes, int personasTrabajando){
        double porcentajeEmpleo = (personasTrabajando/numHabitantes)*100;
        double porcentajeDesempleo = 100 - porcentajeEmpleo;
        return porcentajeDesempleo;
    }

    //toString

    public String toString() {
        return nombre + " posee una densidad de poblacion de " + densidadPoblacion(numHabitantes,superficie) + " hab/km2";

    }
}
