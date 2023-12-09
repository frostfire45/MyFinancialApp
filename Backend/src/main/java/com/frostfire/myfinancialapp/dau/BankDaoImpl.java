package com.frostfire.myfinancialapp.dau;


import com.frostfire.myfinancialapp.model.Bank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BankDaoImpl implements BankDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Bank> getAllBanks() {
        Session session = sessionFactory.getCurrentSession();
        HibernateCriteriaBuilder cb = session.getCriteriaBuilder();
        JpaCriteriaQuery<Bank> cq = cb.createQuery(Bank.class);
        JpaRoot<Bank> root = cq.from(Bank.class);
        Query<Bank> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void addNewBank(Bank bank) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(bank);
    }

    @Override
    public void deleteBank(int id) {
        Session session = sessionFactory.getCurrentSession();
        Bank bank = session.byId(Bank.class).load(id);
        session.delete(bank);
    }

    @Override
    public void updateBank(Bank bank) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(bank);
    }
}
