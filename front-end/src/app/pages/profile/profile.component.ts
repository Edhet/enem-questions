import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterLink, RouterLinkActive],
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  profileImgUrl = 'https://i.pinimg.com/564x/69/76/39/6976397d27eed9f81a8ee9f806ccf492.jpg';
  selectedFileName: string | null = null;

  user = {
    name: 'Nome do Usuário',
    email: 'email@example.com',
    membershipDate: new Date(2024, 7),
    about: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quis lorem ut libero malesuada feugiat.',
    fullName: 'João da Silva',
    address: 'Rua Exemplo, 123, Cidade, Estado',
    phone: '(11) 99999-9999',
    birthDate: '1990-10-10'
  };

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    // No form initialization needed
  }

  onFileChange(event: Event): void {
    // Remove the file change handler
  }

  confirmDeleteAccount(): void {
    const confirmation = confirm('Tem certeza de que deseja excluir sua conta? Esta ação não pode ser desfeita.');
    if (confirmation) {
      this.deleteAccount();
    }
  }

  private deleteAccount(): void {
    alert('Conta excluída com sucesso!');
  }
}