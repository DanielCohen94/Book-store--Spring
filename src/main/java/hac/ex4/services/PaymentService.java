package hac.ex4.services;

import hac.ex4.repo.Payment;
import hac.ex4.repo.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repo;

    /**
     * save new Payment
     * @param payment new payment
     * @throws Exception - If the payment is invalid
     */
    public void savePayment(Payment payment) throws Exception{
        repo.save(payment);
    }

    /**
     * sum All Payments that Happened so far in the store
     * @return double
     */
    public double sumAllPayments(){
        return repo.sumPaymentsAmount();
    }

    /**
     * delete Payment by id
     * @param id long
     */
    public void deletePayment(long id) {
        repo.deleteById(id);
    }

    /**
     * delete Payment by Payment
     * @param payment Payment
     */
    public void deletePayment(Payment payment) {
        repo.delete(payment);
    }

    /**
     * update Payment by Payment
     * @param payment Payment
     */
    public void updatePayment(Payment payment) {
        repo.save(payment);
    }

    /**
     * get all Payments
     * @return List<Payment>
     */
    public List<Payment> getPayments() {
        return repo.findByOrderByDateDesc();
    }
}
