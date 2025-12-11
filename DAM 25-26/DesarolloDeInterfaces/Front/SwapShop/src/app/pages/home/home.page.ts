import { Component } from '@angular/core';
import {
  IonHeader,
  IonContent,
  IonFooter,
  IonGrid,
  IonRow,
  IonCol,
  IonSearchbar,
  IonFab,
  IonFabButton,
  IonIcon
} from '@ionic/angular/standalone';

import { CabeceraComponent } from '../../components/cabecera/cabecera.component';
import { FooterComponent } from '../../components/footer/footer.component';
import { CartaPrendaComponent } from '../../components/carta-prenda/carta-prenda.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.page.html',
  styleUrls: ['./home.page.scss'],
  standalone: true,
  imports: [
    IonHeader,
    IonContent,
    IonFooter,
    IonGrid,
    IonRow,
    IonCol,
    IonSearchbar,
    IonFab,
    IonFabButton,
    IonIcon,
    FooterComponent,
    CartaPrendaComponent,
    CabeceraComponent
  ]
})
export class HomePage {
  constructor() { }
}
