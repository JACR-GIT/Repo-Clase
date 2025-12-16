import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';

@Component({
  selector: 'app-condicion-checkbox',
  standalone: true,
  imports: [IonicModule, CommonModule],
  templateUrl: './condicion-checkbox.component.html',
  styleUrls: ['./condicion-checkbox.component.scss']
})
export class CondicionCheckboxComponent {

  condiciones: string[] = [
    'MALO',
    'REGULAR',
    'BUENO',
    'MUY_BUENO',
    'EXCELENTE'
  ];

  selected = new Set<string>();

  @Output() seleccionChange = new EventEmitter<string[]>();

  toggle(cond: string) {
    if (this.selected.has(cond)) {
      this.selected.delete(cond);
    } else {
      this.selected.add(cond);
    }
    this.seleccionChange.emit([...this.selected]);
  }
}
