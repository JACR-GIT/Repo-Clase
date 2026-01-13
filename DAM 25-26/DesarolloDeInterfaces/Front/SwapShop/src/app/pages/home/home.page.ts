import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ModalController } from '@ionic/angular';
import {
  IonHeader,
  IonContent,
  IonGrid,
  IonRow,
  IonCol,
  IonToolbar,
  IonTitle,
  IonSearchbar,
  IonButtons,
  IonButton
} from '@ionic/angular/standalone';
import { RouterLink } from "@angular/router";

import { CartaDetallesPrendaComponent } from "../../components/carta-detalles-prenda/carta-detalles-prenda.component";
import { CartaPrendaComponent } from "../../components/carta-prenda/carta-prenda.component";

@Component({
  selector: 'app-home',
  templateUrl: './home.page.html',
  styleUrls: ['./home.page.scss'],
  standalone: true,
  imports: [
    CommonModule,
    IonHeader,
    IonContent,
    IonGrid,
    IonRow,
    IonCol,
    IonToolbar,
    IonTitle,
    IonSearchbar,
    IonButtons,
    IonButton,
    CartaPrendaComponent,
    RouterLink // RouterLink sí es necesario para el botón de perfil
  ]
})
export class HomePage {
  private modalCtrl = inject(ModalController);

  prendas = [
    { titulo: 'Camiseta', precio: 20, imagen: 'https://images.unsplash.com/photo-1576566588028-4147f3842f27?q=80&w=1964&auto=format&fit=crop' },
    { titulo: 'Pantalón', precio: 40, imagen: 'https://images.unsplash.com/photo-1541099649105-f69ad21f3246?q=80&w=1887&auto=format&fit=crop' },
    { titulo: 'Zapatos', precio: 80, imagen: 'https://images.unsplash.com/photo-1543508282-6319a3e2621f?q=80&w=1915&auto=format&fit=crop' },
    { titulo: 'Gorra', precio: 15, imagen: 'https://images.unsplash.com/photo-1588850561407-ed78c282e315?q=80&w=1964&auto=format&fit=crop' },
    { titulo: 'Bufanda', precio: 25, imagen: 'https://images.unsplash.com/photo-1575428652377-a3d810282d98?q=80&w=1887&auto=format&fit=crop' },
    { titulo: 'Sudadera', precio: 50, imagen: 'https://images.unsplash.com/photo-1556304653-cba65c59b3c5?q=80&w=2070&auto=format&fit=crop' },
    { titulo: 'Calcetines', precio: 10, imagen: 'https://images.unsplash.com/photo-1611556204329-968f859fee79?q=80&w=1887&auto=format&fit=crop' },
    { titulo: 'Chaqueta', precio: 100, imagen: 'https://images.unsplash.com/photo-1591047139829-d91aecb6caea?q=80&w=1936&auto=format&fit=crop' }
  ];

  constructor() { }

  async mostrarDetalles(prenda: any) {
    const modal = await this.modalCtrl.create({
      component: CartaDetallesPrendaComponent,
      componentProps: {
        prenda: prenda
      }
    });
    return await modal.present();
  }
}
