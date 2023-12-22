package com.frostfire.batch.processing;

public record BankTransaction(String post_date, double amount, int check_number, String payee, String memo, int account) {
}
