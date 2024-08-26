import { Injectable } from '@angular/core';
import { environment } from '../environment/environment.dev';
import { Prova } from '../models/prova.model';
import { AsyncHttpService } from './async-http-service.service';
import { loginGuard } from '../guards/login.guard';

@Injectable({
  providedIn: 'root'
})
export class ExamService {
  private readonly PROVA_URL = `${environment.apiUrl}/prova`;
  private readonly ALL_PROVAS_URL = `${environment.apiUrl}/prova/all`;
  private readonly NOVA_PROVA_URL = `${environment.apiUrl}/prova/nova`;
  private readonly PROVA_UPDATE_URL = `${environment.apiUrl}/prova/atualizar`;
  private readonly PROVA_DELETE_URL = `${environment.apiUrl}/prova/deletar`;

  constructor(private httpClient: AsyncHttpService) { }

  public getAllProva(): Promise<ExamService>  {
    return this.httpClient.getRequest<ExamService>(this.ALL_PROVAS_URL);
  }

  public getProva(provaId: number): Promise<ExamService>{
    const url = `${this.PROVA_URL}/${provaId}`
    return this.httpClient.getRequest<ExamService>(url);
  }

  public novaProva(prova: ExamService){
    return this.httpClient.postRequest<ExamService>(this.NOVA_PROVA_URL, prova)

  }
  public updateProva(prova: Prova){
    return this.httpClient.putRequest<ExamService>(this.PROVA_UPDATE_URL, prova)

  }
  public deleteProva(provaId: number){
    const url = `${this.PROVA_DELETE_URL}/${provaId}`
    return this.httpClient.deleteRequest<ExamService>(url);
  }
}
