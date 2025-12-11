import { Component, OnInit } from '@angular/core';
import {
  IonBackButton,
  IonButton,
  IonButtons, IonHeader,
  IonIcon,
  IonSearchbar,
  IonTitle,
  IonToolbar
} from "@ionic/angular/standalone";

@Component({
  selector: 'app-cabezera',
  templateUrl: './cabezera.component.html',
  styleUrls: ['./cabezera.component.scss'],
  imports: [
    IonToolbar,
    IonButtons,
    IonBackButton,
    IonTitle,
    IonButton,
    IonIcon,
    IonSearchbar,
    IonHeader
  ]
})
export class CabezeraComponent  implements OnInit {

  constructor() { }

  ngOnInit() {}

}
