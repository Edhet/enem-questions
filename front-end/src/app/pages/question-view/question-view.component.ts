import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-question-view',
  standalone: true,
  imports: [FormsModule,  CommonModule],
  templateUrl: './question-view.component.html',
  styleUrl: './question-view.component.css'
})
export class QuestionViewComponent {
  currentQuestionIndex = 0;
  selectedOptions: { [key: number]: string | null } = {}; // Armazena a seleção para cada pergunta

  // EXEMPLO DE COMO SERIA

  questions = [
    {
      number: 1,
      content: 'Conteúdo da questão 1',
      options: ['Opção A', 'Opção B', 'Opção C', 'Opção D', 'Opção E'],
      image: 'https://s2-techtudo.glbimg.com/JsE244mucjKWLYtNgeiDyfVYlJQ=/0x129:1024x952/888x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2023/7/i/ME2AxRRoygUyFPCDe0jQ/3.png'
    },
    {
      number: 2,
      content: 'Conteúdo da questão 2',
      options: ['Opção A', 'Opção B', 'Opção C', 'Opção D', 'Opção E']
    },
    {
      number: 3,
      content: 'Conteúdo da questão 3',
      options: ['Opção A', 'Opção B', 'Opção C', 'Opção D', 'Opção E'],
      image: 'https://dm0fehhuxv6f6.cloudfront.net/wp-content/uploads/2023/04/30035515/bing-panda-600x600.jpg'
    },
    {
      number: 4,
      content: 'Conteúdo da questão 4',
      options: ['Opção A', 'Opção B', 'Opção C', 'Opção D', 'Opção E']
    },
    {
      number: 5,
      content: 'Conteúdo da questão 5',
      options: ['Opção A', 'Opção B', 'Opção C', 'Opção D', 'Opção E']
    }
  ];

  constructor() {
    this.loadSelections();
  }

  get selectedOption(): string | null {
    return this.selectedOptions[this.currentQuestionIndex] || null;
  }

  set selectedOption(option: string | null) {
    this.selectedOptions[this.currentQuestionIndex] = option;
  }

  nextQuestion() {
    if (this.currentQuestionIndex < this.questions.length - 1) {
      this.currentQuestionIndex++;
      this.loadSelections();
    }
  }

  previousQuestion() {
    if (this.currentQuestionIndex > 0) {
      this.currentQuestionIndex--;
      this.loadSelections();
    }
  }

  selectOption(option: string) {
    this.selectedOption = option;
  }

  pauseExam() {
    // Lógica para pausar a prova e redirecionar para a home
  }

  finishExam() {
    // Lógica para finalizar a prova e redirecionar para a home
  }

  private loadSelections() {
    // Carrega a seleção salva para a pergunta atual
    this.selectedOption = this.selectedOptions[this.currentQuestionIndex] || null;
  }
}