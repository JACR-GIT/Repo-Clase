import { Routes } from '@angular/router';
import { tabsRoutes } from './tabs.routes';

export const routes: Routes = [
  {
    path: 'login',
    loadComponent: () => import('./pages/login/login.page').then(m => m.LoginPage)
  },
  {
    path: 'register',
    loadComponent: () => import('./pages/register/register.page').then(m => m.RegisterPage)
  },
  {
    path: 'user-perfil', // La ruta de perfil ahora es de primer nivel
    loadComponent: () => import('./pages/user-perfil/user-perfil.page').then(m => m.UserPerfilPage)
  },
  // Las rutas de tabs (home, chat) se integran aquí
  ...tabsRoutes,
  // La ruta por defecto sigue siendo el login
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  // Cualquier otra ruta no encontrada redirige a login
  {
    path: '**',
    redirectTo: 'login'
  }
];
