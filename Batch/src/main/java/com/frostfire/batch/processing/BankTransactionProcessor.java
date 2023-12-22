package com.frostfire.batch.processing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class BankTransactionProcessor implements ItemProcessor<BankTransaction,BankTransaction> {
    private static final Logger log = LoggerFactory.getLogger(BankTransaction.class);

    @Override
    public BankTransaction process(BankTransaction item) throws Exception {
        final String post_date = item.post_date().toUpperCase();
        final double amount = item.amount();
        final int check_number = item.check_number();
        final String payee = item.payee().toUpperCase();
        final String memo = item.memo().toUpperCase();
        final int account = item.account();
        final BankTransaction transformed_BankTransaction =
                new BankTransaction(post_date,amount,check_number,payee,memo,account);

        log.info("Convert (" + item + ") into (" + transformed_BankTransaction + ")");
        return transformed_BankTransaction;
    }
}
