import { Component, OnInit } from '@angular/core';
import {
  IonAvatar,
  IonBackButton,
  IonButtons,
  IonContent, IonFab, IonFabButton,
  IonHeader,
  IonIcon,
  IonToolbar
} from "@ionic/angular/standalone";

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss'],
  imports: [
    IonContent,
    IonIcon,
    IonAvatar,
    IonHeader,
    IonToolbar,
    IonButtons,
    IonBackButton,
    IonFab,
    IonFabButton
  ]
})
export class ChatComponent  implements OnInit {

  constructor() { }

  ngOnInit() {}

}
