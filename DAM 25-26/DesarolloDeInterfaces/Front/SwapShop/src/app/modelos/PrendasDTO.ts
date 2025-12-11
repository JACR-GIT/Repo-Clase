import { UsuarioDTO } from './UsuarioDTO';

export interface PrendasDTO {
  id?: number;
  id_dueno?: UsuarioDTO;
  nombre_prenda?: string;
  descripcion?: string;
  talla?: string;
  categoria?: string;
  condicion?: string;
  disponible?: boolean;
}
