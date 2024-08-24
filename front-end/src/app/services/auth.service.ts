import { Injectable } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { AsyncHttpService } from './async-http-service.service';
import { LoginRequest } from '../models/login-request.model';
import { environment } from '../environment/environment.dev';
import { LoginResponse } from '../models/login-response.model';
import { CadastroRequest } from '../models/cadastro-request.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private readonly AUTH_TOKEN_COOKIE = "authToken";

  private readonly AUTH_URL = `${environment.apiUrl}/auth`;
  private readonly LOGIN_URL = `${environment.apiUrl}/auth/login`;
  private readonly CADASTRO_URL = `${environment.apiUrl}/auth/cadastro`;

  constructor(private httpClient: AsyncHttpService, private cookieService: CookieService) { }

  private setAuthToken(token: string) {
    this.cookieService.set(this.AUTH_TOKEN_COOKIE, token);
  }

  public getAuthToken() {
    return this.cookieService.get(this.AUTH_TOKEN_COOKIE);
  }

  public isLoggedIn() {
    if (!this.getAuthToken())
      return false;

    return this.httpClient.getRequest(this.AUTH_URL)
      .then(_r => true)
      .catch(_r => false);
  }

  public login(loginRequest: LoginRequest) {
    return this.httpClient.postRequest<LoginResponse>(this.LOGIN_URL, loginRequest)
    .then(r => this.setAuthToken(r.token))
    .catch(r => r as Error);
  }

  public cadastro(cadastroRequest: CadastroRequest) {
    return this.httpClient.postRequest<LoginResponse>(this.CADASTRO_URL, cadastroRequest)
    .then(r => this.setAuthToken(r.token))
    .catch(r => r as Error);
  }
}
