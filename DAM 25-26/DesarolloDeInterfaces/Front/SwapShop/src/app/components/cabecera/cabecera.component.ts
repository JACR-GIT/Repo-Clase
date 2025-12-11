import { Component } from '@angular/core';
import {
  IonHeader,
  IonToolbar,
  IonTitle,
  IonButtons,
  IonButton,
  IonIcon,
  IonBackButton, IonSearchbar
} from '@ionic/angular/standalone';

@Component({
  selector: 'app-cabecera',
  templateUrl: './cabecera.component.html',
  styleUrls: ['./cabecera.component.scss'],
  standalone: true,
  imports: [
    IonHeader,
    IonToolbar,
    IonTitle,
    IonButtons,
    IonButton,
    IonIcon,
    IonBackButton,
    IonSearchbar,
    // Añade aquí cualquier otro componente Ionic que uses en cabecera.component.html
  ]
})
export class CabeceraComponent {
  constructor() { }
}
