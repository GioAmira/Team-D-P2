package com.revature.GroupDP2.repository;

import com.revature.GroupDP2.Irepository.IGenericRepository;
import com.revature.GroupDP2.Irepository.IPaymentRepository;
import com.revature.GroupDP2.model.Payment;
import com.revature.GroupDP2.util.StorageManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;


public class PaymentRepository implements IGenericRepository<Payment> {

    private final StorageManager storageManager;
    //private boolean running = false;
    private Session session;


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
        public Payment getByCardNumber(String cardNumber){
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Payment> query = criteriaBuilder.createQuery(Payment.class);

            Root<Payment> paymentTable = query.from(Payment.class);
            query.select(paymentTable)
                    .where(criteriaBuilder.equal(paymentTable.get("cardNumber"), cardNumber));

            return session.createQuery(query).getSingleResult();
        }
    @Override
    public void delete(Payment payment) {
        Transaction tx = session.beginTransaction();
        if(payment != null){
            session.delete(payment);
        }
        tx.commit();
    }

}
