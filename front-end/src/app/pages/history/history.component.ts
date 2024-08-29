import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

// TALVEZ EU MUDE O CAMINHO DE ONDE VEM AS PROVAS?
import { Prova } from './prova.model';

@Component({
  selector: 'app-history',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent {
  // EXEMPLO COM INFORMAÇÃO DE 7 PROVAS
  provas: Prova[] = [
    {
      dataRealizacao: new Date(2024, 7, 28), // Agosto de 2024
      informacoes: { dia: '1º Dia', ano: 2023 },
      cor: 'Amarelo',
      acertos: 43,
      erros: 47
    },
    {
      dataRealizacao: new Date(2024, 7, 24),
      informacoes: { dia: '2º Dia', ano: 2022 },
      cor: 'Rosa',
      acertos: 28,
      erros: 62
    },
    {
      dataRealizacao: new Date(2024, 7, 23),
      informacoes: { dia: '1º Dia', ano: 2023 },
      cor: 'Azul',
      acertos: 30,
      erros: 60
    },
    {
      dataRealizacao: new Date(2024, 7, 22),
      informacoes: { dia: '2º Dia', ano: 2022 },
      cor: 'Branco',
      acertos: 29,
      erros: 61
    },
    {
      dataRealizacao: new Date(2024, 7, 21),
      informacoes: { dia: '1º Dia', ano: 2023 },
      cor: 'Amarelo',
      acertos: 15,
      erros: 75
    },
    {
      dataRealizacao: new Date(2024, 7, 20),
      informacoes: { dia: '2º Dia', ano: 2022 },
      cor: 'Rosa',
      acertos: 33,
      erros: 57
    },
    {
      dataRealizacao: new Date(2024, 7, 19),
      informacoes: { dia: '1º Dia', ano: 2023 },
      cor: 'Azul',
      acertos: 39,
      erros: 51
    }
  ];

  currentPage = 0;
  itemsPerPage = 5;

  get paginatedProvas(): Prova[] {
    const start = this.currentPage * this.itemsPerPage;
    const end = start + this.itemsPerPage;
    return this.provas.slice(start, end);
  }

  get totalPages(): number {
    return Math.ceil(this.provas.length / this.itemsPerPage);
  }

  get isLastPage(): boolean {
    return this.currentPage === this.totalPages - 1;
  }

  get showNextButton(): boolean {
    return !this.isLastPage && this.provas.length > this.itemsPerPage;
  }

  get showPreviousButton(): boolean {
    return this.currentPage > 0;
  }

  nextPage() {
    if (!this.isLastPage) {
      this.currentPage++;
    }
  }

  previousPage() {
    if (this.currentPage > 0) {
      this.currentPage--;
    }
  }
}