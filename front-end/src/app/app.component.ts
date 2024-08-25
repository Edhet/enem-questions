import { HTTP_INTERCEPTORS, provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { authorizationInterceptor } from './interceptors/authorization.interceptor';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkActive],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Enem Questions';
  iconImgUrl = 'https://i.pinimg.com/736x/c4/a5/28/c4a528acf9fd8db0787f7c36e45178d1.jpg';
}