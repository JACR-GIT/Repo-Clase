//Como puede ver, todas las propiedades, excepto una, se pueden definir a partir de los tipos de Java vistos en la clase de teoría. Así que, defina también un tipo para trabajar con las festividades de un restaurante. El tipo Festividad ha detener las siguientes propiedades:
//
//nombreFiesta, de tipo String. Nombre de la festividad (consultable).
//mes, de tipo cadena. Representa el mes en el que tiene lugar la fiesta (consultable y modificable).
//
//
//
//La representación como cadena, como se muestra en el siguiente ejemplo:
//
//        Semana Santa, en abril.

public class FestividadesImpl implements Festividades {

    //Propiedades

    private String nombreFiesta;
    private String mes;

    //Constructor

    public FestividadesImpl(String nombreFiesta, String mes) {
        this.nombreFiesta = nombreFiesta;
        this.mes = mes;
    }

    //Getters y Setters


    public String getNombreFiesta() {
        return nombreFiesta;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    //toString

    public String toString() {
        return nombreFiesta + ", en " + mes;
    }
}
