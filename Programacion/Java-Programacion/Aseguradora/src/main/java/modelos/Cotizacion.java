package modelos;

import java.time.LocalDate;
import java.util.List;

public class Cotizacion {

    //Propiedades

    enum Modalidad {
        TERC,
        TAMP,
        TRIE
    }

    private int id;
    private int codigo;
    private LocalDate fechaCotizacion;
    private LocalDate fechaInicio;
    private Vehiculo vehiculo;
    private Persona tomador;
    private Conductor conductorPrincipal;
    private List<Conductor> conductoresOcasionales;
    private boolean tieneAparcamientoPrivado;
    private int numSini5;
    private double precioTERC;
    private double precioTAMP;
    private double precioTRIE;
    private Modalidad modalidadElegida;



}
