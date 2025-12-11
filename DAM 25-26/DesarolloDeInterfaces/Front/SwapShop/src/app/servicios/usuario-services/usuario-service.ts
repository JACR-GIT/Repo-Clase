import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Usuario} from "../../modelos/UsuarioDTO";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {

  private http = inject(HttpClient);
  private readonly apiUrl = 'http://localhost:8080/api/usuarios';

  obtenerTodosLosUsuarios(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`${this.apiUrl}/all`);
  }


}
