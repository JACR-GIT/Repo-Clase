public class ValidarUsuario {

    private static boolean validarNulosOVacios(String email) {
        return email != null && !email.isEmpty();
    }


    public boolean validarEmail(String email){
        boolean valido = validarNulosOVacios(email);
        //logica de validacion de email;
        return valido;
    }


    public boolean validarTelefono(String telefono){
        boolean valido = validarNulosOVacios(telefono);
        //Logica de validacion telefono
        return valido;
    }
}
