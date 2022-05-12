package com.revature.GroupDP2.repository;

import com.revature.GroupDP2.Irepository.IPaymentRepository;
import com.revature.GroupDP2.model.Payment;
import com.revature.GroupDP2.util.StorageManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import java.util.LinkedList;
import java.util.List;

@Component
public class PaymentRepository implements IPaymentRepository<Payment>, Lifecycle {

    private boolean running = false;
    private StorageManager storageManager;
    private  Session session;
    String tableName;

    public PaymentRepository(StorageManager storageManager) {
        this.storageManager = storageManager;
    }

    @Override
    public void save(Payment payment) {
        Transaction tx = session.beginTransaction();
        System.out.println(payment);
        session.save(payment);
        tx.commit();
    }

    @Override
    public void update(Payment payment) {
        Transaction tx = session.beginTransaction();
        session.update(payment);
        tx.commit();
    }

    @Override
    public List<Payment> getAll() {
        String sql = "SELECT * FROM payment";
        Query query = session.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();

        List<Payment> paymentList = new LinkedList<>();
        for(Object[] result : results) {
            Payment payment = new Payment();
            payment.setId((Integer)result[0]);
            payment.setCardNumber((String) result[1]);
            payment.setExpirationDate((String)result[2]);
            payment.setCvvNumber((Integer) result[3]);
            paymentList.add(payment);
        }
        return paymentList;
    }

    @Override
    public Payment getById(Integer id) {
        String hql = " FROM Payment WHERE id = :id";
        TypedQuery<Payment> query = session.createQuery(hql, Payment.class);

        query.setParameter("id", id);

        Payment payment = query.getSingleResult();

        return payment;
    }

    @Override
    public void delete(Payment payment) {
        Transaction tx = session.beginTransaction();
        if(payment != null){
            session.delete(payment);
        }
        tx.commit();
    }

    @Override
    public void start() {
        running = true;
        this.session = storageManager.getSession();
    }

    @Override
    public void stop() {
        running = false;
        this.session.close();
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
