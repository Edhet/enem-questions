import type { HttpInterceptorFn } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { AuthService } from '../services/auth.service';

export const authorizationInterceptor: HttpInterceptorFn = (req, next) => {
  const authToken = inject(AuthService).getAuthToken();
  const newReq = req.clone({
    headers: req.headers.append("Authorization", `Bearer ${authToken}`)
  });
  return next(authToken ? newReq : req);
};
