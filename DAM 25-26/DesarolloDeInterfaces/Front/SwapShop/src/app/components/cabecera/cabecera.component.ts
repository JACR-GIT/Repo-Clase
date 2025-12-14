import { Component } from '@angular/core';
import {
  IonHeader,
  IonToolbar,
  IonTitle,
  IonButtons,
  IonButton,
  IonIcon,
  IonBackButton, IonSearchbar, IonAvatar
} from '@ionic/angular/standalone';

@Component({
  selector: 'app-cabecera',
  templateUrl: './cabecera.component.html',
  styleUrls: ['./cabecera.component.scss'],
  standalone: true,
  imports: [
    IonHeader,
    IonToolbar,
    IonButtons,
    IonButton,
    IonIcon,
    IonSearchbar,
    IonAvatar,
    // Añade aquí cualquier otro componente Ionic que uses en cabecera.component.html
  ]
})
export class CabeceraComponent {
  private actionSheetCtrl: any;
  constructor() { }

  async openFilters() {
    const actionSheet = await this.actionSheetCtrl.create({
      header: 'Filtrar por',
      buttons: [
        { text: 'Camisetas', icon: 'shirt-outline' },
        { text: 'Pantalones', icon: 'walk-outline' },
        { text: 'Vestidos', icon: 'woman-outline' },
        { text: 'Zapatos', icon: 'footsteps-outline' },
        { text: 'Accesorios', icon: 'watch-outline' },
        { text: 'Cancelar', role: 'cancel', icon: 'close' }
      ]
    });
    await actionSheet.present();
  }
}
