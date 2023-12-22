package com.frostfire.batch.config;

import javax.sql.DataSource;
import com.frostfire.batch.processing.BankTransaction;
import com.frostfire.batch.processing.BankTransactionProcessor;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class BatchConfiguration {
    @Bean
    public FlatFileItemReader<BankTransaction> reader(){
        return new FlatFileItemReaderBuilder<BankTransaction>()
                .name("BankTransactionReader")
                .resource(new ClassPathResource("baseline/transactions.CSV"))
                .delimited()
                .names("Post_Date","Amount","Check_Number","Payee","Memo","account")
                .targetType(BankTransaction.class)
                .build();
    }
    @Bean
    public BankTransactionProcessor processor(){
        return new BankTransactionProcessor();
    }
    @Bean
    public JdbcBatchItemWriter<BankTransaction> writer (DataSource datasource){
        return new JdbcBatchItemWriterBuilder<BankTransaction>()
                .sql("INSERT INTO Bank_Transaction (post_date,amount,check_number,payee,memo,account)"
                        + "VALUES (:Post_Date,:Amount, :Check_Number, :Payee, :Memo, :account)")
                .dataSource(datasource)
                .beanMapped()
                .build();
    }
}
