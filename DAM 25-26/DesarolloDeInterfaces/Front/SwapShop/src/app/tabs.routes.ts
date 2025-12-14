import { Routes } from '@angular/router';
import { TabsPage } from './pages/tabs/tabs.page';

export const tabsRoutes: Routes = [
  {
    path: 'tabs',
    component: TabsPage,
    children: [
      {
        path: 'home',
        loadComponent: () =>
          import('./pages/home/home.page').then((m) => m.HomePage),
      },
      {
        path: 'chat',
        loadComponent: () =>
          import('./pages/chat/chat.page').then((m) => m.ChatPage),
      },
      // La ruta de perfil ya no es una pestaña, se ha movido a app.routes.ts
      {
        path: '',
        redirectTo: '/tabs/home',
        pathMatch: 'full',
      },
    ],
  },
  // Redirigir la ruta raíz a la primera pestaña
  {
    path: '',
    redirectTo: '/tabs/home',
    pathMatch: 'full',
  },
];
