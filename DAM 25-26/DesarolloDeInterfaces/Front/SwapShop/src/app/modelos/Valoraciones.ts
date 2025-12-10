import { Usuario } from './Usuario';

export interface Valoracion {
  id?: number;

  // Solo IDs al crear
  id_valorador: number;     // quien deja la valoración
  id_valorado: number;      // quien recibe la valoración

  puntuacion: 1 | 2 | 3 | 4 | 5;

  // Poblado por el backend en GET
  valorador?: Usuario;
  valorado?: Usuario;
  creadoEn?: string;
}

