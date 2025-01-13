public class Main {
    public static void main(String[] args) {
        //Constructorç
        Punto p = new PuntoImpl (1, 2);
        //NombreInterface nombre= new nombreClase();
        System.out.println("La cordenada X vale: "+p.getX());

        //Mostrar el conjunto entero segun nos pide el enunciado
        System.out.println("La cordenada son: "+p);
    }
}
