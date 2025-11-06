import { Component, OnInit } from '@angular/core';
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
    IonButton
  ]
})
export class FormularioLoginComponent  implements OnInit {

  constructor() { }

  ngOnInit() {}

}
