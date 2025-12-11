import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UsuarioDTO} from "../../modelos/UsuarioDTO";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {

  private http = inject(HttpClient);
  private readonly apiUrl = 'http://localhost:8080/api/usuarios';

  obtenerTodosLosUsuarios(): Observable<UsuarioDTO[]> {
    return this.http.get<UsuarioDTO[]>(`${this.apiUrl}/all`);
  }


}
