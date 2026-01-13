import { UsuarioDTO } from './UsuarioDTO';

export interface ValoracionesDTO {
  id?: number;
  valorador?: UsuarioDTO;
  valorado?: UsuarioDTO;
  puntuacion?: number;
}
