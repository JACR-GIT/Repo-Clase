
/**
* Clase Persona
* Contiene el atributo numeroDeTelefono
* @version 1.0, 07/09/2021
* @autor Guillermo Tejado
*/
public class Persona {
    //Refactor Move Class para mover la clase Profesor a su propio archivo.
    //Usar private en el atributo de la clase para que no se pueda acceder desde otra clase
    //Encapsular atributos de la clase Persona
   private String numeroDeTelefono;

   public Persona(String numeroDeTelefono) {
       super();
       this.numeroDeTelefono = numeroDeTelefono;
   }

   public String getNumeroDeTelefono() {
       return numeroDeTelefono;
   }

   public void setNumeroDeTelefono(String numeroDeTelefono) {
       
       this.numeroDeTelefono = numeroDeTelefono;
   }
}

