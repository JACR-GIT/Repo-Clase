/**
 * Cordenadas de un punto x e y
 * La X va a ser un entero,va a ser consultable y modificable
 * La y va a ser un entero,va a seer consultable y modificable
 * Representacion como cadena: (x, y)
 */
public class PuntoImpl implements Punto /*Implements Punto sierve para linkear la interface con la clase*/{
    //1º variable/atributo
    private Integer x;
    private Integer y;
    //2º constructor
    public PuntoImpl(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
    //3º getters y setters
    //X, consultable
    public Integer getX(){
        return x;
    }
    //X, modificable
    public void setX(Integer x){
        this.x = x;
        //Otra posibilidad es escribir x=x1 pero tendria que cambiarle el nombre a Intreger x1
    }
    //Y, consultable
    public Integer getY(){
        return y;
    }
    //Y, modificable
    public void setY(Integer y){
        this.y = y;
    }

    //4º otros metodos
    //5º toString
    public String toString(){
        return "(" + getX() + ", " + getY() + ")";
    }
}
