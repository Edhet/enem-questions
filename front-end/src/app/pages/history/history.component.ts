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
      dataRealizacao: new Date(2024, 0, 15), // Janeiro de 2024
      informacoes: { dia: '1º Dia', ano: 2023 },
      cor: 'Amarelo',
      acertos: 10,
      erros: 80
    },
    {
      dataRealizacao: new Date(2024, 1, 22), // Fevereiro de 2024
      informacoes: { dia: '2º Dia', ano: 2022 },
      cor: 'Rosa',
      acertos: 20,
      erros: 70
    },
    {
      dataRealizacao: new Date(2024, 2, 5), // Março de 2024
      informacoes: { dia: '1º Dia', ano: 2023 },
      cor: 'Azul',
      acertos: 30,
      erros: 60
    },
    {
      dataRealizacao: new Date(2024, 3, 10), // Abril de 2024
      informacoes: { dia: '2º Dia', ano: 2022 },
      cor: 'Branco',
      acertos: 25,
      erros: 65
    },
    {
      dataRealizacao: new Date(2024, 4, 18), // Maio de 2024
      informacoes: { dia: '1º Dia', ano: 2023 },
      cor: 'Amarelo',
      acertos: 15,
      erros: 75
    },
    {
      dataRealizacao: new Date(2024, 5, 25), // Junho de 2024
      informacoes: { dia: '2º Dia', ano: 2022 },
      cor: 'Rosa',
      acertos: 40,
      erros: 50
    },
    {
      dataRealizacao: new Date(2024, 6, 30), // Julho de 2024
      informacoes: { dia: '1º Dia', ano: 2023 },
      cor: 'Azul',
      acertos: 35,
      erros: 55
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