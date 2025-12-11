import { Component } from '@angular/core';
import {
  IonContent,
  IonButton,
  IonIcon,
  IonInput,
  IonLabel,
  IonCheckbox, // Si lo usas en el futuro
  IonDatetime
} from '@ionic/angular/standalone';

@Component({
  selector: 'app-register',
  templateUrl: './register.page.html',
  styleUrls: ['./register.page.scss'],
  standalone: true,
  imports: [
    IonContent,
    IonButton,
    IonIcon,
    IonInput,
    IonLabel,
    IonDatetime,
    // IonCheckbox,  // Descomenta si lo necesitas más adelante
    // CommonModule, FormsModule si usas ngModel, etc.
  ]
})
export class RegisterPage {
  constructor() { }
}
