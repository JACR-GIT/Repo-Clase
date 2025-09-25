package com.EstructurasEIteradores.Actividad7;

public class MainActividad7 {
    public static void main(String[] args) {
        Sensor sensor = new Sensor("A1", 5);
        System.out.println("Valor inicial: " + sensor.getValor());
        System.out.println("¿Valor normal? " + sensor.esValorNormal());

        sensor.actualizarValor(50);

        System.out.println("Valor actualizado: " + sensor.getValor());
        System.out.println("¿Valor normal? " + sensor.esValorNormal());
    }
}
