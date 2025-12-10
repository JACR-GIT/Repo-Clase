import { Usuario } from './Usuario';
  import { IntercambioPrestamos } from './IntercambiosPrestamos';
  import { Mensaje } from './Mensajes';

  export interface ConversacionCrear {
    id_usuario1: number;
    id_usuario2: number;
    id_intercambio: number;
  }

  export interface Conversacion {
    id: number;
    id_usuario1: number;
    id_usuario2: number;
    id_intercambio: number;
    usuario1: Usuario;
    usuario2: Usuario;
    intercambio: IntercambioPrestamos;
    creadoEn: string; // ISO string
    mensajes: Mensaje[];
  }
