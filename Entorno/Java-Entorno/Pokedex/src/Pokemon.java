import java.util.HashMap;
import java.util.Map;

public class Pokemon {

    //Propiedades

    private int numPokedex;
    private String nombre;
    private String descripcion;
    private double altura;
    private double peso;
    private Genero genero;
    private String tipo;
    private Ataque ataque;
    private Map<String,String> debilidad;

    //Constructor

    public Pokemon(int numPokedex, String nombre, String descripcion, double altura,double peso, Genero genero, String tipo, Ataque ataque) {
        this.numPokedex = numPokedex;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
        this.tipo = tipo;
        this.ataque = ataque;
        this.debilidad = debilidadPorTipo(tipo);
    }

    //Getters y Setters

    public int getNumPokedex() {
        return numPokedex;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getTipo() {
        return tipo;
    }

    public Ataque getAtaque() {
        return ataque;
    }

    public Map<String,String> getDebilidad() {
        return debilidad;
    }

    //Metodos

    private static Map<String,String> debilidadPorTipo(String tipo) {

        Map<String,String> debilidades = new HashMap<>();

        switch (tipo) {
            case "Planta/Veneno":
                debilidades.put("Planta/Veneno", " Fuego, Hielo, Bicho y Volador");
                break;
            case "Planta":
                debilidades.put("Planta", "Fuego");
                debilidades.put("Planta", "Hielo");
                debilidades.put("Planta", "Bicho");
                debilidades.put("Planta", "Volador");
                debilidades.put("Planta", "Veneno");
                break;
            case "Fuego":
                debilidades.put("Fuego", "Agua");
                debilidades.put("Fuego", "Tierra");
                debilidades.put("Fuego", "Roca");
                break;
            case "Agua":
                debilidades.put("Agua", "Planta");
                debilidades.put("Agua", "Eléctrico");
                break;
            case "Eléctrico":
                debilidades.put("Eléctrico", "Tierra");
                break;
            case "Tierra":
                debilidades.put("Tierra", "Agua");
                debilidades.put("Tierra", "Planta");
                debilidades.put("Tierra", "Hielo");
                break;
            case "Roca":
                debilidades.put("Roca", "Agua");
                debilidades.put("Roca", "Planta");
                debilidades.put("Roca", "Lucha");
                debilidades.put("Roca", "Acero");
                debilidades.put("Roca", "Tierra");
                break;
            case "Hielo":
                debilidades.put("Hielo", "Fuego");
                debilidades.put("Hielo", "Lucha");
                debilidades.put("Hielo", "Roca");
                debilidades.put("Hielo", "Acero");
                break;
            case "Lucha":
                debilidades.put("Lucha", "Volador");
                debilidades.put("Lucha", "Psíquico");
                debilidades.put("Lucha", "Hada");
                break;
            case "Volador":
                debilidades.put("Volador", "Eléctrico");
                debilidades.put("Volador", "Hielo");
                debilidades.put("Volador", "Roca");
                break;
            case "Veneno":
                debilidades.put("Veneno", "Tierra");
                debilidades.put("Veneno", "Psíquico");
                break;
            case "Psíquico":
                debilidades.put("Psíquico", "Bicho");
                debilidades.put("Psíquico", "Fantasma");
                debilidades.put("Psíquico", "Siniestro");
                break;
            case "Bicho":
                debilidades.put("Bicho", "Fuego");
                debilidades.put("Bicho", "Volador");
                debilidades.put("Bicho", "Roca");
                break;
            case "Fantasma":
                debilidades.put("Fantasma", "Fantasma");
                debilidades.put("Fantasma", "Siniestro");
                break;
            case "Siniestro":
                debilidades.put("Siniestro", "Lucha");
                debilidades.put("Siniestro", "Bicho");
                debilidades.put("Siniestro", "Hada");
                break;
            case "Acero":
                debilidades.put("Acero", "Fuego");
                debilidades.put("Acero", "Lucha");
                debilidades.put("Acero", "Tierra");
                break;
            case "Hada":
                debilidades.put("Hada", "Veneno");
                debilidades.put("Hada", "Acero");
                break;
            case "Dragón":
                debilidades.put("Dragón", "Hielo");
                debilidades.put("Dragón", "Dragón");
                debilidades.put("Dragón", "Hada");
                break;
            case "Normal":
                debilidades.put("Normal", "Lucha");
                break;
            case "Normal/Hada":
                debilidades.put("Normal/Hada", "Acero");
                debilidades.put("Normal/Hada", "Veneno");
                break;
            default:
                System.out.println("Tipo no reconocido: " + tipo);
                break;
        }
        return debilidades;
    }

    //toString

    public String toString() {
        return "Nº " + numPokedex + " - " + nombre + " - " + descripcion + '\n' +
                "Altura: " + altura + " m"+ '\n' +
                "Peso: " + peso + " Kg"+ '\n' +
                "Genero: " + genero + '\n' +
                "Tipo: " + tipo + '\n' +
                "Ataque: " + ataque + '\n'+
                "Debilidad: " + debilidad + '\n';

    }
}
