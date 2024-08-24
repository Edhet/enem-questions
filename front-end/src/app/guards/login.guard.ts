import { inject } from '@angular/core';
import { Router, type CanActivateFn } from '@angular/router';
import { AuthService } from '../services/auth.service';

export const loginGuard: CanActivateFn = async (route, state) => {
  const usuarioLogado = await inject(AuthService).isLoggedIn();
  const router = inject(Router);

  const rotaDestino = route.routeConfig?.path;
  const indoParaLoginOuRegistro = rotaDestino == 'login' || rotaDestino == 'register';
  
  if (usuarioLogado && indoParaLoginOuRegistro) {
    router.navigate(['home']);
    return false;
  }
  else if (!usuarioLogado && !indoParaLoginOuRegistro) {
    router.navigate(['login']);
    return false;
  }
  return true;
};
