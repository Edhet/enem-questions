import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  personalInfoForm!: FormGroup;
  isEditing = false;
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

  private originalUserData = { ...this.user };
  private originalProfileImgUrl = this.profileImgUrl;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.personalInfoForm = this.fb.group({
      fullName: [{ value: this.user.fullName, disabled: true }, Validators.required],
      address: [{ value: this.user.address, disabled: true }, Validators.required],
      phone: [{ value: this.user.phone, disabled: true }, Validators.required],
      birthDate: [{ value: this.user.birthDate, disabled: true }, Validators.required]
    });
  }

  editProfile(): void {
    this.isEditing = true;
    this.personalInfoForm.enable();
  }

  saveChanges(): void {
    if (this.personalInfoForm.valid) {
      Object.assign(this.user, this.personalInfoForm.value);
      this.isEditing = false;
      this.personalInfoForm.disable();
    }
  }

  cancelEdit(): void {
    this.personalInfoForm.patchValue(this.originalUserData);
    this.profileImgUrl = this.originalProfileImgUrl;
    this.isEditing = false;
    this.personalInfoForm.disable();
  }

  onFileChange(event: Event): void {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      const file = input.files[0];
      const reader = new FileReader();
      reader.onload = (e: any) => {
        this.profileImgUrl = e.target.result;
      };
      reader.readAsDataURL(file);
      this.selectedFileName = file.name;
    }
  }
}