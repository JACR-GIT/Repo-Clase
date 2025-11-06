import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {IonButton, IonCheckbox, IonCol, IonGrid, IonInput, IonItem, IonLabel, IonRow} from "@ionic/angular/standalone";

@Component({
  selector: 'app-formulario-login',
  templateUrl: './formulario-login.component.html',
  styleUrls: ['./formulario-login.component.scss'],
  standalone: true,
  imports: [
    IonItem,
    IonLabel,
    IonInput,
    IonGrid,
    IonRow,
    IonCol,
    IonCheckbox,
    IonButton,
    FormsModule
  ]
})
export class FormularioLoginComponent {

  // Propiedades enlazadas a los inputs
  email: string = '';
  password: string = '';
  remember: boolean = false;

  constructor() { }

  // Método simple para manejar el envío de login
  protected credentials: any;
  login() {
    // Aquí podrías validar y llamar a un servicio de autenticación
    console.log('Login intentado', { email: this.email, password: this.password, remember: this.remember });
    // Ejemplo: mostrar un alert o navegar
  }

  protected goToRegister() {

  }
}
