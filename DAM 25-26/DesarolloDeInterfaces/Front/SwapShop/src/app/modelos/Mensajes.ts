import { Usuario } from './Usuario';

export interface Mensaje {
  id?: number;

  // Solo IDs al crear
  id_conversacion: number;
  id_remitente: number;     // <-- tal como lo tienes en la BD
  contenido: string;

}
