import { Usuario } from './Usuario';

export interface Prenda {
  id?: number;

  // Relación con el dueño
  id_dueno: number;                 // <-- este es el ID del usuario dueño
  dueno?: Usuario;          // <-- este se rellena en respuestas GET (opcional)

  nombrePrenda: string;
  descripcion?: string;
  talla: string;                    // ej: "M", "38", "42-44"
  categoria: string;                // ej: "Camisetas", "Vestidos", "Zapatos"
  condicion: string;                // ej: "Nuevo con etiqueta", "Como nuevo", "Bueno"
  disponible: boolean;              // true = se puede solicitar

  // Campos que el backend suele añadir automáticamente
  fotos?: string[];                 // <-- lo añadiremos después (no está en la entidad, pero seguro lo tienes en otro lado o lo vas a subir)
}
