import { Component, OnInit } from '@angular/core';
import {IonCard, IonCardContent, IonCardHeader, IonCardTitle} from "@ionic/angular/standalone";

@Component({
  selector: 'app-carta-prenda',
  templateUrl: './carta-prenda.component.html',
  styleUrls: ['./carta-prenda.component.scss'],
  imports: [
    IonCard,
    IonCardHeader,
    IonCardTitle,
    IonCardContent
  ]
})
export class CartaPrendaComponent  implements OnInit {

  constructor() { }

  ngOnInit() {}

}
