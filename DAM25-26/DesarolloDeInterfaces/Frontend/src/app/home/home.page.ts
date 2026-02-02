import { Component } from '@angular/core';
import { UsuarioService } from '../servicios/usuario-services/usuario-service';
import { UsuarioDTO } from '../modelos/UsuarioDTO';
import {
  IonButton,
  IonContent,
  IonHeader,
  IonInput,
  IonItem,
  IonLabel,
  IonList,
  IonTitle,
  IonToolbar
} from "@ionic/angular/standalone";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
  imports: [
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    IonList,
    IonInput,
    IonLabel,
    IonItem,
    FormsModule,
    IonButton
  ]
})
export class HomePage {
  // Creamos el objeto vacío basado en tu DTO
  usuario: UsuarioDTO = {
    nombreUsuario: '',
    nombre: '',
    apellido1: '',
    correo: '',
    contrasena: '',
    fecha_nac: ''
  };

  constructor(private usuarioService: UsuarioService) {}

  enviarLogin() {
    console.log('Datos que viajan a Render:', this.usuario);

    this.usuarioService.crearUsuario(this.usuario).subscribe({
      next: (res) => {
        alert('¡Bienvenido ' + res.nombreUsuario + '!');
      },
      error: (err) => {
        console.error('Error al conectar:', err);
        alert('Hubo un error con el servidor en Render.');
      }
    });
  }
}
