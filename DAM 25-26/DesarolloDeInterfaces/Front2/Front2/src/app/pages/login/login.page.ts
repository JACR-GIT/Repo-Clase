import {Component, inject} from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {
  IonButton, IonCheckbox,
  IonContent,
  IonInput,
  IonLabel, IonRouterLink, IonRouterLinkWithHref,

} from '@ionic/angular/standalone';
import {Router, RouterLink} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
  standalone: true,
  imports: [IonContent, CommonModule, FormsModule, IonButton, IonInput, IonLabel, IonCheckbox, IonRouterLink, RouterLink]
})
export class LoginPage  {
  private routes = inject(Router)
  constructor() { }

  protected register() {
    console.log('Navegando a la página de registro...');
    this.routes.navigate(['/register']);

  }

  protected iniciarSesion() {
    console.log('Navegando a la pagina de tabs/home...');
    this.routes.navigate(['/tabs/home']);
  }
}
