public class ClasePrincipal {
    public static void main (String[] args){
        String cadena = "a";
        do{
            cadena = cadena + "e";
        }while (cadena.length()<5);
        System.out.println(cadena);
        do {
            cadena=cadena+ "i";
        }while (cadena.length() <3 );
        System.out.println(cadena);
    }
}

//