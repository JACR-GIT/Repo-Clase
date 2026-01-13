import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs';
import { PrendasDTO } from '../../modelos/PrendasDTO';

@Injectable({
  providedIn: 'root'
})
export class PrendasService {
  private api = `${environment.apiUrl}/prendas`;  // Coincide con /api/prendas

  constructor(private http: HttpClient) {}

  // Lista mis prendas (por dueño)
  getMisPrendas(idUsuario: number): Observable<PrendasDTO[]> {
    return this.http.get<PrendasDTO[]>(`${this.api}/dueno/${idUsuario}`);
  }

  // Crear
  crear(prenda: PrendasDTO): Observable<PrendasDTO> {
    return this.http.post<PrendasDTO>(this.api, prenda);
  }

  // Actualizar
  actualizar(prenda: PrendasDTO): Observable<PrendasDTO> {
    if (!prenda.id) {
      throw new Error('ID requerido');
    }
    return this.http.put<PrendasDTO>(`${this.api}/${prenda.id}`, prenda);
  }

  // Eliminar
  eliminar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.api}/${id}`);
  }

  obtenerTodasDisponibles(): Observable<PrendasDTO[]> {
    return this.http.get<PrendasDTO[]>(`${this.api}/disponibles`);
  }
}
