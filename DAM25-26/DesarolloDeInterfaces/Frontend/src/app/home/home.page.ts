import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {
  IonHeader, IonToolbar, IonTitle, IonContent,
  IonItem, IonLabel, IonInput, IonButton, IonList, IonCard, IonCardContent
} from '@ionic/angular/standalone';
import { UsuarioService } from '../servicios/usuario-services/usuario-service';
import { UsuarioDTO } from '../modelos/UsuarioDTO';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
  standalone: true,
  imports: [
    FormsModule, IonHeader, IonToolbar, IonTitle, IonContent,
    IonItem, IonLabel, IonInput, IonButton, IonList, IonCard, IonCardContent
  ],
})
export class HomePage {
  private usuarioService = inject(UsuarioService);

  usuario: UsuarioDTO = {
    nombreUsuario: '',
    nombre: '',
    apellido1: '',
    apellido2: '',
    correo: '',
    contrasena: '',
    fecha_nac: ''
  };

  onLogin() {
    console.log('Datos a enviar:', this.usuario);

    this.usuarioService.crearUsuario(this.usuario).subscribe({
      next: (res: UsuarioDTO) => {
        alert('Éxito: Usuario ' + res.nombreUsuario + ' creado.');
      },
      error: (err: any) => {
        console.error('Error de conexión:', err);
        alert('Error al conectar con Render. Revisa la consola.');
      }
    });
  }
}
