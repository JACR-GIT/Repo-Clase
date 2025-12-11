import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {
  IonButton, IonCheckbox,
  IonContent,
  IonInput,
  IonLabel, IonRouterLinkWithHref,

} from '@ionic/angular/standalone';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
  standalone: true,
  imports: [IonContent, CommonModule, FormsModule, IonButton, IonInput, IonLabel, IonCheckbox]
})
export class LoginPage  {

  constructor() { }

}
