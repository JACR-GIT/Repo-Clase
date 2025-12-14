import { Component, inject } from '@angular/core';
import { IonicModule } from '@ionic/angular';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ModalController } from '@ionic/angular';

@Component({
  selector: 'app-carta-add-prenda',
  templateUrl: './carta-add-prenda.component.html',
  styleUrls: ['./carta-add-prenda.component.scss'],
  standalone: true,
  imports: [CommonModule, IonicModule, FormsModule]
})
export class AddPrendaModalComponent {
  private modalCtrl = inject(ModalController);

  nombrePrenda = '';
  fotoPreview: string | null = null;

  constructor() {}

  cerrar() {
    this.modalCtrl.dismiss();
  }

  seleccionarFoto() {
    // Aquí conectarás con la cámara/galería más adelante
    console.log('Abrir selector de foto');
  }
}
