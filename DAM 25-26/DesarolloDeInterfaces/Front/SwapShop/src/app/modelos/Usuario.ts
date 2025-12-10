export interface Usuario {
  id?: number;
  nombreUsuario: string;
  nombre: string;
  apellido1: string;
  apellido2: string;
  correo: string;
  contrasena?: string;
  fecha_nac?: string | Date;
}
