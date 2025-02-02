public interface Vuelo {
    //estructura de get
    //Tipo getNombre();
    //estructura set
    //void setNombre(Tipo t);

    String getCodVuelo();
    String getDestino();
    Double getPrecio();
    void setPrecio(Double p);
    Integer getNumPlazas();
    Integer getNumPasajeros();
    void setNumPasajeros(Integer n);
    Fecha getFechaSalida();
    Persona getPiloto();
    void setPiloto(Persona p);
}
