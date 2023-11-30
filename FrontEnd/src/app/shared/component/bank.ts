import {AccountType} from './account-type'
export class Bank {
    constructor (
    public id: number,
    public bankName: string,
    public accountNumber: number,
    public accountType: string,
    public balance: number
    ) {}
}
