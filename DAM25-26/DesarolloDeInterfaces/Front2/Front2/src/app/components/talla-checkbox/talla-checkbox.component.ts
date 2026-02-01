import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';

@Component({
  selector: 'app-talla-checkbox',
  standalone: true,
  imports: [IonicModule, CommonModule],
  templateUrl: './talla-checkbox.component.html',
  styleUrls: ['./talla-checkbox.component.scss']
})
export class TallaCheckboxComponent {

  tallas: string[] = [
    'XS',
    'S',
    'M',
    'L',
    'XL',
    'XXL'
  ];

  selected = new Set<string>();

  @Output() seleccionChange = new EventEmitter<string[]>();

  toggle(talla: string) {
    if (this.selected.has(talla)) {
      this.selected.delete(talla);
    } else {
      this.selected.add(talla);
    }
    this.seleccionChange.emit([...this.selected]);
  }
}
