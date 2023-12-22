package com.frostfire.myfinancialapp.dau;


import com.frostfire.myfinancialapp.model.Bank;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BankDaoImpl implements BankDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private List<Bank> banks;

    @Transactional(readOnly = true)
    public List<Bank> getAllBanks() {

        //HibernateCriteriaBuilder cb = sessionFactory.getCurrentSession().createQuery("Bank",Bank.class)
        //JpaCriteriaQuery<Bank> cq = cb.createQuery(Bank.class);

        //JpaRoot<Bank> root = cq.from(Bank.class);
        //TypedQuery<Bank> query = sessionFactory.getCurrentSession().createQuery(cq);
        List<Bank> banks = new ArrayList<Bank>();
        banks = sessionFactory.getCurrentSession().createQuery("from Bank").getResultList();
        System.out.println(banks.size());
        //TypedQuery<Bank> query = sessionFactory.getCurrentSession().createQuery("from Bank");
        return null; //sessionFactory.getCurrentSession().createQuery("SELECT c FROM Bank c", Bank.class).stream().toList();

    }

    @Transactional
    public void addNewBank(Bank bank) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(bank);
    }

    @Transactional
    public void deleteBank(int id) {
        Session session = sessionFactory.getCurrentSession();
        Bank bank = session.byId(Bank.class).load(id);
        session.delete(bank);
    }

    @Transactional
    public void updateBank(Bank bank) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(bank);
    }
}
