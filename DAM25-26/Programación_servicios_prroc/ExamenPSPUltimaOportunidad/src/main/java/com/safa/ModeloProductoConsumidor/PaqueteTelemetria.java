package com.safa.ModeloProductoConsumidor;

public class PaqueteTelemetria {
    //Definimos los datos que se van a enviar en el paquete de telemetría
    int temp, batt;
    double rad, vel;

    public String comprobarAnomalias() {
        StringBuilder alertas = new StringBuilder();
        if (temp > 85) alertas.append("SOBRECALENTAMIENTO ");
        if (batt < 30) alertas.append("BATERIA BAJA ");
        if (rad > 1.5) alertas.append("RADIACION ALTA ");
        if (vel > 5) alertas.append("ROTACION EXCESIVA ");

        return alertas.length() == 0 ? "OK" : alertas.toString().trim();
    }
}
