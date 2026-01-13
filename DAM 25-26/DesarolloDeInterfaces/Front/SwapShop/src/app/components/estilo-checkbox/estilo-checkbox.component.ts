import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';

@Component({
  selector: 'app-estilo-checkbox',
  standalone: true,
  imports: [IonicModule, CommonModule],
  templateUrl: './estilo-checkbox.component.html',
  styleUrls: ['./estilo-checkbox.component.scss']
})
export class EstiloCheckboxComponent {

  estilos: string[] = [
    'CASUAL',
    'FORMAL',
    'DEPORTIVO',
    'STREETWEAR',
    'ELEGANTE',
    'VINTAGE',
    'BOHEMIO',
    'URBANO',
    'ROCK',
    'HIPSTER',
    'MINIMALISTA',
    'PREPPY',
    'RETRO',
    'GÓTICO',
    'MILITAR',
    'ETHNIC',
    'CHIC',
    'PUNK',
    'SKATER',
    'CLASSIC',
    'BUSINESS',
    'SMART_CASUAL',
    'FASHIONISTA',
    'AVANT_GARDE',
    'ARTY',
    'ROMANTICO',
    'HIP_HOP',
    'LOUNGE',
    'ECOFRIENDLY',
    'FESTIVAL',
    'COUTURE',
    'MODERNO',
    'SOPHISTICATED',
    'PLAYFUL',
    'TROPICAL',
    'BOYISH',
    'GIRLY',
    'ATHLEISURE'
  ];

  selected = new Set<string>();

  @Output() seleccionChange = new EventEmitter<string[]>();

  toggle(estilo: string) {
    if (this.selected.has(estilo)) {
      this.selected.delete(estilo);
    } else {
      this.selected.add(estilo);
    }
    this.seleccionChange.emit([...this.selected]);
  }
}
