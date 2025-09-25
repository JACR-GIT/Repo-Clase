public class Fecha {

    private int dia;
    private int mes;
    private int anio;

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;

    }

    public boolean valida() {
        if (!esDiaValido() && !esMesValido()) {
            return false;
        }
        int diaMes = obtenerDiaMes();
        return dia <= diaMes;
    }

    public boolean esDiaValido() {
        return dia >= 0 && dia <= 31;
    }

    private boolean esMesValido() {
        return mes >= 0 && mes <= 12;
    }

    public int obtenerDiaMes() {
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if ((anio % 400 == 0) || ((anio % 4 == 0) && (anio % 100 != 0))) {
                    return 29;
                } else {
                    return 28;
                }
        }
        return 0;
    }
// determinamos la cantidad de días del mes:





// … más métodos


}