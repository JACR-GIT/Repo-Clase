import { Component, EventEmitter, Output } from '@angular/core';
import { IonicModule } from '@ionic/angular';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-categorias-checkbox',
  standalone: true,
  imports: [IonicModule, CommonModule],
  templateUrl: './categorias-checkbox.component.html',
  styleUrls: ['./categorias-checkbox.component.scss']
})
export class CategoriasCheckboxComponent {

  categorias: string[] = [
    "CAMISETA","CAMISA","TOP","BLUSA","JERSEY","SUDADERA","CHAQUETA","ABRIGO","AMERICANA",
    "PANTALON","VAQUERO","LEGGINGS","SHORTS","FALDA",
    "ROPA_INTERIOR","SUJETADOR","CALZONCILLO","BOXER","BRAGA","BODY",
    "CHANDAL","CAMISETA_DEPORTIVA","PANTALON_DEPORTIVO","MALLAS","TOP_DEPORTIVO",
    "BIKINI","BANADOR","TRIKINI",
    "VESTIDO","MONO","TRAJE","SMOKING",
    "GORRA","SOMBRERO","BUFANDA","GUANTES","CINTURON","CORBATA","PAÑUELO","MOCHILA","BOLSO",
    "ZAPATILLAS","ZAPATOS","BOTAS","SANDALIAS","TACONES",
    "PIJAMA","BATIN","CAMISON",
    "UNIFORME","DISFRAZ"
  ];

  selected = new Set<string>();

  @Output() seleccionChange = new EventEmitter<string[]>();

  toggleCategoria(cat: string) {
    if (this.selected.has(cat)) this.selected.delete(cat);
    else this.selected.add(cat);
    this.seleccionChange.emit([...this.selected]);
  }
}
