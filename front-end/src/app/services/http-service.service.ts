import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  constructor(private httpClient: HttpClient) { }

  public getRequest<Response>(url: string): Promise<Response> {
    return firstValueFrom(this.httpClient.get<Response>(url));
  }

  public postRequest<Response>(url: string, body: any): Promise<Response> {
    return firstValueFrom(this.httpClient.post<Response>(url, body));
  }

  public deleteRequest<Response>(url: string): Promise<Response> {
    return firstValueFrom(this.httpClient.delete<Response>(url));
  }

  public putRequest<Response>(url: string, body: any): Promise<Response> {
    return firstValueFrom(this.httpClient.put<Response>(url, body));
  }

  public patchRequest<Response>(url: string, body?: any): Promise<Response> {
    return firstValueFrom(this.httpClient.patch<Response>(url, body));
  }
}
