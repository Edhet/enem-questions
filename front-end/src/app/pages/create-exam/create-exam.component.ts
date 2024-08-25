import { Component } from '@angular/core';
import { DiaDeProva } from '../../models/dia-de-prova.model';
import { AreaProva } from '../../models/area-prova.model';

@Component({
  selector: 'app-create-exam',
  standalone: true,
  imports: [],
  templateUrl: './create-exam.component.html',
  styleUrl: './create-exam.component.css'
})
export class CreateExamComponent {
  examOptions = {
    ano: new Date().getFullYear(),
    diaDeProva: DiaDeProva.PRIMEIRO,
    areaProva: AreaProva.EXATAS
  };

  // constructor(
  //   private asyncHttpService: AsyncHttpServiceService,
  //   private router: Router
  // ) {}

  // async startExam() {
  //   const exam = await this.asyncHttpService.postRequest<Prova>(
  //     '/api/start-exam',
  //     this.examOptions
  //   );

  //   // Armazenar a prova iniciada no localStorage ou serviço de estado
  //   localStorage.setItem('currentExam', JSON.stringify(exam));
  //   this.router.navigate(['/take-exam']);
  // }
}
