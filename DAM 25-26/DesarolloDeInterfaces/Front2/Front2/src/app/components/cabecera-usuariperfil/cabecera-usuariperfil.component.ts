import {Component, inject, Input, OnInit} from '@angular/core';
import {
  IonAvatar,
  IonBackButton,
  IonButton,
  IonButtons,
  IonContent, IonHeader,
  IonIcon,
  IonTitle, IonToolbar
} from "@ionic/angular/standalone";
import {Router} from "@angular/router";

@Component({
  selector: 'app-cabecera-usuariperfil',
  templateUrl: './cabecera-usuariperfil.component.html',
  styleUrls: ['./cabecera-usuariperfil.component.scss'],
  imports: [
    IonIcon,
    IonHeader,
    IonButton,
    IonAvatar,
    IonTitle,
    IonContent,
    IonToolbar,
    IonButtons,
  ]
})
export class CabeceraUsuariperfilComponent  implements OnInit {

  private routes = inject(Router)
  constructor() { }

  ngOnInit(): void {
        throw new Error("Method not implemented.");
    }
  @Input() username: string = 'Nombre Usuario';
  @Input() rating: number = 4; // de 1 a 5

  protected iniciarHome() {
    console.log('Navegando a la pagina home...');
    this.routes.navigate(['/home']);
  }
}
