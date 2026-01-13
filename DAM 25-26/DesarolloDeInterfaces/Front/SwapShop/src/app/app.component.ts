import { Component } from '@angular/core';
import {IonApp, IonRouterLink, IonRouterOutlet} from '@ionic/angular/standalone';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  imports: [IonApp, IonRouterOutlet],
  standalone: true
})
export class AppComponent {
  constructor() {}
}
