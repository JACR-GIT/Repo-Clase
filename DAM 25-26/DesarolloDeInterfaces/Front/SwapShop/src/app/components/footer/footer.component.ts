import { Component, EventEmitter, Output } from '@angular/core';
import { IonicModule } from '@ionic/angular';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss'],
  standalone: true,
  imports: [IonicModule]
})
export class FooterComponent {
  @Output() addPrendaClick = new EventEmitter<void>();

  constructor() { }

  onAddPrendaClick() {
    this.addPrendaClick.emit();
  }
}
