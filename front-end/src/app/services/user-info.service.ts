import { Injectable } from '@angular/core';
import { environment } from '../environment/environment.dev';
import { Usuario } from '../models/usuario.model';
import { AsyncHttpService } from './async-http-service.service';
import { loginGuard } from '../guards/login.guard';

@Injectable({
  providedIn: 'root'
})
export class UserInfoService {
  private readonly USER_INFO_URL = `${environment.apiUrl}/info`;
  private readonly USER_UPDATE_URL = `${environment.apiUrl}/info/atualizar`;
  private readonly USER_DELETE_URL = `${environment.apiUrl}/info/deletar`;


  constructor(private httpClient: AsyncHttpService) { }

  public getUserInfo(): Promise<UserInfoService>  {
    return this.httpClient.getRequest<UserInfoService>(this.USER_UPDATE_URL);
  }


  public updateUserInfo(userInfo: Usuario) {
    return this.httpClient.putRequest<void>(this.USER_INFO_URL, userInfo);
  }

  public deleteUser(userId: number) {
    const url = `${this.USER_DELETE_URL}/${userId}`;
    return this.httpClient.deleteRequest<void>(url);
  }
}
