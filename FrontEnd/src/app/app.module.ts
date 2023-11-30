import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { NavigationComponent } from './shared/layout/header/navigation/navigation.component';
import { AngularHelpComponent } from './shared/template/angular-help/angular-help.component';
import { HomeComponent } from './main/home/home.component';
import { AccountsComponent } from './main/accounts/accounts.component';
import { BanksComponent } from './main/banks/banks.component';
import { MonthlybillsComponent } from './main/monthlybills/monthlybills.component';

//import { MainFinancialComponent } from './main-financial/main-financial.component';
//import { AccountPayableComponent } from './account-payable/account-payable.component';


@NgModule({
  declarations: [
    AppComponent,

    NavigationComponent,
    AngularHelpComponent,
    HomeComponent,
    AccountsComponent,
    BanksComponent,
    MonthlybillsComponent,

    //MainFinancialComponent,
    //AccountPayableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
