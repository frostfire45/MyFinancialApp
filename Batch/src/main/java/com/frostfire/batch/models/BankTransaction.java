package com.frostfire.batch.models;

public class BankTransaction {
    private String post_date;
    private double amount;
    private int check_number;
    private String payee;
    private String memo;
    private int account;

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCheck_number() {
        return check_number;
    }

    public void setCheck_number(int check_number) {
        this.check_number = check_number;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
}
