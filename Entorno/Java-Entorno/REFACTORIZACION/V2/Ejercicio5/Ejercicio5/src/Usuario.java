public class Usuario {
    private String nombreUsuario;
    private String password;

    public Usuario(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;

    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}

class ValidarUsuario{
       public boolean validarUsuario(Usuario usuario){
           //Metodo validar usuario
           return true;
       }

}

class ValidarPassword{
    public boolean validarPassword(String password){
        //Metodo validar contraseña
        return true;
    }
}


class CrearUsuario{
    public void crearUsuario(Usuario usuario){
        //Metodo para crear el usuario
    }
}


class GuardarUsuario{
    public void guardarUsuario(Usuario usuario){
        //metodo para guardar el usuario
    }
}


