public class FechaImpl {
    private int dia;
    private int mes;
    private int año;

    // Constructor
    public FechaImpl(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    // Getters (consultables)
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    // Representación como cadena
    public String toString() {
        return dia + "/" + mes + "/" + año;
    }
}
