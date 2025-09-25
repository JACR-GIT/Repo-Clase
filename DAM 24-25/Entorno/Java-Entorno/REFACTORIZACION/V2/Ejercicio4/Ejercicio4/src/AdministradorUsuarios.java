public class AdministradorUsuarios {
    public void crearUsuario(String nombre, String password){
        if(validador(nombre, password)){
            Usuario usuario = crearUsuarioInstancia(nombre,password);
            guardarUsuario(usuario);
        }
    }

    public boolean validador(String nombre, String password){
        //Metodo validacion
        return true;
    }

    public Usuario crearUsuarioInstancia (String nombre, String password){
        //Metodo crear usuario
        return new Usuario(nombre, password);
    }

    public void guardarUsuario (Usuario usuario){
        //Metodo para guardar usuario
    }
}
