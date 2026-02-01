import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ModalController } from '@ionic/angular/standalone';
import { IonTabs, IonTabBar, IonTabButton, IonIcon, IonImg } from '@ionic/angular/standalone';
import { AddPrendaModalComponent } from '../../components/carta-add-prenda/carta-add-prenda.component';

@Component({
  selector: 'app-tabs',
  templateUrl: './tabs.page.html',
  styleUrls: ['./tabs.page.scss'],
  standalone: true,
  imports: [
    IonTabs, IonTabBar, IonTabButton, IonIcon, IonImg,
    CommonModule
  ]
})
export class TabsPage {
  private modalCtrl = inject(ModalController);

  constructor() { }

  async openAddPrendaModal() {
    const modal = await this.modalCtrl.create({
      component: AddPrendaModalComponent,
    });
    modal.present();
  }
}
