import {EstadisticasUsuarioDTO} from "./EstadisticasUsuarioDTO";

export interface EstadisticasPrendaDTO {
  id?: number;
  nombrePrenda?: string;
  descripcion?: string;
  talla?: string;
  categoria?: string;
  estilos?: string;
  condicion?: string;
  disponible?: boolean;
  totalIntercambios?: number;
}
