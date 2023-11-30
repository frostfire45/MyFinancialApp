import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AngularHelpComponent } from './shared/template/angular-help/angular-help.component';
import { BanksComponent } from './main/banks/banks.component';
import { AccountsComponent } from './main/accounts/accounts.component';
import { MonthlybillsComponent } from './main/monthlybills/monthlybills.component';
import { HomeComponent } from './main/home/home.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'AngularHelp', component: AngularHelpComponent},
  { path: 'bank-app', component: BanksComponent},
  { path: 'account-app', component: AccountsComponent},
  { path: 'monthly-bills', component: MonthlybillsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
