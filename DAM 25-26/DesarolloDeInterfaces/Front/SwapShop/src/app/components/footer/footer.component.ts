import { Component } from '@angular/core';
import {IonFab, IonFabButton, IonIcon, IonTabBar, IonTabButton, IonTabs} from "@ionic/angular/standalone";
import { addIcons} from "ionicons";
import { addCircleOutline, chatboxOutline, homeOutline } from "ionicons/icons";

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss'],
  imports: [
    IonTabs,
    IonFab,
    IonFabButton,
    IonIcon,
    IonTabBar,
    IonTabButton
  ]
})
export class FooterComponent   {

  constructor() {
    addIcons({
      'add-circle-outline': addCircleOutline,
      'chatbox-outline': chatboxOutline,
      'home-outline': homeOutline
    });
  }



}
