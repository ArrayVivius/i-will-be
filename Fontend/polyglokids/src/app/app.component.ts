import { Component, inject } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { CommonModule } from '@angular/common';
import { InitDashboardComponent } from './pages/components/init-dashboard/init-dashboard.component';
import { FullCalendarModule } from '@fullcalendar/angular';
import { CoursesComponent } from './pages/courses/courses.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    HomeComponent,
    LoginComponent,
    DashboardComponent,
    InitDashboardComponent,
    FullCalendarModule,
    CoursesComponent,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {}
