//Creamos una constante en vez de un valor numero de una operacion y luego ser llamado en el metodo,
//lo que implica poder ser reutilizada y mejor legibilidad y precisión en el calculo al usar Math.PI

public class Usuario {

   private String nombre;
   private String password;

   public Usuario(String nombre, String password) {
       this.nombre = nombre;
       this.password = password;
   }

   public String getNombre() {
       return nombre;
   }
   public void setNombre(String nombre) {
       this.nombre = nombre;
   }

   public String getPassword() {
       return password;
   }

   public void setPassword(String password) {
       this.password = password;
   }

}
