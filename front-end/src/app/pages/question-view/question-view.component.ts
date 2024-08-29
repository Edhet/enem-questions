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
      content: 'Ao retratar o ambiente de trabalho em um escritório, esse cartum tem por objetivo',
      options: ['criticar um padrão de vestimenta.', 'destacar a falta de diversidade.', 'indicar um modo de interação.', 'elogiar um modelo de organização.', 'salientar o espírito de cooperação.'],
      image: 'https://i.pinimg.com/736x/91/cf/86/91cf862dec2b37bd366291f52312b8aa.jpg'
    },
    {
      number: 2,
      content: 'Nesse poema, a expressão “No man is an island” ressalta o(a)',
      options: ['medo da morte.', 'ideia de conexão.', 'conceito de solidão.', 'risco de devastação.', 'necessidade de empatia.'],
      image: 'https://i.pinimg.com/736x/83/f9/51/83f951bc3fce0bc911dbd60025808f99.jpg'
    },
    {
      number: 3,
      content: 'Esse cartaz de campanha sugere que',
      options: ['os lixões precisam de ampliação. ', 'o desperdício degrada o ambiente.', 'os mercados doam alimentos perecíveis.', 'a desnutrição compromete o raciocínio.', 'as residências carecem de refrigeradores.'],
      image: 'https://i.pinimg.com/736x/b9/35/4e/b9354e8eeeafa35d78a47934a857cbc0.jpg'
    },
    {
      number: 4,
      content: 'Ao retratar a trajetória de refugiados, o poema recorre à imagem de viagem marítima para destacar o(a)',
      options: ['risco de choques culturais.', 'impacto do ensino de história.', 'importância da luta ambiental.', 'existência de experiências plurais.', 'necessidade de capacitação profissional.'],
      image: 'https://i.pinimg.com/736x/af/85/86/af8586b6c6837a050f6aebeab56c9b25.jpg'
    },
    {
      number: 5,
      content: 'Nesse poema de Tato Laviera, o eu lírico destaca uma',
      options: ['convergência linguístico-cultural.', 'característica histórico-cultural.', 'tendência estilístico-literária.', 'discriminação cultural.', 'censura musical.'],
      image: 'https://i.pinimg.com/736x/76/ec/06/76ec06182202956138fe868a9f7ddb32.jpg'
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