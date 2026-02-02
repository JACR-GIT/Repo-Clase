// src/app/services/usuario.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UsuarioDTO } from '../../modelos/UsuarioDTO';

export interface EstadisticasUsuarioDTO {
  id?: number;
  nombreUsuario?: string;
  totalIntercambios?: number;
  // Ajusta según lo que devuelva tu repository
}

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private apiUrl = 'https://swapshop-f96d.onrender.com';

  // eslint-disable-next-line @angular-eslint/prefer-inject
  constructor(private http: HttpClient) {}

  // Crear usuario (por si lo llamas desde otro sitio)
  crearUsuario(usuario: UsuarioDTO): Observable<UsuarioDTO> {
    return this.http.post<UsuarioDTO>(this.apiUrl, usuario);
  }

  // Obtener usuario por ID
  obtenerUsuarioPorId(id: number): Observable<UsuarioDTO> {
    return this.http.get<UsuarioDTO>(`${this.apiUrl}/${id}`);
  }

  // Obtener todos los usuarios
  obtenerTodosLosUsuarios(): Observable<UsuarioDTO[]> {
    return this.http.get<UsuarioDTO[]>(this.apiUrl);
  }

  // Estadística: usuario con más intercambios
  obtenerUsuarioConMasIntercambios(): Observable<EstadisticasUsuarioDTO> {
    return this.http.get<EstadisticasUsuarioDTO>(`${this.apiUrl}/estadisticas/mas-intercambios`);
  }
}
