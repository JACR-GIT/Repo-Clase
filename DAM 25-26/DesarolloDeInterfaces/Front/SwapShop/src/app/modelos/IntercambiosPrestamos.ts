import { Prenda } from './Prendas';
import { Usuario } from './Usuario';
import { EstadoIntercambio } from './estado-intercambio';
import { TipoIntercambio } from './tipo-intercambio';

export interface IntercambioPrestamos {
  id?: number;

  // Relaciones (solo IDs al crear)
  id_prenda: number;
  id_prenda2: number;
  id_solicitante: number;
  id_dueno: number;

  // Datos poblados en respuestas GET
  prenda?: Prenda;
  prenda2?: Prenda;
  solicitante?: Usuario;
  dueno?: Usuario;

  // Enums
  tipo: TipoIntercambio;
  estado: EstadoIntercambio;

  // Fechas (usamos string ISO para evitar problemas con java.sql.Date)
  fechaInicio?: string;    // "2025-12-20"
  fechaFin?: string;       // "2025-12-27"
}
