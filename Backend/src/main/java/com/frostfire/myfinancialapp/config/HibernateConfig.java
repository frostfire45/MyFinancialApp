package com.frostfire.myfinancialapp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
// Using annotation This is pointing a file not xml. You could do this in an
// xml format and then reference it getSessionFactory()
@PropertySource("classpath:application.properties")
@EnableTransactionManagement // Allow for spring annotation driven transaction.
@ComponentScans( @ComponentScan("com.frostfire.myfinancialapp"))
public class HibernateConfig {

    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        //sessionFactor.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
        sessionFactory.setPackagesToScan(new String[] {
                "com.frostfire.myfinancialapp.model"
        });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
    // Method breakdowns
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName.mysql"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }

    /*
    ===================================================================================================================
    # HibernateTransactionManager
    # binds a Hibernate Session from the specified factory to the thread, potentially
    # allowing for one thread-bound Session per factory. This transaction manager is appropriate for applications
    # that use a single Hibernate SessionFactory for transactional data access, but it also supports direct
    # DataSource access within a transaction i.e. plain JDBC
    #-----------------------------------------------------------------------------------------------------------------*/
    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
}
