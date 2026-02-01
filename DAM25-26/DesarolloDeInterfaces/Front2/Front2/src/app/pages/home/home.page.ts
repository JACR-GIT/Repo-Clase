import { Component, OnInit, inject } from '@angular/core';
import {
  IonHeader, IonToolbar, IonButtons, IonBackButton, IonSearchbar,
  IonTitle, IonContent, IonGrid, IonRow, IonCol, IonCard,
  IonCardContent, IonImg, IonIcon,
  IonFooter, IonModal, IonItem, IonLabel, IonInput,
  IonButton, IonButtons as IonModalButtons, IonTextarea
} from '@ionic/angular/standalone';
import { addIcons } from 'ionicons';
import { personCircleOutline, homeOutline, chatbubbleOutline, add, close } from 'ionicons/icons';
import { PrendasService } from '../../servicios/prendas-services/prendas-service';
import { PrendasDTO } from '../../modelos/PrendasDTO';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
  standalone: true,
  imports: [
    CommonModule, FormsModule, RouterModule,
    IonHeader, IonToolbar, IonButtons, IonBackButton, IonSearchbar,
    IonTitle, IonContent, IonGrid, IonRow, IonCol, IonCard,
    IonCardContent, IonImg, IonIcon,
    IonFooter, IonModal, IonItem, IonLabel, IonInput,
    IonButton, IonModalButtons, IonTextarea
  ]
})
export class HomePage implements OnInit {
  prendas: PrendasDTO[] = [];
  prendasFiltradas: PrendasDTO[] = [];
  prendaSeleccionada: PrendasDTO | null = null;
  esNueva = false;
  textoBusqueda = '';

  usuarioId = 1;

  private prendasService = inject(PrendasService);

  constructor() {
    addIcons({ personCircleOutline, homeOutline, chatbubbleOutline, add, close });
  }

  ngOnInit() {
    this.cargarPrendas();
  }

  cargarPrendas() {
    this.prendasService.obtenerTodasDisponibles().subscribe({
      next: (data: PrendasDTO[]) => {
        this.prendas = data;
        this.filtrar();
        console.log('Prendas cargadas:', this.prendas);  // Para depurar en consola
      },
      error: (err) => console.error('Error cargando todas las prendas', err)
    });
  }

  buscar(event: any) {
    this.textoBusqueda = event.target.value?.toLowerCase() || '';
    this.filtrar();
  }

  filtrar() {
    if (!this.textoBusqueda) {
      this.prendasFiltradas = this.prendas;
    } else {
      this.prendasFiltradas = this.prendas.filter(p =>
        p.nombre_prenda?.toLowerCase().includes(this.textoBusqueda) ||
        p.categoria?.toLowerCase().includes(this.textoBusqueda)
      );
    }
  }

  abrirDetalle(prenda?: PrendasDTO) {
    this.prendaSeleccionada = prenda ? { ...prenda } : {
      id_dueno: { id: this.usuarioId } as any,
      disponible: true
    };
    this.esNueva = !prenda;
    const modal = document.querySelector('ion-modal');
    if (modal) modal.isOpen = true;
  }

  guardar() {
    if (!this.prendaSeleccionada) return;

    if (this.esNueva) {
      this.prendasService.crear(this.prendaSeleccionada).subscribe({
        next: () => {
          this.cargarPrendas();
          this.cerrarModal();
        },
        error: (err) => console.error('Error creando prenda', err)
      });
    } else {
      this.prendasService.actualizar(this.prendaSeleccionada).subscribe({
        next: () => {
          this.cargarPrendas();
          this.cerrarModal();
        },
        error: (err) => console.error('Error actualizando prenda', err)
      });
    }
  }

  eliminar() {
    if (!this.prendaSeleccionada?.id) return;
    if (confirm('¿Seguro que quieres eliminar esta prenda?')) {
      this.prendasService.eliminar(this.prendaSeleccionada.id).subscribe({
        next: () => {
          this.cargarPrendas();
          this.cerrarModal();
        },
        error: (err) => console.error('Error eliminando prenda', err)
      });
    }
  }

  cerrarModal() {
    const modal = document.querySelector('ion-modal');
    if (modal) modal.isOpen = false;
  }

  irAPerfil() {
    alert('Ir a perfil (página pendiente)');
  }

  irAChats() {
    alert('Ir a chats (página pendiente)');
  }
}
