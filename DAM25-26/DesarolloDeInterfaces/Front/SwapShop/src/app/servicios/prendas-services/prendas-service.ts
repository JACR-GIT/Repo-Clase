import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root',
})
export class PrendasService {

  private http = inject(HttpClient);
  private readonly apiUrl = 'http://localhost:8080/api/prendas';

  getPrendasDisponibles() {
    return this.http.get(`${this.apiUrl}/disponibles`);
  }

}
