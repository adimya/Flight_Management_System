import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { BookingsComponent } from './bookings/bookings.component';
import { FlightDetailsComponent } from './components/flight-details/flight-details.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full',
    title: 'Sign In | BookMyFlight',
  },
  {
    path: 'login',
    component: LoginComponent,
    title: 'Sign In | BookMyFlight',
  },
  {
    path: 'home',
    component: HomeComponent,
    title: 'BookMyFlight',
  },
  {
    path: 'home/:id',
    component: FlightDetailsComponent,
    title: 'Flight Detail | BookMyFlight',
  },
  {
    path: 'admin',
    component: AdminComponent,
    title: 'Admin Panel | BookMyFlight',
  },
  {
    path: 'bookPage',
    component: BookingsComponent,
    title: 'Bookings Tab | BookMyFlight',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
