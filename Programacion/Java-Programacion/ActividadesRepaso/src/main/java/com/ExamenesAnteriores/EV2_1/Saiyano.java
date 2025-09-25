//package com.ExamenesAnteriores.EV2_1;
//
//import com.examen.dam1.*;
//
//import java.util.List;
//import java.util.OptionalInt;
//
//public class Saiyano extends Personaje {
//
//    List<Transformacion> listaTransformaciones;
//
//    public Saiyano(String nombre, String nombreIdentidad, Sexo sexo, Raza raza, Obra obra, Bando bando, Protagonismo protagonismo, List<Transformacion> listaTransformaciones) {
//        super(nombre, nombreIdentidad, sexo, raza, obra, bando, protagonismo);
//        this.listaTransformaciones = listaTransformaciones;
//    }
//
//    public Saiyano(Personaje personaje, List<Transformacion> listaTransformaciones) {
//        super(personaje);
//        this.listaTransformaciones = listaTransformaciones;
//    }
//
//    public List<Transformacion> getListaTransformaciones() {
//        return listaTransformaciones;
//    }
//
//    public void setListaTransformaciones(List<Transformacion> listaTransformaciones) {
//        this.listaTransformaciones = listaTransformaciones;
//    }
//
//    @Override
//    public String toString() {
//        OptionalInt maxPoder = listaTransformaciones.stream()
//                .mapToInt(Transformacion::getPoder)
//                .max();
//        return getNombre() + " (" + maxPoder + ")";
//    }
//}
