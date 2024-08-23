import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ProfileComponent } from './profile/profile.component';
import { CreateExamComponent } from './create-exam/create-exam.component';


export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'about', component: AboutComponent },
    { path: 'profile', component: ProfileComponent },
    { path: 'create-exam', component: CreateExamComponent },
    { path: 'question-view', component: CreateExamComponent },
    
];

