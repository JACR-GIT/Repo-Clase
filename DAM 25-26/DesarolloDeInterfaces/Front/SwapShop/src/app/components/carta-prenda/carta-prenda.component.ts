import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-carta-prenda',
  templateUrl: './carta-prenda.component.html',
  styleUrls: ['./carta-prenda.component.scss'],
  standalone: true,
  imports: [CommonModule]
})
export class CartaPrendaComponent {
  @Input() prenda!: { titulo: string; precio: number; imagen: string };
  @Output() cardClick = new EventEmitter<any>();

  onCardClick() {
    this.cardClick.emit(this.prenda);
  }
}
