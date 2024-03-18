import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'app/services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent {
  email = '';
  password = '';
  authService = inject(AuthService);
  router = inject(Router);
  errorMessage: string = '';

  login(event: Event) {
    event.preventDefault();
    console.log(`Login: ${this.email} / ${this.password}`);
    this.authService
      .login({
        email: this.email,
        password: this.password,
      })
      .subscribe({
        next: () => {
          alert('Login success!');
          this.router.navigate(['/dashboard']);
        },
        error: (err) => {
          this.errorMessage =
            'Usuario no encontrado o credenciales incorrectas.';
          alert(this.errorMessage);
        },
      });
    //       () => {
    //         alert('Login success!');
    //         this.router.navigate(['/dashboard']);
    //       },
    //       (error) => {
    //         // Maneja el error aquí
    //         this.errorMessage =
    //           'Usuario no encontrado o credenciales incorrectas.';
    //       },
    //     );
    // }
  }
}
