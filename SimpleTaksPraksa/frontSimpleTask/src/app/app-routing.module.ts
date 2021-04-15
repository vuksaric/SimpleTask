import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { RegistrationPageComponent } from './pages/registration-page/registration-page.component';
import { LandingPageComponent } from './pages/landing-page/landing-page.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GroceriesComponent } from './pages/groceries/groceries/groceries.component';
import { CreateGroceryComponent } from './pages/create-grocery/create-grocery.component';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'landingPage'},
  {path: 'landingPage', component: LandingPageComponent},
  {path: 'registrationPage', component: RegistrationPageComponent},
  {path: 'dashboard', component: DashboardComponent, children: [
    {path: 'viewAllGroceries', component: GroceriesComponent},
    {path: 'createGrocery', component: CreateGroceryComponent}
  ]} 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
