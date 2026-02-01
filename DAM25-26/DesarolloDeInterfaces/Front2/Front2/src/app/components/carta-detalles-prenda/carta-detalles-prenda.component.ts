import { Component, Input, inject } from '@angular/core';
import { IonicModule, ModalController } from '@ionic/angular';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-carta-detalles-prenda',
  templateUrl: './carta-detalles-prenda.component.html',
  styleUrls: ['./carta-detalles-prenda.component.scss'],
  standalone: true,
  imports: [CommonModule, IonicModule, FormsModule]
})
export class CartaDetallesPrendaComponent {
  @Input() prenda: any;

  private modalCtrl = inject(ModalController);

  // Datos de ejemplo si no se proporciona ninguna prenda
  nombrePrenda = 'Camisa Formal';
  fotoPreview: string | null = 'assets/Captura de pantalla 2025-12-12 185357.png';

  secciones = [
    { titulo: 'Categoría', chips: ['Camisa', 'Pantalón', 'Zapatos'] },
    { titulo: 'Estilo', chips: ['Formal', 'Casual', 'Streetwear'] },
    { titulo: 'Condición', chips: ['Nuevo', 'Usado'] },
    { titulo: 'Talla', chips: ['S'] },
  ];

  constructor() {}

  cerrar() {
    this.modalCtrl.dismiss();
  }
}
