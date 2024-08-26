import { Injectable } from '@angular/core';
import { environment } from '../environment/environment.dev';
import { AsyncHttpService } from './async-http-service.service';
import { AplicacaoProva } from '../models/aplicacao-prova.model';
import { Resposta } from '../models/resposta.model';

@Injectable({
  providedIn: 'root'
})
export class ExamAplicationService {
  private readonly APLICACAO_PROVA_URL = `${environment.apiUrl}/aplicacao-prova`;
  private readonly NOVA_APLICACAO_PROVA_URL = `${environment.apiUrl}/aplicacao-prova/novo`;
  private readonly APLICACAO_PROVA_DELETE_URL = `${environment.apiUrl}/aplicacao-prova/deletar`;

  constructor(private httpClient: AsyncHttpService) { }
  public getAplicacaoProva(aplicacaoId: number): Promise<ExamAplicationService>  {
    const url = `${this.APLICACAO_PROVA_URL}/${aplicacaoId}`
    return this.httpClient.getRequest<ExamAplicationService>(url);
  }

  public novaAplicacao(aplicacaoProva: ExamAplicationService){
    return this.httpClient.postRequest<ExamAplicationService>(this.NOVA_APLICACAO_PROVA_URL, aplicacaoProva)

  }

  public responderAplicacao(aplicacaoId: AplicacaoProva, respostas: Array<Resposta>){
    const url = `${this.APLICACAO_PROVA_URL}/${aplicacaoId}/responder`
    return this.httpClient.putRequest<ExamAplicationService>(url, respostas)

  }

  public finalizarAplicacao(aplicacaoId: AplicacaoProva){
    const url = `${this.APLICACAO_PROVA_URL}/${aplicacaoId}/finalizar`
    return this.httpClient.patchRequest<ExamAplicationService>(url)

  }
  public deleteProva(aplicacaoId: number){
    const url = `${this.APLICACAO_PROVA_DELETE_URL}/${aplicacaoId}`
    return this.httpClient.deleteRequest<ExamAplicationService>(url);
  }
}
