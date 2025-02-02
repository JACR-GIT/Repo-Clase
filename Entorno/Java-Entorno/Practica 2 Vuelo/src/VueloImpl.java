public class VueloImpl implements Vuelo{
    //1º variables
    private String codVuelo;
    private String destino;
    private Double precio;
    private Integer numPlazas;
    private Integer numPasajeros;
    private Fecha fechaSalida;
    private Persona piloto;
    //2º constructor
    public VueloImpl(String cod,String dest,Double pre,Integer numPl, Integer numPas, Fecha f, Persona p){
        codVuelo=cod;
        destino=dest;
        precio=pre;
        numPasajeros=numPas;
        fechaSalida=f;
        piloto=p;
        numPlazas=numPl;
    }

    //3º getters y setters
    public String getCodVuelo() {
        return codVuelo;
    }
    public String getDestino() {
        return destino;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double p) {
        precio=p;
    }
    public Integer getNumPlazas() {
        return numPlazas;
    }
    public Integer getNumPasajeros() {
        return numPasajeros;
    }
    public void setNumPasajeros(Integer n) {
        numPasajeros=n;
    }
    public Fecha getFechaSalida() {
        return fechaSalida;
    }
    public Persona getPiloto() {
        return piloto;
    }
    public void setPiloto(Persona p) {
        piloto=p;
    }

    //4º metodos
    public Double recaudacion(){
        return getPrecio()*getNumPasajeros();
    }
    //5º toString
    public String toString(){
        return getCodVuelo()+" ("+getDestino()+")- "+getPiloto()+" -"+getFechaSalida();
    }
}
