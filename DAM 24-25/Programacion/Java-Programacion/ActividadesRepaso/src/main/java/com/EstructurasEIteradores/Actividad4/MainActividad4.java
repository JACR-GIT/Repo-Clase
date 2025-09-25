package com.EstructurasEIteradores.Actividad4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActividad4 {
    public static void main(String[] args) {
        List<String> tareas = new ArrayList<>();
        tareas.add("Barrer [completada]");
        tareas.add("Fregar [pendiente]");
        tareas.add("Cocinar [completada]");
        tareas.add("Lavar la ropa [pendiente]");
        tareas.add("Sacar la basura [completada]");

        Iterator<String> iterator = tareas.iterator();
        while (iterator.hasNext()) {
            String tarea = iterator.next();
            if (tarea.contains("[completada]")) {
                iterator.remove();
            }
        }

        for (String tarea : tareas) {
            System.out.println(tarea);
        }
    }
}
