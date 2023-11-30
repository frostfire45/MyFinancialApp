import { Component } from '@angular/core';
import { BANKS } from './moch-banks';
@Component({
  selector: 'app-banks',
  templateUrl: './banks.component.html',
  styleUrls: ['./banks.component.css']
})
export class BanksComponent {
    accountForms = ['Savings', 'Checking'];
    banks = BANKS;
}
