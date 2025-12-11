import { Component } from '@angular/core';
import {
  IonButton, IonButtons, IonCard,
  IonCardContent, IonCardHeader,
  IonCardTitle, IonContent, IonHeader, IonIcon, IonInput,
  IonItem,
  IonLabel,
  IonSelect,
  IonSelectOption, IonTextarea, IonTitle, IonToolbar
} from "@ionic/angular/standalone";

@Component({
  selector: 'app-registrar-prenda',
  templateUrl: './registrar-prenda.component.html',
  styleUrls: ['./registrar-prenda.component.scss'],
  imports: [
    IonItem,
    IonLabel,
    IonSelect,
    IonSelectOption,
    IonButton,
    IonCardContent,
    IonCardTitle,
    IonCardHeader,
    IonCard,
    IonContent,
    IonIcon,
    IonInput,
    IonTextarea,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonButtons
  ]
})
export class RegistrarPrendaComponent   {

  constructor() { }

}
