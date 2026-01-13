export interface UsuarioDTO {
  id?: number;
  nombreUsuario: string;
  nombre: string;
  apellido1: string;
  apellido2?: string;        // Opcional
  correo: string;
  contrasena?: string;      // Solo en registro/login, no se muestra después
  fecha_nac: string;        // Usaremos string en formato 'YYYY-MM-DD' para ion-datetime
}
