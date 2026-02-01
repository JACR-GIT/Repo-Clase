export interface ConversacionDTO {
  id?: number;
  id_usuario1?: number;
  id_usuario2?: number;
  id_intercambio?: number;
  id_mensajes?: number[]; // ids de los mensajes en la conversación
}
