import {Component, inject} from '@angular/core';
import {
  IonContent,
  IonButton,
  IonIcon,
  IonInput,
  IonLabel,
  IonCheckbox, // Si lo usas en el futuro
  IonDatetime, IonRouterLink
} from '@ionic/angular/standalone';
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.page.html',
  styleUrls: ['./register.page.scss'],
  standalone: true,
  imports: [
    IonContent,
    IonButton,
    IonIcon,
    IonInput,
    IonLabel,
    IonRouterLink,
    // IonCheckbox,  // Descomenta si lo necesitas más adelante
    // CommonModule, FormsModule si usas ngModel, etc.
  ]
})
export class RegisterPage {

  private routes = inject(Router)
  constructor() { }

  protected iniciarSesion(): void {
    console.log('Navegando a la página de login...');
    this.routes.navigate(['/login']);
  }

  protected crearCuenta(): void {
    console.log('Navegando a la página de tabs/home...');
    this.routes.navigate(['/tabs/home']);
  }
}
