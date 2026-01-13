import { PrendasDTO } from './PrendasDTO';
import { UsuarioDTO } from './UsuarioDTO';

export interface IntercambiosPrestamosDTO {
  id?: number;
  id_prenda?: PrendasDTO;
  id_prenda2?: PrendasDTO;
  id_solicitante?: UsuarioDTO;
  id_dueno?: UsuarioDTO;
  tipo?: string;
  estado?: string;
  fecha_inicio?: Date;
  fecha_fin?: Date;
}
